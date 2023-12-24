package com.business.manager.common.dto;

import java.util.Date;

public class OrganizationDTO {
    private Long id;
    private String status;
    private String name;
    private String description;
    private String email;
    private String phone_no;
    private Integer rec_version;

    public OrganizationDTO() {
    }

    public OrganizationDTO(Long id, String status, String name, String description, String email,
                           String phone_no, Integer rec_version) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone_no = phone_no;
        this.rec_version = rec_version;
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

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public Integer getRec_version() {
        return rec_version;
    }

    public void setRec_version(Integer rec_version) {
        this.rec_version = rec_version;
    }
}