package com.business.manager.repository;

import com.business.manager.repository.entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<Error, Long> {}
