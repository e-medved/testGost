package com.gostgroup.test.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gostgroup.test.model.deserialize.RoleDeserializer;

import javax.persistence.*;

/**
 * Created by root on 1/25/17.
 */
@Entity
@Table(name = "roles", schema = "public", catalog = "test")
@JsonDeserialize(using = RoleDeserializer.class)
public class RolesEntity {
  private int id;
  private String name;

  public RolesEntity() {

  }

  public RolesEntity(int id) {
    this.id = id;
  }

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RolesEntity that = (RolesEntity) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
