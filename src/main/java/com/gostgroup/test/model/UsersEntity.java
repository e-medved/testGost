package com.gostgroup.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by e.medvedev on 26.01.2017.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "test")
public class UsersEntity {
  @JsonIgnore
  private int id;
  private String login;
  private String name;
  private String password;
  private Collection<Integer> userRoles;

  @Id
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

  @ElementCollection
  @CollectionTable(name="user_roles", joinColumns=@JoinColumn(name="user_id"))
  @Column(name = "role_id")
  public Collection<Integer> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(Collection<Integer> userRoles) {
    this.userRoles = userRoles;
  }

}
