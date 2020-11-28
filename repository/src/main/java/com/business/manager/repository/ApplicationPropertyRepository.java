package com.business.manager.repository;

import com.business.manager.repository.entity.ApplicationProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ApplicationPropertyRepository extends JpaRepository<ApplicationProperty, Long> {

  List<ApplicationProperty> findAll();

  @Transactional
  @Modifying
  @Query("update ApplicationProperty a set a.value = :value WHERE a.name = :name")
  void updateApplicationProperty(@Param("name") String name, @Param("value") String value);

  @Query(value = "Select value from application_property where name = :name", nativeQuery = true)
  String findByPropertyName(String name);
}
