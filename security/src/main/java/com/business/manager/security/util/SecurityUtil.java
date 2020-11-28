package com.business.manager.security.util;

import com.business.manager.repository.UserRepository;
import com.business.manager.repository.entity.User;
import com.business.manager.security.exception.OAuth2AuthenticationProcessingException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecurityUtil {

  @Autowired
  private UserRepository userRepository;

  public UserDetails getAuthenticatedUserDetails() throws IllegalAccessException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserDetails userDetails = null;
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      userDetails = (UserDetails) authentication.getPrincipal();
      if(null == userDetails){
        throw new IllegalAccessException("Requested User does not exist !!");
      }
      if (!userDetails.isAccountNonExpired() || !userDetails.isAccountNonLocked() || !userDetails
          .isCredentialsNonExpired() || !userDetails.isEnabled()) {
        throw new IllegalAccessException("User has been disabled to do any operations");
      }
    } else {
      throw new IllegalAccessException("User is not authorized to do the operation !!");
    }
    return userDetails;
  }

  public User getAuthenticatedUser() throws IllegalAccessException {
    UserDetails authenticatedUser = getAuthenticatedUserDetails();
    Optional<User> byEmail = userRepository.findByEmail(authenticatedUser.getUsername());
    if(byEmail.isPresent()) {
      return byEmail.get();
    }else{
      throw new OAuth2AuthenticationProcessingException("User does not exist");
    }
  }

}
