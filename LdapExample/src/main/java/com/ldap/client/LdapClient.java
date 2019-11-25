package com.ldap.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.ldap"},exclude = { SecurityAutoConfiguration.class })
public class LdapClient {

	public static void main(String[] args) {
		SpringApplication.run(LdapClient.class, args);


	}

}
