package com.project.tft;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class TftInferfaceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testSomething()  {
//		mockMvc.perform(get("/champions")).andDo(print())
//	}
}
