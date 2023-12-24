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
  private Integer status;

  @Column
  private String first_name;

  @Column
  private String last_name;

  @Column
  private String job_title;

  @Column(nullable = false)
  private String email;
  @Column
  private String password;

  @Column
  private String address;

  @Column
  private String city;

  @Column
  private String state;

  @Column
  private String postal_code;

  @Column
  private String country;

  @Column
  private String department;

  @Column
  private String work_phone;

  @Column
  private String work_mobile;

  @Column
  private String home_phone;

  @Column
  private String home_mobile;

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

  public User(Long id, Integer status, String first_name, String last_name, String job_title, String email,
              String password, String address, String city, String state, String postal_code, String country,
              String department, String work_phone, String work_mobile, String home_phone, String home_mobile,
              Organization organization) {
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
    this.organization = organization;
  }

  public User(Integer status, String first_name, String last_name, String job_title, String email,
              String password, String address, String city, String state, String postal_code, String country,
              String department, String work_phone, String work_mobile, String home_phone, String home_mobile,
              Organization organization) {
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

  public String getAddress() { return address;}

  public void setAddress(String address) { this.address = address;}

  public String getFirst_name() { return first_name;}

  public void setFirst_name(String first_name) { this.first_name = first_name;}

  public String getLast_name() { return last_name;}

  public void setLast_name(String last_name) { this.last_name = last_name;}

  public Integer getStatus() { return status;}

  public void setStatus(Integer status) { this.status = status;}

  public String getCity() { return city;}

  public void setCity(String city) { this.city = city;}

  public String getState() { return state;}

  public void setState(String state) { this.state = state;}

  public String getPostal_code() { return postal_code;}

  public void setPostal_code(String postal_code) { this.postal_code = postal_code;}

  public String getCountry() { return country;}

  public void setCountry(String country) { this.country = country;}

  public String getDepartment() { return department;}

  public void setDepartment(String department) { this.department = department;}

  public String getWork_phone() { return work_phone;}

  public void setWork_phone(String work_phone) { this.work_phone = work_phone;}

  public String getWork_mobile() { return work_mobile;}

  public void setWork_mobile(String work_mobile) { this.work_mobile = work_mobile;}

  public String getHome_phone() { return home_phone;}

  public void setHome_phone(String home_phone) { this.home_phone = home_phone;}

  public String getHome_mobile() { return home_mobile;}

  public void setHome_mobile(String home_mobile) { this.home_mobile = home_mobile;}

  public String getJob_title() { return job_title;}

  public void setJob_title(String job_title) { this.job_title = job_title;}

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }
}
