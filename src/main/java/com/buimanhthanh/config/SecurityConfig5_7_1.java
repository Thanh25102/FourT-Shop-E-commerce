package com.buimanhthanh.config;

import com.buimanhthanh.config.handler.LoginSuccessHandler;
import com.buimanhthanh.config.handler.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.buimanhthanh.const_.ROLE;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "com.buimanhthanh.service", "com.buimanhthanh.dao" })
public class SecurityConfig5_7_1 {
	@Bean
	public Cloudinary cloudinary() {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "com-buimahthanh", // insert here you
																									// cloud name
				"api_key", "767693717832892", // insert here your api code
				"api_secret", "prGZdfuasWtSvI2GMocQiZ9Bh9w")); // insert here your api secret
		return cloudinary;
	}

	@Autowired
	public UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationSuccessHandler loginSuccessHandler;
	@Autowired
	private LogoutSuccessHandler logoutHandler;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and()
				.formLogin().defaultSuccessUrl("/").failureUrl("/login?error").and().formLogin()
				.successHandler(this.loginSuccessHandler).and().exceptionHandling().accessDeniedPage("/error").and()
				.logout().logoutSuccessHandler(this.logoutHandler).and().authorizeRequests()
				.antMatchers("/", "/login", "/register").permitAll().antMatchers("/admin/**").hasAuthority(ROLE.ADMIN)
				.antMatchers("/**").hasAuthority(ROLE.CUSTOMER).anyRequest().authenticated().and().csrf().disable()
				.build();
	}

	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}

	@Bean
	public LogoutSuccessHandler logoutHandler() {
		return new LogoutHandler();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().antMatchers("/asset/**");
	}
}
