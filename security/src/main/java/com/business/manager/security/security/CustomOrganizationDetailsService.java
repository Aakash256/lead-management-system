package com.business.manager.security.security;

import com.business.manager.common.dto.OrganizationDTO;
import com.business.manager.common.exception.BadRequestException;
import com.business.manager.repository.UserRepository;
import com.business.manager.repository.entity.Organization;
import com.business.manager.common.exception.ResourceNotFoundException;
import com.business.manager.repository.OrganizationRepository;
import com.business.manager.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomOrganizationDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UsernameNotFoundException("Organization not found with username: " + username);
    }


    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Organization loadOrgById(Long id) {
        Organization organization = findById(id);
        return organization;
    }

    public Organization findById(Long id) {
        return organizationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Organization", "id", id)
        );
    }

    public OrganizationDTO getOrganizationById(Long id) {
        Organization organization = findById(id);
        return createOrganizationDTO(organization);
    }

    private OrganizationDTO createOrganizationDTO(Organization organization) {
        return new OrganizationDTO(
                organization.getId(),
                organization.getStatus(),
                organization.getName(),
                organization.getDescription(),
                organization.getEmail(),
                organization.getPhoneNo(),
                organization.getRecVersion()
        );
    }

    public String updateOrganization(OrganizationDTO organizationDTO) {
        Optional<Organization> organizationOptional = organizationRepository.findById(organizationDTO.getId());
        Organization organization = null;
        if (organizationOptional.isPresent()) {
            organization = organizationOptional.get();
            organization.setName(organizationDTO.getName());
            organization.setDescription(organizationDTO.getDescription());
            organization.setPhoneNo(organizationDTO.getPhoneNo());
        } else {
            throw new BadRequestException("Organization with id - " + organizationDTO.getId() + " does not exist");
        }
        organizationRepository.save(organization);
        return "Organization has been updated successfully";
    }

    public String createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        organization.setStatus(organizationDTO.getStatus());
        organization.setName(organizationDTO.getName());
        organization.setDescription(organizationDTO.getDescription());
        organization.setEmail(organizationDTO.getEmail());
        organization.setPhoneNo(organizationDTO.getPhoneNo());
        organization.setRecVersion(organizationDTO.getRecVersion());

        organizationRepository.save(organization);

        Optional<User> userOptional = userRepository.findById(organizationDTO.getUserId());
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setOrganization(organization);
            userRepository.save(user);
        } else {
            return "User is not present in the database";
        }

        return "Organization has been created successfully";
    }

    public String deleteOrganization(Long id) {
        Optional<Organization> organizationOptional = organizationRepository.findById(id);
        if (organizationOptional.isPresent()) {
            Organization organization = organizationOptional.get();
            organizationRepository.delete(organization);
            return "Organization has been deleted successfully";
        } else {
            throw new BadRequestException("Organization with id - " + id + " does not exist");
        }
    }

}