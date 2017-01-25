package com.gostgroup.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by root on 1/25/17.
 */
@Entity
@Table(name = "user_roles", schema = "public", catalog = "test")
public class UserRolesEntity {
  private int id;

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
}
