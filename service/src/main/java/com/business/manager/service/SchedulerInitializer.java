package com.business.manager.service;

import com.business.manager.common.constant.ApplicationPropertyEnum;
import com.business.manager.service.context.ApplicationPropertyContext;
import com.business.manager.service.process.StaticDataRefresher;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class SchedulerInitializer {

  @Autowired
  private ApplicationPropertyContext applicationPropertyContext;

  @PostConstruct
  private void init() {

    log.info("Scheduling all Manager to run at configured time");

    // Static Data Refresher
    Integer staticDataRefreshPeriod =
        Integer.parseInt(
            applicationPropertyContext.getPropertyValue(
                ApplicationPropertyEnum.STATIC_DATA_REFRESHER_TIME_INTERVAL_IN_MINUTES.getKey()));
    StaticDataRefresher staticDataRefresher =
        new StaticDataRefresher(applicationPropertyContext);
    ScheduledExecutorService refreshStaticDataService =
        Executors.newSingleThreadScheduledExecutor();
    refreshStaticDataService.scheduleAtFixedRate(
        staticDataRefresher, staticDataRefreshPeriod, staticDataRefreshPeriod, TimeUnit.MINUTES);

  }
}
