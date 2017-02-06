package com.gostgroup.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gostgroup.test.model.serialize.UserSerializer;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by e.medvedev on 26.01.2017.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "test")
@JsonSerialize(using = UserSerializer.class)
public class UsersEntity {
  @JsonIgnore
  private int id;
  @NotEmpty(message = "User login is required")
  private String login;
  @NotEmpty(message = "User name is required")
  private String name;
  @NotEmpty(message = "User password is required")
  @Pattern(regexp = "((?=.*\\d)(?=.*[A-Z]).{8})", message = "User password must match ((?=.*\\d)(?=.*[A-Z]).{8})")
  private String password;

  @Id
  @SequenceGenerator(name="user_key", sequenceName="user_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_key")
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UsersEntity that = (UsersEntity) o;

    if (id != that.id) return false;
    if (login != null ? !login.equals(that.login) : that.login != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (password != null ? !password.equals(that.password) : that.password != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (login != null ? login.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }

  private Set<RolesEntity> roles = new HashSet<RolesEntity>();
  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  public Set<RolesEntity> getRoles() {
    return roles;
  }

  public void setRoles(Set<RolesEntity> roles) {
    this.roles = roles;
  }

}
