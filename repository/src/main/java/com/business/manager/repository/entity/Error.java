package com.business.manager.repository.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;

@Entity
@Table(
    name = "Error")
public class Error {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String message;
  @Column
  private String httpStatusCode;
  @Column
  private String httpStatusPhrase;
  @Column
  @Type(type="text")
  private String exceptionStackTrace;

  @Column(nullable = false)
  private Date update_date;
  @Column(nullable = false)
  private String update_by;
  @Column(nullable = false)
  private Date insert_date;
  @Column(nullable = false)
  private String insert_by;

  public Error() {
  }

  public Error(String message, String httpStatusCode, String httpStatusPhrase,
      String exceptionStackTrace) {
    this.message = message;
    this.httpStatusCode = httpStatusCode;
    this.httpStatusPhrase = httpStatusPhrase;
    this.exceptionStackTrace = exceptionStackTrace;
  }

  @Override
  public String toString() {
    return "Error{" +
        "id=" + id +
        ", message='" + message + '\'' +
        ", httpStatusCode='" + httpStatusCode + '\'' +
        ", httpStatusPhrase='" + httpStatusPhrase + '\'' +
        ", exceptionStackTrace='" + exceptionStackTrace + '\'' +
        ", update_date=" + update_date +
        ", update_by='" + update_by + '\'' +
        ", insert_date=" + insert_date +
        ", insert_by='" + insert_by + '\'' +
        '}';
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

}
