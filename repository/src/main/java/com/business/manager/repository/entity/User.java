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
  private String firstName;

  @Column
  private String lastName;

  @Column(nullable = false)
  private String email;
  @Column
  private String password;

  @Column
  private String mobileNo;

  @Column
  private boolean mobileVerified;

  @Column
  private boolean emailVerified;

  @ManyToOne
  @JoinColumn(name = "reports_to", nullable = true)
  private User reportsTo;
  @ManyToOne
  @JoinColumn(name = "org_id", nullable = true)
  private Organization organization;

  @Column
  private String insertBy;

  @Column
  private Date insertDate;

  @Column
  private String updateBy;

  @Column
  private Date updateDate;

  public User() {
  }

  public User(Long id, String status, String firstName, String lastName, String email, String password,
              String mobileNo, Boolean mobileVerified, Boolean emailVerified, User user, Organization organization) {
    this.id = id;
    this.status = status;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.mobileNo = mobileNo;
    this.mobileVerified = mobileVerified;
    this.emailVerified = emailVerified;
    this.reportsTo = user;
    this.organization = organization;
  }

  public User(String status, String firstName, String lastName, String email, String password,String mobileNo,
              Boolean mobileVerified, Boolean emailVerified, User user, Organization organization) {
    this.status = status;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.mobileNo = mobileNo;
    this.mobileVerified = mobileVerified;
    this.emailVerified = emailVerified;
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
    insertDate = new Date();
    // TO-DO : Replace by current user
    updateBy = "Application";
    updateDate = new Date();
    insertBy = "Application";
  }

  @PreUpdate
  protected void onUpdate() {
    updateDate = new Date();
    // TO-DO : Replace by current user
    insertBy = "Application";
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

  public String getFirstName() { return firstName;}

  public void setFirstName(String firstName) { this.firstName = firstName;}

  public String getLastName() { return lastName;}

  public void setLastName(String lastName) { this.lastName = lastName;}

  public String getStatus() { return status;}

  public void setStatus(String status) { this.status = status;}

  public String getMobileNo() { return  mobileNo;}

  public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

  public Boolean getMobileVerified() { return mobileVerified;}

  public void setMobileVerified(Boolean mobileVerified) { this.mobileVerified = mobileVerified;}

  public Boolean getEmailVerified() { return emailVerified;}

  public void setEmailVerified(Boolean emailVerified) { this.emailVerified = emailVerified;}

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