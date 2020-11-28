package com.business.manager.service.controller;

import com.business.manager.common.dto.UserDTO;
import com.business.manager.security.security.CustomUserDetailsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/user")
public class UserController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @GetMapping(path = "/{user-id}")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Authorization", value = "Authorization token",
            required = true, dataType = "string", paramType = "header") })
    public UserDTO getUser(@PathVariable("user-id") Long userId) {
        return customUserDetailsService.getUserById(userId);
    }

    @PutMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Authorization", value = "Authorization token",
            required = true, dataType = "string", paramType = "header") })
    public String updateUser(@RequestBody UserDTO userDTO) {
        return customUserDetailsService.updateUser(userDTO);
    }

    @GetMapping("/me")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Authorization", value = "Authorization token",
            required = true, dataType = "string", paramType = "header") })
    public UserDTO getUserFromToken() throws IllegalAccessException {
        return customUserDetailsService.fetchUserFromToken();
    }

    /*@GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return customUserDetailsService.findById(userPrincipal.getId());
    }*/
}
