package com.business.manager.service.controller;

import com.business.manager.common.dto.OrganizationDTO;
import com.business.manager.common.dto.UserDTO;
import com.business.manager.security.security.CustomOrganizationDetailsService;
import com.business.manager.security.security.CustomUserDetailsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/organization")
public class OrganizationController {

    @Autowired
    private CustomOrganizationDetailsService customOrganizationDetailsService;

    @GetMapping(path = "/{org-id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    public OrganizationDTO getOrganization(@PathVariable("org-id") Long orgId) {
        return customOrganizationDetailsService.getOrganizationById(orgId);
    }

    @PutMapping(path = "/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    public String updateOrganization(@RequestBody OrganizationDTO organizationDTO) {
        return customOrganizationDetailsService.updateOrganization(organizationDTO);
    }

    @PostMapping("/create")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    public ResponseEntity<String> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        try {
            String result = customOrganizationDetailsService.createOrganization(organizationDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{org-id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    public ResponseEntity<String> deleteOrganization(@PathVariable("org-id") Long orgId) {
        try {
            String result = customOrganizationDetailsService.deleteOrganization(orgId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
