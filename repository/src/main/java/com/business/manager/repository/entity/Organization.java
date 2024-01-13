package com.business.manager.repository.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String status;

    @Column
    private String name;

    @Column
    private String description;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String phoneNo;

    @Column
    private Integer recVersion;

    @Column
    private String insertBy;

    @Column
    private Date insertDate;

    @Column
    private String updateBy;

    @Column
    private Date updateDate;

    public Organization() {
    }

    public Organization(Long id, String status, String name, String description, String email,
                        String phoneNo, Integer recVersion) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phoneNo = phoneNo;
        this.recVersion = recVersion;
    }

    public Organization(String status, String name, String description, String email,
                        String phoneNo, Integer recVersion) {
        this.status = status;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phoneNo = phoneNo;
        this.recVersion = recVersion;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}