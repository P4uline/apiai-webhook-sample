package fr.casden.webhook.calc;

import org.springframework.stereotype.Service;

import fr.casden.webhook.calc.binaryoperator.BinaryOperator;

@Service
public class Calculator {

	public int exec(int a, int b, String op) {
		return exec(a, b, BinaryOperator.getInstance(op));
	}
	
	public int exec(int a, int b, BinaryOperator op) {
		return op.calc(a, b);
	}
}
