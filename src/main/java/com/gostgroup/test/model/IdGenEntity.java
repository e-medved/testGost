package com.gostgroup.test.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by root on 1/25/17.
 */
@Entity
@Table(name = "id_gen", schema = "public", catalog = "test")
public class IdGenEntity {
  private String id;
  private Integer idValue;

  @Basic
  @Column(name = "id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Basic
  @Column(name = "id_value")
  public Integer getIdValue() {
    return idValue;
  }

  public void setIdValue(Integer idValue) {
    this.idValue = idValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    IdGenEntity that = (IdGenEntity) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (idValue != null ? !idValue.equals(that.idValue) : that.idValue != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (idValue != null ? idValue.hashCode() : 0);
    return result;
  }
}
