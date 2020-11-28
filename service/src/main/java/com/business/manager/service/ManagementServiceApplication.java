package com.business.manager.service;

import com.business.manager.security.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.business.manager.*")
@ComponentScan(basePackages = {"com.business.manager.*"})
@EntityScan(basePackages = {"com.business.manager.*"})
@EnableJpaRepositories(basePackages = {"com.business.manager.*"})
@EnableConfigurationProperties(AppProperties.class)
public class ManagementServiceApplication {

  public static void main(String[] args) {
    try {
      SpringApplication.run(ManagementServiceApplication.class, args);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Exception while launching the instance", e);
    }
  }
}
