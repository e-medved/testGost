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
  @JsonIgnore
  private UsersEntity usersByUserId;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  public UsersEntity getUsersByUserId() {
    return usersByUserId;
  }

  public void setUsersByUserId(UsersEntity usersByUserId) {
    this.usersByUserId = usersByUserId;
  }


}
