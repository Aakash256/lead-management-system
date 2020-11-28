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
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(
    name = "User",
    uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;
  @Column
  private String password;
  @Column
  private String auth_provider;
  @Column(nullable = false)
  private String roles;
  @Column(nullable = false)
  @ColumnDefault("true")
  private Boolean enabled;
  @Column(nullable = false)
  private String name;
  @Column
  private String mobile_no;
  @Column
  private String dob;
  @Column(nullable = false)
  @ColumnDefault("false")
  private Boolean email_verified;
  @Column(nullable = false)
  @ColumnDefault("false")
  private Boolean mobile_verified;
  @Column
  private String imageUrl;

  @Column(nullable = false)
  private Date update_date;
  @Column(nullable = false)
  private String update_by;
  @Column(nullable = false)
  private Date insert_date;
  @Column(nullable = false)
  private String insert_by;

  public User() {
  }

  public User(Long id, String email, String name, String mobile_no, String imageUrl,
      String dob) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.mobile_no = mobile_no;
    this.imageUrl = imageUrl;
    this.dob = dob;
  }

  public User(String email, String password,
      String auth_provider, String roles, Boolean enabled, String name,
      String mobile_no, String dob, Boolean email_verified, Boolean mobile_verified,
      String imageUrl) {
    this.email = email;
    this.password = password;
    this.auth_provider = auth_provider;
    this.roles = roles;
    this.enabled = enabled;
    this.name = name;
    this.mobile_no = mobile_no;
    this.dob = dob;
    this.email_verified = email_verified;
    this.mobile_verified = mobile_verified;
    this.imageUrl = imageUrl;
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

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAuth_provider() {
    return auth_provider;
  }

  public void setAuth_provider(String auth_provider) {
    this.auth_provider = auth_provider;
  }

  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobile_no() {
    return mobile_no;
  }

  public void setMobile_no(String mobile_no) {
    this.mobile_no = mobile_no;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public Boolean getEmail_verified() {
    return email_verified;
  }

  public void setEmail_verified(Boolean email_verified) {
    this.email_verified = email_verified;
  }

  public Boolean getMobile_verified() {
    return mobile_verified;
  }

  public void setMobile_verified(Boolean mobile_verified) {
    this.mobile_verified = mobile_verified;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
