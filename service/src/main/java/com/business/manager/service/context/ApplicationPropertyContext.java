package com.business.manager.service.context;

import com.business.manager.common.constant.ApplicationPropertyEnum;
import com.business.manager.repository.ApplicationPropertyRepository;
import com.business.manager.repository.entity.ApplicationProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPropertyContext {

  @Autowired private ApplicationPropertyRepository applicationPropertyRepository;

  private Map<String, String> applicationProperties = new HashMap<>();

  public String getPropertyValue(String name) {
    return applicationProperties.get(name);
  }

  public void setApplicationProperties(List<ApplicationProperty> applicationPropertiesList) {
    for (ApplicationProperty applicationProperty : applicationPropertiesList) {
      applicationProperties.put(applicationProperty.getName(), applicationProperty.getValue());
    }
  }

  @PostConstruct
  public void init() {

    ApplicationPropertyEnum[] values = ApplicationPropertyEnum.values();

    List<ApplicationProperty> applicationProperties = new ArrayList<>();
    for (ApplicationPropertyEnum applicationPropertyEnum : values)
      applicationProperties.add(
          new ApplicationProperty(
              applicationPropertyEnum.getKey(), applicationPropertyEnum.getDefaultValue()));

    if (applicationPropertyRepository.count() < 1)
      applicationPropertyRepository.saveAll(applicationProperties);

    //    updateApplicationProperties(applicationProperties);

    loadApplicationProperties();
  }

  private void updateApplicationProperties(List<ApplicationProperty> properties) {
    for (ApplicationProperty applicationProperty : properties)
      applicationPropertyRepository.updateApplicationProperty(
          applicationProperty.getName(), applicationProperty.getValue());
  }

  public void loadApplicationProperties() {
    List<ApplicationProperty> applicationPropertyList = applicationPropertyRepository.findAll();
    setApplicationProperties(applicationPropertyList);
  }
}
