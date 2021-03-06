package akademia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long roleId;
  private String role;

  @JsonIgnore
  @ManyToMany(mappedBy = "roles")
  private Set<UserApp> user = new HashSet<>();

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Set<UserApp> getUser() {
    return user;
  }

  public void setUser(Set<UserApp> user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Role{" +
        "roleId=" + roleId +
        ", role='" + role + '\'' +
        ", user=" + user +
        '}';
  }

}
