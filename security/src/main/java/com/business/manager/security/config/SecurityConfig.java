package com.business.manager.security.config;

import com.business.manager.security.security.CustomOrganizationDetailsService;
import com.business.manager.security.security.CustomUserDetailsService;
import com.business.manager.security.security.TokenAuthenticationFilter;
import com.business.manager.security.security.oauth2.CustomOAuth2UserService;
import com.business.manager.security.security.oauth2.OAuth2AuthenticationSuccessHandler;
import com.business.manager.security.security.RestAuthenticationEntryPoint;
import com.business.manager.security.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.business.manager.security.security.oauth2.OAuth2AuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Autowired
  private CustomOrganizationDetailsService customOrganizationDetailsService;

  @Autowired
  private CustomOAuth2UserService customOAuth2UserService;

  @Autowired
  private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

  @Autowired
  private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

  @Autowired
  private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

  @Bean
  public TokenAuthenticationFilter tokenAuthenticationFilter() {
    return new TokenAuthenticationFilter();
  }

  /*
    By default, Spring OAuth2 uses HttpSessionOAuth2AuthorizationRequestRepository to save
    the authorization request. But, since our service is stateless, we can't save it in
    the session. We'll save the request in a Base64 encoded cookie instead.
  */
  @Bean
  public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
    return new HttpCookieOAuth2AuthorizationRequestRepository();
  }

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
          throws Exception {
    authenticationManagerBuilder
            .userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder())
            .and().userDetailsService(customOrganizationDetailsService).passwordEncoder(passwordEncoder());
  }

//  @Bean
//  public CustomOrganizationDetailsService customOrganizationDetailsService() {
//    return new CustomOrganizationDetailsService();
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Bean(BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  /*To allow swagger URL
   * TO-DO - Validate if it can cause some security issue.
   * */
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().mvcMatchers(HttpMethod.OPTIONS, "/**");
    web.ignoring().mvcMatchers("/swagger-ui.html/**", "/configuration/**", "/swagger-resources/**", "/v2/api-docs","/webjars/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .cors()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .csrf()
            .disable()
            .formLogin()
            .disable()
            .httpBasic()
            .disable()
            .exceptionHandling()
            .authenticationEntryPoint(new RestAuthenticationEntryPoint())
            .and()
            .authorizeRequests()
            .antMatchers("/**/meta-data/lab-types", "/**/meta-data/lab-pricing", "/**/contact",
                    "/**/public/labs", "/**/trainings/{training-uuid}", "/**/trainings/{training-uuid}/labs","/**/payment/**").permitAll()
            .antMatchers("/",
                    "/error", "/organization/**",
                    "/favicon.ico",
                    "/**/*.png",
                    "/**/*.gif",
                    "/**/*.svg",
                    "/**/*.jpg",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js")
            .permitAll()
            .antMatchers("/auth/**", "/oauth2/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2Login()
            .authorizationEndpoint()
            .baseUri("/oauth2/authorize")
            .authorizationRequestRepository(cookieAuthorizationRequestRepository())
            .and()
            .redirectionEndpoint()
            .baseUri("/oauth2/callback/*")
            .and()
            .userInfoEndpoint()
            .userService(customOAuth2UserService)
            .and()
            .successHandler(oAuth2AuthenticationSuccessHandler)
            .failureHandler(oAuth2AuthenticationFailureHandler);

    // Add our custom Token based authentication filter
    http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }
}