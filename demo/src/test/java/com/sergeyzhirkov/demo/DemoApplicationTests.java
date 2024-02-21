package com.sergeyzhirkov.demo;

import broker.Subscriber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@SpyBean
	private Subscriber subscriber;

	@Test
	void shouldGetPhrase() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/help-service/v1/support"))
				.andExpect(jsonPath("$.text").value("Empty phrase"));
	}

	@Test
	void shouldAddPhraseAndPushToBroker() throws Exception {
		String testPhrase = "new string phrase";
		mockMvc.perform(MockMvcRequestBuilders.post("/help-service/v1/support").content(testPhrase))
				.andExpect(status().isOk());
		Assertions.assertEquals(testPhrase, subscriber.getMessage());
	}

}
