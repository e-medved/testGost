package com.gostgroup.test.model;

import javax.persistence.*;

/**
 * Created by root on 1/25/17.
 */
@Entity
@Table(name = "contacts", schema = "public", catalog = "test")
public class ContactsEntity {
  private int id;
  private String email;
  private String firstName;
  private String lastName;
  private String phone;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Basic
  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "last_name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactsEntity that = (ContactsEntity) o;

    if (id != that.id) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    return result;
  }
}
