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
    private String phone_no;

    @Column
    private Integer rec_version;

    @Column
    private String insert_by;

    @Column
    private Date insert_date;

    @Column
    private String update_by;

    @Column
    private Date update_date;

    public Organization() {
    }

    public Organization(Long id, String status, String name, String description, String email,
                        String phone_no, Integer rec_version) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone_no = phone_no;
        this.rec_version = rec_version;
    }

    public Organization(String status, String name, String description, String email,
                        String phone_no, Integer rec_version) {
        this.status = status;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone_no = phone_no;
        this.rec_version = rec_version;
    }

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