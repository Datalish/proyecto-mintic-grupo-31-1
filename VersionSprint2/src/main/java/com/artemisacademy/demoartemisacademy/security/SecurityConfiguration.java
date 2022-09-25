package com.artemisacademy.demoartemisacademy.security;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.artemisacademy.demoartemisacademy.models.UsuarioDetails;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

  @Autowired
  UserDetailsService userDetailsService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable()
        .authorizeRequests().antMatchers(
            "/vendor/**",
            "/usuarios/**",
            "/citas/**",
            "/servicios/**",
            "/registro/**",
            "/registroExitoso",
            "/js/**",
            "/scss/**",
            "/css/**",
            "/img/**")
        .permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .failureUrl("/login?credenciales=invalidas")
        .successHandler(new AuthenticationSuccessHandler() {
          @Override
          public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
              Authentication authentication) throws IOException, ServletException {
            UsuarioDetails userDetails = (UsuarioDetails) authentication.getPrincipal();
            String redirectURL = request.getContextPath();

            Iterator<GrantedAuthority> iterator = (Iterator<GrantedAuthority>) userDetails.getAuthorities().iterator();
            while (iterator.hasNext()) {
              GrantedAuthority grantedAuthority = iterator.next();
              if (grantedAuthority.getAuthority().equals("Cliente")) {
                redirectURL = "cliente";
              }
              if (grantedAuthority.getAuthority().equals("Administrador")) {
                redirectURL = "administrador";
              }
              if (grantedAuthority.getAuthority().equals("Micropigmentadora")) {
                redirectURL = "micropigmentadora";
              }
            }

            response.sendRedirect(redirectURL);
          }
        })
        .permitAll()
        .and()
        .logout()
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login")
        .permitAll().and().headers()
        .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));

    return httpSecurity.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
      throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}