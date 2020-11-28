package com.business.manager.service.process;

import com.business.manager.service.context.ApplicationPropertyContext;
import lombok.extern.slf4j.Slf4j;

// TO-DO : Change this and use Spring instead of new InstanceManager
@Slf4j
public class StaticDataRefresher implements Runnable {

  private ApplicationPropertyContext applicationPropertyContext;

  public StaticDataRefresher(
      ApplicationPropertyContext applicationPropertyContext) {
    this.applicationPropertyContext = applicationPropertyContext;
  }

  @Override
  public void run() {
    log.info("Refreshing cached static data from database.");
    applicationPropertyContext.loadApplicationProperties();
    log.debug("Successfully complted refreshing cached static data from database.");
  }
}
