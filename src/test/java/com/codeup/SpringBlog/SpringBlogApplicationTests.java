package com.codeup.SpringBlog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.config.http.MatcherType.mvc;

@SpringBootTest
class SpringBlogApplicationTests {

	private HttpSession httpSession;

	@Test
	void contextLoads() {

	}


	@Test
	public void testIfUserSessionIsActive() throws Exception {

	}
}
