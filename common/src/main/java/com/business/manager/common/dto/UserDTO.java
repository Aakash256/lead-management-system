package com.business.manager.common.dto;

public class UserDTO {
  private Long id;
  private String email;
  private String name;
  private String mobileNo;
  private String imageURL;
  private String dob;

  public UserDTO() {
  }

  public UserDTO(Long id, String email, String name, String mobileNo, String imageURL,
      String dob) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.mobileNo = mobileNo;
    this.imageURL = imageURL;
    this.dob = dob;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }
}
