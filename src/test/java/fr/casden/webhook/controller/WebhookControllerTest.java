package fr.casden.webhook.controller;

import static fr.casden.utils.ApiaiRequestUtils.requestBodyString;
import static fr.casden.utils.ApiaiRequestUtils.webhookResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebhookControllerTest {

	@Autowired
	private MockMvc mvc;
	
	private String url = "/webhook";

	@Test
	public void should_add_2_and_3_and_obtain_5() throws Exception {
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(url)
				.accept(APPLICATION_JSON).contentType(APPLICATION_JSON).content(requestBodyString(2, 3, "+"));
		
		mvc.perform(mockHttpServletRequestBuilder).
			andExpect(status().isOk()).
			andExpect(content().json(webhookResponse("2 plus 3 is equal to 5").toString()));
	}

	@Test
	public void should_substract_4_and_3_and_obtain_1() throws Exception {
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(url)
				.accept(APPLICATION_JSON).contentType(APPLICATION_JSON).content(requestBodyString(4, 3, "-"));
		
		mvc.perform(mockHttpServletRequestBuilder).
		andExpect(status().isOk()).
		andExpect(content().json(webhookResponse("4 minus 3 is equal to 1").toString()));
	}
	
	@Test
	public void should_multiply_4_and_3_and_obtain_12() throws Exception {
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(url)
				.accept(APPLICATION_JSON).contentType(APPLICATION_JSON).content(requestBodyString(4, 3, "*"));
		
		mvc.perform(mockHttpServletRequestBuilder).
		andExpect(status().isOk()).
		andExpect(content().json(webhookResponse("4 multiplied by 3 is equal to 12").toString()));
	}
	
	@Test
	public void should_divide_4_and_2_and_obtain_2() throws Exception {
		MockHttpServletRequestBuilder mockHttp = MockMvcRequestBuilders.post(url).accept(APPLICATION_JSON).contentType(APPLICATION_JSON);
		mockHttp.content(requestBodyString(4, 2, "/"));
		
		mvc.perform(mockHttp).
			andExpect(status().isOk()).
			andExpect(content().json(webhookResponse("4 divided by 2 is equal to 2").toString()));
	}
	
	@Test
	public void should_not_divide_by_0() throws Exception {
		MockHttpServletRequestBuilder mockHttp = MockMvcRequestBuilders.post(url).accept(APPLICATION_JSON).contentType(APPLICATION_JSON);
		mockHttp.content(requestBodyString(4, 0, "/"));
		
		mvc.perform(mockHttp).
			andExpect(status().isOk()).
			andExpect(content().json(webhookResponse("Sorry, I can not divide by 0").toString()));
	}
}
