# apiai-webhook-sample

This application is a webhook used by the agent Evariste, an apiai chatbot.

Evariste is a chatbot that can calculate operations if you give to him two operands and one binary operator.
To make the calculation, Evariste must call a calculator service via a webhook.

This application is a springboot jar that exposes a webhook in a REST controller. 
The body of the request and the response must respect the apiai webhook format, see https://docs.api.ai/docs/webhook#section-format-of-request-to-the-service and https://docs.api.ai/docs/webhook#section-format-of-response-from-the-service.

You can chat in french with Evariste here : https://bot.api.ai/45b86593-6888-41a6-8b6d-343aa60011a0

Examples of sentences understood by Evariste : 
* 1 et 1
* Combien font 5 et 9
* Calcule moi 5 mulitplié par 7
