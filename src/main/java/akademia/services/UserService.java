package akademia.services;

import akademia.model.UserApp;
import akademia.repository.UserAppRepository;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static akademia.commons.Variables.DB_PASSWORD;
import static akademia.commons.Variables.DB_URL;
import static akademia.commons.Variables.DB_USER;

@Service
public class UserService {
  private final UserAppRepository userAppRepository;

  public UserService(UserAppRepository userAppRepository) {
    this.userAppRepository = userAppRepository;
  }

  public List<UserApp> getAllUser () {
    return userAppRepository.findAll();
  }

  public List<UserApp> getAllNormalUser () {
    return userAppRepository.findAllNormalUser();
  }

  public String deleteUserAccount(int id) {
    try (
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement statement =
            connection.prepareStatement("delete from user where id = ?");
        PreparedStatement deleteUserRole =
            connection.prepareStatement("DELETE FROM user_role WHERE user_id = ?");
    ) {
      statement.setInt(1, id);
      deleteUserRole.setInt(1, id);
      statement.executeUpdate();
      deleteUserRole.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return null;
  }
}
