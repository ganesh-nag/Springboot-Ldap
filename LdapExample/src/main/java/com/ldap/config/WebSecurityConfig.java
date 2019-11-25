package com.ldap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
		.authorizeRequests()
		.antMatchers("/home").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/users").hasRole("ADMIN")
			.and().httpBasic();
		//.formLogin();

	}


	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=users,ou=system")
				.groupSearchBase("ou=groups,ou=system")
				.contextSource()
					.url("ldap://localhost:10389/")
					.managerDn("uid=admin,ou=system")
					.managerPassword("secret")
					.and()
				.passwordCompare()
					.passwordEncoder(new LdapShaPasswordEncoder())
					.passwordAttribute("userPassword");
	}



}

