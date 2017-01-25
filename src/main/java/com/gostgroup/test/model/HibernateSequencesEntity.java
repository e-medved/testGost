package com.gostgroup.test.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by root on 1/25/17.
 */
@Entity
@Table(name = "hibernate_sequences", schema = "public", catalog = "test")
public class HibernateSequencesEntity {
  private String sequenceName;
  private Integer sequenceNextHiValue;

  @Basic
  @Column(name = "sequence_name")
  public String getSequenceName() {
    return sequenceName;
  }

  public void setSequenceName(String sequenceName) {
    this.sequenceName = sequenceName;
  }

  @Basic
  @Column(name = "sequence_next_hi_value")
  public Integer getSequenceNextHiValue() {
    return sequenceNextHiValue;
  }

  public void setSequenceNextHiValue(Integer sequenceNextHiValue) {
    this.sequenceNextHiValue = sequenceNextHiValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    HibernateSequencesEntity that = (HibernateSequencesEntity) o;

    if (sequenceName != null ? !sequenceName.equals(that.sequenceName) : that.sequenceName != null) return false;
    if (sequenceNextHiValue != null ? !sequenceNextHiValue.equals(that.sequenceNextHiValue) : that.sequenceNextHiValue != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = sequenceName != null ? sequenceName.hashCode() : 0;
    result = 31 * result + (sequenceNextHiValue != null ? sequenceNextHiValue.hashCode() : 0);
    return result;
  }
}
