package akademia.repository;

import akademia.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Long>{


  @Query(value = "select user from UserApp user where user.login = ?1")
  Optional<UserApp> findUserByUsername(String s);


  @Query(value = "select * from user where active = 2", nativeQuery = true)
  List<UserApp> findAllNormalUser();

  @Query(value = "select count(*) from user", nativeQuery = true)
  Integer quantityUser();

}
