package com.gostgroup.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by root on 1/25/17.
 */
@Entity
@Table(name = "user_roles", schema = "public", catalog = "test")
public class UserRolesEntity {
  private int id;
  private int userId;
  private int roleId;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "user_id")
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Basic
  @Column(name = "role_id")
  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserRolesEntity that = (UserRolesEntity) o;

    if (id != that.id) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return id;
  }

}
