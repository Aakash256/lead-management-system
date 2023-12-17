package com.business.manager.common.dto;

import java.util.Date;

public class UserDTO {
  private Long id;
  private Integer status;
  private String first_name;
  private String last_name;
  private String job_title;
  private String email;
  private String password;
  private String address;
  private String city;
  private String state;
  private String postal_code;
  private String country;
  private String department;
  private String work_phone;
  private String work_mobile;
  private String home_phone;
  private String home_mobile;

  public UserDTO() {
  }

  public UserDTO(Long id, Integer status, String first_name, String last_name, String job_title,
                 String email, String password, String address, String city, String state,
                 String postal_code, String country, String department, String work_phone,
                 String work_mobile, String home_phone, String home_mobile) {
    this.id = id;
    this.status = status;
    this.first_name = first_name;
    this.last_name = last_name;
    this.job_title = job_title;
    this.email = email;
    this.password = password;
    this.address = address;
    this.city = city;
    this.state = state;
    this.postal_code = postal_code;
    this.country = country;
    this.department = department;
    this.work_phone = work_phone;
    this.work_mobile = work_mobile;
    this.home_phone = home_phone;
    this.home_mobile = home_mobile;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
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

  public String getJob_title() {
    return job_title;
  }

  public void setJob_title(String job_title) {
    this.job_title = job_title;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPostal_code() {
    return postal_code;
  }

  public void setPostal_code(String postal_code) {
    this.postal_code = postal_code;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getWork_phone() {
    return work_phone;
  }

  public void setWork_phone(String work_phone) {
    this.work_phone = work_phone;
  }

  public String getWork_mobile() {
    return work_mobile;
  }

  public void setWork_mobile(String work_mobile) {
    this.work_mobile = work_mobile;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public void setHome_phone(String home_phone) {
    this.home_phone = home_phone;
  }

  public String getHome_mobile() {
    return home_mobile;
  }

  public void setHome_mobile(String home_mobile) {
    this.home_mobile = home_mobile;
  }
}