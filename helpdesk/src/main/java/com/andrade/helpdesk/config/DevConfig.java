package com.andrade.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andrade.helpdesk.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@Bean
	public boolean DBInstance() {
		if(value.equals("create")) {
			this.dbService.DBInstance();
		}
		return false;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
