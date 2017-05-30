package fr.casden.webhook;

import static fr.casden.utils.ApiaiRequestUtils.requestBody;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.google.gson.JsonObject;

public class RequestEntityBuilder {

	private HttpHeaders headers = new HttpHeaders();
	private JsonObject body;
	
	public static RequestEntityBuilder newRequest() {
		return new RequestEntityBuilder();
	}
	
	public RequestEntityBuilder header(MediaType header) {
		headers.setContentType(header);
		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(header);
		headers.setAccept(mediaTypes);
		return this;
	}

	public RequestEntityBuilder body(int a, int b, String op) {
		this.body = requestBody(a, b, op);
		return this;
	}
	
	public HttpEntity<JsonObject> build() {
		return new HttpEntity<JsonObject>(body, headers);
	}
}
