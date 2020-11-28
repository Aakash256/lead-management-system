package com.business.manager.repository.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    name = "Application_Property",
    uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class ApplicationProperty {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String value;

  @Column(nullable = false)
  private Date update_date;
  @Column(nullable = false)
  private String update_by;
  @Column(nullable = false)
  private Date insert_date;
  @Column(nullable = false)
  private String insert_by;

  public ApplicationProperty() {
  }

  public ApplicationProperty(String name, String value) {
    this.name = name;
    this.value = value;
  }

  @PrePersist
  protected void onCreate() {
    insert_date = new Date();
    // TO-DO : Replace by current user
    update_by = "Application";
    update_date = new Date();
    insert_by = "Application";
  }

  @PreUpdate
  protected void onUpdate() {
    update_date = new Date();
    // TO-DO : Replace by current user
    insert_by = "Application";
  }

  @Override
  public String toString() {
    return "ApplicationProperty{"
        + "id="
        + id
        + ", key='"
        + name
        + '\''
        + ", value='"
        + value
        + '\''
        + ", update_date="
        + update_date
        + ", update_by='"
        + update_by
        + '\''
        + ", insert_date="
        + insert_date
        + ", insert_by='"
        + insert_by
        + '\''
        + '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Date getUpdate_date() {
    return update_date;
  }

  public void setUpdate_date(Date update_date) {
    this.update_date = update_date;
  }

  public String getUpdate_by() {
    return update_by;
  }

  public void setUpdate_by(String update_by) {
    this.update_by = update_by;
  }

  public Date getInsert_date() {
    return insert_date;
  }

  public void setInsert_date(Date insert_date) {
    this.insert_date = insert_date;
  }

  public String getInsert_by() {
    return insert_by;
  }

  public void setInsert_by(String insert_by) {
    this.insert_by = insert_by;
  }
}
