package akademia.authorize;

import akademia.model.UserApp;
import akademia.repository.UserAppRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static akademia.commons.Variables.DB_PASSWORD;
import static akademia.commons.Variables.DB_URL;
import static akademia.commons.Variables.DB_USER;

@Component
public class RegisterUser extends UserApp {
  public final UserAppRepository userAppRepository;

  public RegisterUser(UserAppRepository userAppRepository) {
    this.userAppRepository = userAppRepository;
  }

  public String regUser(UserApp userApp) {
    try (
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement statement =
            connection.prepareStatement(
                "INSERT INTO user values (?,?,?,?,?,?,?);");
        PreparedStatement updateUserRole =
            connection.prepareStatement("INSERT INTO user_role (user_id, role_id) values (?,?)");
    ){
      Integer counter = userAppRepository.quantityUser() +1;
      String encodedPassword = new BCryptPasswordEncoder().encode(userApp.getPassword());

      statement.setString(1, String.valueOf(counter));
      statement.setString(2, String.valueOf(userApp.getActive()));
      statement.setString(3, String.valueOf(userApp.getLogin()));
      statement.setString(4, String.valueOf(userApp.getName()));
      statement.setString(5, String.valueOf(userApp.getLastname()));
      statement.setString(6, String.valueOf(userApp.getEmail()));
      statement.setString(7, String.valueOf(encodedPassword));
      updateUserRole.setInt(1, counter);
      updateUserRole.setInt(2, userApp.getActive());

      statement.executeUpdate();
      updateUserRole.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return null;
  }
}
