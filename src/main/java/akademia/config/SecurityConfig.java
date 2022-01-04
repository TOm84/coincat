package akademia.config;

import akademia.authorize.CustomUserService;
import akademia.repository.UserAppRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = UserAppRepository.class)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;
  private final CustomUserService customUserService;

  public SecurityConfig(PasswordEncoder passwordEncoder, CustomUserService customUserService) {
    this.passwordEncoder = passwordEncoder;
    this.customUserService = customUserService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().disable();
    http.csrf().disable();

    http
        .authorizeRequests()
        .antMatchers("/login**", "/register**").permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/signin")
        .usernameParameter("username")
        .passwordParameter("password")
        .failureUrl("/login?error=wrong login or password!")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(customUserService)
        .passwordEncoder(passwordEncoder);
  }
}
