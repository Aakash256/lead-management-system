package com.business.manager.common.dto;

public class UserDTO {
  private Long id;
  private String email;
  private String first_name;

  private String last_name;
  private String work_mobile;

  public UserDTO() {
  }

  public UserDTO(Long id, String email, String first_name, String last_name, String work_mobile) {
    this.id = id;
    this.email = email;
    this.first_name = first_name;
    this.last_name = last_name;
    this.work_mobile = work_mobile;
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

  public String getWork_mobile() {
    return work_mobile;
  }

  public void setWork_mobile(String work_mobile) {
    this.work_mobile = work_mobile;
  }
}
