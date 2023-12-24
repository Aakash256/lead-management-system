package com.business.manager.repository.entity;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(
    name = "User",
    uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String status;

  @Column
  private String first_name;

  @Column
  private String last_name;

  @Column(nullable = false)
  private String email;
  @Column
  private String password;

  @Column
  private String mobile_no;

  @Column
  private boolean mobile_verified;

  @Column
  private boolean email_verified;

  @ManyToOne
  @JoinColumn(name = "reports_to", nullable = true)
  private User reportsTo;
  @ManyToOne
  @JoinColumn(name = "org_id", nullable = true)
  private Organization organization;

  @Column
  private String insert_by;

  @Column
  private Date insert_date;

  @Column
  private String update_by;

  @Column
  private Date update_date;

  public User() {
  }

  public User(Long id, String status, String first_name, String last_name, String email, String password,
              String mobile_no, Boolean mobile_verified, Boolean email_verified, User user, Organization organization) {
    this.id = id;
    this.status = status;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.password = password;
    this.mobile_no = mobile_no;
    this.mobile_verified = mobile_verified;
    this.email_verified = email_verified;
    this.reportsTo = user;
    this.organization = organization;
  }

  public User(String status, String first_name, String last_name, String email, String password,String mobile_no,
              Boolean mobile_verified, Boolean email_verified, User user, Organization organization) {
    this.status = status;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.password = password;
    this.mobile_no = mobile_no;
    this.mobile_verified = mobile_verified;
    this.email_verified = email_verified;
    this.reportsTo = user;
    this.organization = organization;
  }

//  public User(String email, String password,
//      String auth_provider, String roles, Boolean enabled, String name,
//      String mobile_no, String dob, Boolean email_verified, Boolean mobile_verified,
//      String imageUrl) {
//    this.email = email;
//    this.password = password;
//    this.auth_provider = auth_provider;
//    this.roles = roles;
//    this.enabled = enabled;
//    this.name = name;
//    this.mobile_no = mobile_no;
//    this.dob = dob;
//    this.email_verified = email_verified;
//    this.mobile_verified = mobile_verified;
//    this.imageUrl = imageUrl;
//  }

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

  public String getFirst_name() { return first_name;}

  public void setFirst_name(String first_name) { this.first_name = first_name;}

  public String getLast_name() { return last_name;}

  public void setLast_name(String last_name) { this.last_name = last_name;}

  public String getStatus() { return status;}

  public void setStatus(String status) { this.status = status;}

  public String getMobile_no() { return  mobile_no;}

  public void setMobile_no(String mobile_no) { this.mobile_no = mobile_no; }

  public Boolean getMobile_Verified() { return mobile_verified;}

  public void setMobile_verified(Boolean mobile_verified) { this.mobile_verified = mobile_verified;}

  public Boolean getEmail_Verified() { return email_verified;}

  public void setEmail_verified(Boolean email_verified) { this.email_verified = email_verified;}

  public User getReportsTo() {
    return reportsTo;
  }

  public void setReportsTo(User reportsTo) {
    this.reportsTo = reportsTo;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }
}
