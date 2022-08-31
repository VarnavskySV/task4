package com.company.task4jmix;

import com.company.task4jmix.entity.User;
import com.company.task4jmix.security.DatabaseUserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Task4jmixApplicationTests {

	@Autowired
	private DatabaseUserRepository databaseUserRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void getSystemUser(){

		Assertions.assertEquals(databaseUserRepository.getSystemUser().getUsername(), "system");

	}
}
