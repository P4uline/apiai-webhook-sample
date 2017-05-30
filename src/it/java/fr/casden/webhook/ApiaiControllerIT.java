package fr.casden.webhook;

import static fr.casden.utils.ApiaiRequestUtils.webhookResponse;
import static fr.casden.webhook.RequestEntityBuilder.newRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.JsonObject;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiaiControllerIT {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/apiai-webhook-sample/webhook");
	}

	@Test
	public void should_add_2_and_3_and_obtain_5() throws Exception {
		HttpEntity<JsonObject> entity = newRequest().header(APPLICATION_JSON).body(2, 3, "+").build();
		
		ResponseEntity<WebhookResponse> response = template.postForEntity(base.toString(), entity, WebhookResponse.class);
		assertThat(response.getBody(), equalTo(webhookResponse("2 plus 3 is equal to 5")));
	}
	
	@Test
	public void should_substract_4_and_3_and_obtain_1() {
		HttpEntity<JsonObject> entity = newRequest().header(APPLICATION_JSON).body(4, 3, "-").build();
		
		ResponseEntity<WebhookResponse> response = template.postForEntity(base.toString(), entity, WebhookResponse.class);
		assertThat(response.getBody()).isEqualTo(webhookResponse("4 minus 3 is equal to 1"));
	}

	@Test
	public void should_multiply_4_and_3_and_obtain_12() {
		HttpEntity<JsonObject> entity = newRequest().header(APPLICATION_JSON).body(4, 3, "*").build();
		
		ResponseEntity<WebhookResponse> response = template.postForEntity(base.toString(), entity, WebhookResponse.class);
		assertThat(response.getBody(), equalTo(webhookResponse("4 multiplied by 3 is equal to 12")));
	}
	
	@Test
	public void should_divide_4_and_2_and_obtain_2() {
		HttpEntity<JsonObject> entity = newRequest().header(APPLICATION_JSON).body(4, 2, "/").build();
		
		ResponseEntity<WebhookResponse> response = template.postForEntity(base.toString(), entity, WebhookResponse.class);
		assertThat(response.getBody(), equalTo(webhookResponse("4 divided by 2 is equal to 2")));
	}
	
	@Test
	public void should_not_divide_by_0() {
		HttpEntity<JsonObject> entity = newRequest().header(APPLICATION_JSON).body(4, 0, "/").build();
		
		ResponseEntity<WebhookResponse> response = template.postForEntity(base.toString(), entity, WebhookResponse.class);
		assertThat(response.getBody(), equalTo(webhookResponse("Sorry, I can not divide by 0")));
	}
}
