package com.example.ejemplos_videos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.ejemplos_videos.services.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	
	@Autowired @Qualifier("userService")
	private UserService userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@SuppressWarnings("removal")
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/css/*", "/imgs/*", "/js/*", "/vendor/bootstrap/css/*", "/vendor/jquery/*", "/vendor/bootstrap/js/*").permitAll().anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login").loginProcessingUrl("loginprocess").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/loginsuccess").permitAll()
		.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("logout").permitAll();
		return http.build();
	}
}
