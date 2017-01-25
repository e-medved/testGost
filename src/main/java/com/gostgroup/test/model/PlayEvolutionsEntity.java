package com.gostgroup.test.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by root on 1/25/17.
 */
@Entity
@Table(name = "play_evolutions", schema = "public", catalog = "test")
public class PlayEvolutionsEntity {
  private int id;
  private String hash;
  private Timestamp appliedAt;
  private String applyScript;
  private String revertScript;
  private String state;
  private String lastProblem;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "hash")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  @Basic
  @Column(name = "applied_at")
  public Timestamp getAppliedAt() {
    return appliedAt;
  }

  public void setAppliedAt(Timestamp appliedAt) {
    this.appliedAt = appliedAt;
  }

  @Basic
  @Column(name = "apply_script")
  public String getApplyScript() {
    return applyScript;
  }

  public void setApplyScript(String applyScript) {
    this.applyScript = applyScript;
  }

  @Basic
  @Column(name = "revert_script")
  public String getRevertScript() {
    return revertScript;
  }

  public void setRevertScript(String revertScript) {
    this.revertScript = revertScript;
  }

  @Basic
  @Column(name = "state")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Basic
  @Column(name = "last_problem")
  public String getLastProblem() {
    return lastProblem;
  }

  public void setLastProblem(String lastProblem) {
    this.lastProblem = lastProblem;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PlayEvolutionsEntity that = (PlayEvolutionsEntity) o;

    if (id != that.id) return false;
    if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
    if (appliedAt != null ? !appliedAt.equals(that.appliedAt) : that.appliedAt != null) return false;
    if (applyScript != null ? !applyScript.equals(that.applyScript) : that.applyScript != null) return false;
    if (revertScript != null ? !revertScript.equals(that.revertScript) : that.revertScript != null) return false;
    if (state != null ? !state.equals(that.state) : that.state != null) return false;
    if (lastProblem != null ? !lastProblem.equals(that.lastProblem) : that.lastProblem != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (hash != null ? hash.hashCode() : 0);
    result = 31 * result + (appliedAt != null ? appliedAt.hashCode() : 0);
    result = 31 * result + (applyScript != null ? applyScript.hashCode() : 0);
    result = 31 * result + (revertScript != null ? revertScript.hashCode() : 0);
    result = 31 * result + (state != null ? state.hashCode() : 0);
    result = 31 * result + (lastProblem != null ? lastProblem.hashCode() : 0);
    return result;
  }
}
