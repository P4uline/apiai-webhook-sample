package fr.casden.webhook;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class WebhookResponse implements Serializable {

	private static final long serialVersionUID = 8719068818506711031L;

	private String displayText;

	private Object[] data;

	private String speech;

	private String source;

	private Object[] contextOut;

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

	public String getSpeech() {
		return speech;
	}

	public void setSpeech(String speech) {
		this.speech = speech;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Object[] getContextOut() {
		return contextOut;
	}

	public void setContextOut(Object[] contextOut) {
		this.contextOut = contextOut;
	}

	@Override
	public String toString() {

		JsonArray data = (JsonArray) new Gson().toJsonTree(this.data, new TypeToken<Object[]>() {}.getType());
		JsonArray contextOut = (JsonArray) new Gson().toJsonTree(this.contextOut, new TypeToken<Object[]>() {}.getType());

		JsonObject response = new JsonObject();
		response.addProperty("displayText", displayText);
		response.add("data", data);
		response.addProperty("speech", speech);
		response.addProperty("source", source);
		response.add("contextOut", contextOut);
		return response.toString();
	}
	
	@Override
	public boolean equals(Object webhook) {
		WebhookResponse other = (WebhookResponse) webhook;
		return speech.equals(other.getSpeech()) 
				&& displayText.equals(other.getDisplayText())
				&& source.equals(other.getSource());
	}
}
