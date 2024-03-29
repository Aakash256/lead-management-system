package com.business.manager.security.security;


import com.business.manager.common.dto.UserDTO;
import com.business.manager.common.exception.BadRequestException;
import com.business.manager.repository.entity.User;
import com.business.manager.common.exception.ResourceNotFoundException;
import com.business.manager.repository.UserRepository;
import com.business.manager.security.exception.OAuth2AuthenticationProcessingException;
import com.business.manager.security.util.SecurityUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  private SecurityUtil securityUtil;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email)
          throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email)
            .orElseThrow(() ->
                    new UsernameNotFoundException("User not found with email : " + email)
            );

    return UserPrincipal.create(user);
  }

  @Transactional
  public UserDetails loadUserById(Long id) {
    User user = findById(id);

    return UserPrincipal.create(user);
  }

  public User findById(Long id) {
    return userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
    );
  }

  public UserDTO getUserById(Long id) {
    User user = findById(id);
    return createUserDTO(user);

  }

  private UserDTO createUserDTO(User user) {
//    return new UserDTO(user.getId(), user.getEmail(), user.getName(), user.getMobile_no(),
//        user.getImageUrl(), user.getDob());

    return new UserDTO(
            user.getId(),
            user.getStatus(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPassword(),
            user.getMobileNo(),
            user.getMobileVerified(),
            user.getEmailVerified()
    );
  }

  public String updateUser(UserDTO userDTO) {
    Optional<User> userOptional = userRepository.findById(userDTO.getId());
    User user = null;
    if (userOptional.isPresent()) {
      user = userOptional.get();
      user.setFirstName(userDTO.getFirstName());
      user.setLastName(userDTO.getLastName());
      user.setMobileNo(userDTO.getMobileNo());
      if(userDTO.getReportsTo() != null) {
        Optional<User> reportsToUser = userRepository.findById(userDTO.getReportsTo());
        if (reportsToUser.isPresent()) {
          user.setReportsTo(reportsToUser.get());
        }
      }
    }else{
      throw new BadRequestException("User with id - "+userDTO.getId()+" does not exist");
    }
    userRepository.save(user);
    return "User has been updated successfully";
  }

  public UserDTO fetchUserFromToken() throws IllegalAccessException {
    User user = securityUtil.getAuthenticatedUser();
    UserDTO userDTO = null;
    if(null != user) {
      userDTO = new UserDTO(
              user.getId(),
              user.getStatus(),
              user.getFirstName(),
              user.getLastName(),
              user.getEmail(),
              user.getPassword(),
              user.getMobileNo(),
              user.getMobileVerified(),
              user.getEmailVerified(),
              user.getReportsTo() != null ? user.getReportsTo().getId() : null,
              user.getOrganization() != null ? user.getOrganization().getId() : null
      );

      System.out.println("fetch user from token");
      System.out.println(userDTO);
    }else{
      throw new OAuth2AuthenticationProcessingException("Invalid Token !! Please login again");
    }
    return userDTO;
  }
}

