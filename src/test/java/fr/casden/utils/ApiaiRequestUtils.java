package fr.casden.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import fr.casden.webhook.WebhookResponse;

public class ApiaiRequestUtils {

	public static JsonObject requestBody(int a, int b, String op) {
		JsonObject parameters = new JsonObject();
		parameters.addProperty("a", a);
		parameters.addProperty("b", b);
		parameters.addProperty("operator", op);

		JsonObject aiResponse = new JsonObject();
		aiResponse.addProperty("id", "779ddfcb-2546-46e1-a974-60c60d148e44");
		aiResponse.addProperty("timestamp", "2017-04-24T14:53:11.72Z");
		aiResponse.addProperty("lang", "fr");
		
		JsonObject result = new JsonObject();
		result.addProperty("source", "agent");
		result.addProperty("resolvedQuery", "immo");
		result.addProperty("speech", "");
		result.addProperty("action", "calc");
		result.addProperty("actionIncomplete", false);
		result.add("parameters", parameters);
		result.add("contexts", new JsonArray());
		
		JsonObject metadata = new JsonObject();
		metadata.addProperty("intentId", "f57d0ce6-8720-4279-b9f2-fb0874ff3ba4");
		metadata.addProperty("webhookUsed", true);
		metadata.addProperty("webhookForSlotFillingUsed", false);
		metadata.addProperty("intentName", "calculator");
		result.add("metadata", metadata);
		
		JsonObject message = new JsonObject();
		message.addProperty("type", 0);
		message.addProperty("speech", "");
		JsonArray messages = new JsonArray();
		messages.add(message);

		JsonObject fulfillment = new JsonObject();
		fulfillment.addProperty("speech", "");
		fulfillment.add("messages", messages);
		
		result.add("fulfillment", fulfillment);
		result.addProperty("score", 1.0);
		
		aiResponse.add("result", result);
		
		JsonObject status = new JsonObject();
		status.addProperty("code", 200);
		status.addProperty("errorType", "success");
		aiResponse.add("status", status);
		
		aiResponse.addProperty("sessionId", "cedd4715-f1a4-44bb-8491-0023c83bcd46");
		return aiResponse;
	}
	
	public static String requestBodyString(int a, int b, String op) {
		return requestBody(a, b, op).toString();
	}
	
	@Deprecated
	public static String oldRequestBody(int a, int b, String op) {
		StringBuilder parameters = new StringBuilder();
		parameters.append("	      \"parameters\":{  ");
		parameters.append("	         \"a\":\"" + a + "\",");
		parameters.append("	         \"b\":\"" + b + "\",");
		parameters.append("	         \"operator\":\"" + op + "\"");
		parameters.append("	      },");
			
		StringBuilder sb = new StringBuilder();
		sb.append("{  ");
		sb.append("	   \"id\":\"779ddfcb-2546-46e1-a974-60c60d148e44\",");
		sb.append("	   \"timestamp\":\"2017-04-24T14:53:11.72Z\",");
		sb.append("	   \"lang\":\"fr\",");
		sb.append("	   \"result\":{  ");
		sb.append("	      \"source\":\"agent\",");
		sb.append("	      \"resolvedQuery\":\"immo\",");
		sb.append("	      \"speech\":null,");
		sb.append("	      \"action\":\"calc\",");
		sb.append("	      \"actionIncomplete\":false,");
		sb.append(parameters);
		sb.append("	      \"contexts\":[");
		sb.append("	      ],");
		sb.append("	      \"metadata\":{");
		sb.append("	         \"intentId\":\"f57d0ce6-8720-4279-b9f2-fb0874ff3ba4\",");
		sb.append("	         \"webhookUsed\":true,");
		sb.append("	         \"webhookForSlotFillingUsed\":false,");
		sb.append("         \"intentName\":\"calculator\"");
		sb.append("      },");
		sb.append("      \"fulfillment\":{");
		sb.append("        	\"speech\":null,");
		sb.append("    		\"messages\":[  ");
		sb.append("	            {  ");
		sb.append("               \"type\":0,");
		sb.append("	               \"speech\":null");
		sb.append("	            }");
		sb.append("         ]");
		sb.append("	      },");
		sb.append("	      \"score\":1.0");
		sb.append("	   },");
		sb.append("	   \"status\":{");
		sb.append("	      \"code\":200,");
		sb.append("	      \"errorType\":\"success\"");
		sb.append("	   },");
		sb.append("   \"sessionId\":\"cedd4715-f1a4-44bb-8491-0023c83bcd46\"");
		sb.append("	}");
		return sb.toString();
	}

//	public static String webhookResponse(String speech) {
//		return webhookResponseJson(speech).toString();
//	}
	
	public static JsonObject webhookResponseJson(String speech) {
		JsonObject response = new JsonObject();
		response.addProperty("displayText", speech);
		response.add("data", new JsonArray());
		response.addProperty("speech", speech);
		response.addProperty("source", "apiai-webhook-sample");
		response.add("contextOut", new JsonArray());
		return response;
	}
	
//	public static String webhookResponse(String speech) {
//		return "{\"displayText\":\"" + speech + "\",\"data\":[],\"speech\":\"" + speech + "\",\"source\":\"apiai-webhook-sample\",\"contextOut\":[]}";
//	}
	
	public static WebhookResponse webhookResponse(String speech) {
		WebhookResponse webhookResponse = new WebhookResponse();
		webhookResponse.setDisplayText(speech);
		webhookResponse.setData(new Object[0]);
		webhookResponse.setSpeech(speech);
		webhookResponse.setSource("apiai-webhook-sample");
		webhookResponse.setContextOut(new Object[0]);
		return webhookResponse;
	}
}
