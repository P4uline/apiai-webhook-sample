package fr.casden.webhook;

import static java.lang.Integer.parseInt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.api.model.AIResponse;
import ai.api.model.Result;
import fr.casden.webhook.WebhookResponse;
import fr.casden.webhook.calc.Calculator;
import fr.casden.webhook.calc.binaryoperator.BinaryOperator;

@RestController
@RequestMapping(value = "/webhook")
public class WebhookController {
	
	@Autowired private Calculator calculator;
	
	
	private Logger logger = LoggerFactory.getLogger(WebhookController.class);

	@GetMapping
	public String index() {
		return "apiai-webhook-sample";
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public WebhookResponse treatAIResponse(@RequestBody AIResponse aiResponse) {
		Result result = aiResponse.getResult();
		if ("calc".equals(result.getAction())) {
			int a = parseInt(result.getStringParameter("a"));
			int b = parseInt(result.getStringParameter("b"));
			BinaryOperator op = BinaryOperator.getInstance(result.getStringParameter("operator"));

			try {
				String speech = speech(a, b, op, calculator.exec(a, b, op));
				return buildWebhookResponse(speech);
			} catch (ArithmeticException e) {
				logger.error("", e);
				return buildWebhookResponse(speechError(a, b, op));
			}
		}
		throw new IllegalStateException("Unknown action : '" + result.getAction() + "'");
	}

	private WebhookResponse buildWebhookResponse(String speech) {
		WebhookResponse webhookResponse = new WebhookResponse();
		webhookResponse.setDisplayText(speech);
		webhookResponse.setData(new Object[0]);
		webhookResponse.setSpeech(speech);
		webhookResponse.setSource("apiai-webhook-sample");
		webhookResponse.setContextOut(new Object[0]);
		return webhookResponse;
	}
	
	private String speech(int a, int b, BinaryOperator op, int calc) {
		return a + " " + op.labelize() + " " + b + " égal " + calc;
	}

	private String speechError(int a, int b, BinaryOperator op) {
		if ("/".equals(op.toString()) && b == 0) {
			return "Désolé, je ne peux pas diviser par 0";
		}
		return "Désolé, il y a eu une erreur arthmétique lorsque j'étais en train de calculer " + a + " " + op + " " + b;
	}
}
