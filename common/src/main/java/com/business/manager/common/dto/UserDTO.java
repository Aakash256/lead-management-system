package com.business.manager.common.dto;

import java.util.Date;

public class UserDTO {
  private Long id;
  private String status;
  private String first_name;
  private String last_name;
  private String email;
  private String password;

  private String mobile_no;

  private Boolean mobile_verified;

  private Boolean email_verified;

  private Long reportsTo;

  public UserDTO() {
  }

  public UserDTO(Long id, String status, String first_name, String last_name,
                 String email, String password, String mobile_no, Boolean mobile_verified, Boolean email_verified) {
    this.id = id;
    this.status = status;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.password = password;
    this.mobile_no = mobile_no;
    this.mobile_verified = mobile_verified;
    this.email_verified = email_verified;
  }

  public UserDTO(Long id, String status, String first_name, String last_name,
                 String email, String password, String mobile_no, Boolean mobile_verified, Boolean email_verified,
                 Long reportsTo) {
    this.id = id;
    this.status = status;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.password = password;
    this.mobile_no = mobile_no;
    this.mobile_verified = mobile_verified;
    this.email_verified = email_verified;
    this.reportsTo = reportsTo;
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

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
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

  public String getMobile_no() { return mobile_no;}
  public void setMobile_no(String mobile_no) { this.mobile_no = mobile_no;}

  public Boolean getMobile_verified() { return mobile_verified;}

  public void setMobile_verified(Boolean mobile_verified) { this.mobile_verified = mobile_verified;}

  public Boolean getEmail_verified() { return email_verified;}

  public void setEmail_verified(Boolean email_verified) { this.email_verified = email_verified;}

  public Long getReportsTo() { return reportsTo;}

  public void setReportsTo(Long reportsTo) { this.reportsTo = reportsTo;}

}