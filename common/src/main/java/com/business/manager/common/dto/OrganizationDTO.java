package com.business.manager.common.dto;

import java.util.Date;

public class OrganizationDTO {
    private Long id;
    private String status;
    private String name;
    private String description;
    private String email;
    private String phoneNo;
    private Integer recVersion;

    private Long userId;

    public OrganizationDTO() {
    }

    public OrganizationDTO(Long id, String status, String name, String description, String email,
                           String phoneNo, Integer recVersion) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phoneNo = phoneNo;
        this.recVersion = recVersion;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getRecVersion() {
        return recVersion;
    }

    public void setRecVersion(Integer recVersion) {
        this.recVersion = recVersion;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}