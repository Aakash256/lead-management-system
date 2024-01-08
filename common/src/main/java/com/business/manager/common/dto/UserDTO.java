package com.business.manager.common.dto;

import java.util.Date;

public class UserDTO {
  private Long id;
  private String status;
  private String firstName;
  private String lastName;
  private String email;
  private String password;

  private String mobileNo;

  private Boolean mobileVerified;

  private Boolean emailVerified;

  private Long reportsTo;

  private Long orgId;

  public UserDTO() {
  }

  public UserDTO(Long id, String status, String firstName, String lastName,
                 String email, String password, String mobileNo, Boolean mobileVerified, Boolean emailVerified) {
    this.id = id;
    this.status = status;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.mobileNo = mobileNo;
    this.mobileVerified = mobileVerified;
    this.emailVerified = emailVerified;
  }

  public UserDTO(Long id, String status, String firstName, String lastName,
                 String email, String password, String mobileNo, Boolean mobileVerified, Boolean emailVerified,
                 Long reportsTo, Long orgId) {
    this.id = id;
    this.status = status;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.mobileNo = mobileNo;
    this.mobileVerified = mobileVerified;
    this.emailVerified = emailVerified;
    this.reportsTo = reportsTo;
    this.orgId = orgId;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public String getMobileNo() { return mobileNo;}
  public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo;}

  public Boolean getMobileVerified() { return mobileVerified;}

  public void setMobileVerified(Boolean mobileVerified) { this.mobileVerified = mobileVerified;}

  public Boolean getEmailVerified() { return emailVerified;}

  public void setEmailVerified(Boolean emailVerified) { this.emailVerified = emailVerified;}

  public Long getReportsTo() { return reportsTo;}

  public void setReportsTo(Long reportsTo) { this.reportsTo = reportsTo;}

  public Long getOrgId() { return orgId; }

  public void setOrgId(Long orgId) { this.orgId = orgId;}
}