package fr.casden.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.google.gson.Gson;

import ai.api.GsonFactory;
import ai.api.model.AIResponse;

public class GsonTest {
	
	@Test
	public void should_deserialize_json_string_in_airesponse_object() {
		Gson gson = GsonFactory.getDefaultFactory().getGson();
		AIResponse aiResponse = gson.fromJson(ApiaiRequestUtils.requestBodyString(2, 3, "+"), AIResponse.class);
		
		assertThat(aiResponse.getId()).isEqualTo("779ddfcb-2546-46e1-a974-60c60d148e44");
		assertThat(aiResponse.getTimestamp()).isEqualTo("2017-04-24T14:53:11.072Z");
		assertThat(aiResponse.getLang()).isEqualTo("fr");
		assertThat(aiResponse.getResult().getSource()).isEqualTo("agent");
		assertThat(aiResponse.getResult().getSource()).isEqualTo("agent");
		assertThat(aiResponse.getSessionId()).isEqualTo("cedd4715-f1a4-44bb-8491-0023c83bcd46");
	}
}
