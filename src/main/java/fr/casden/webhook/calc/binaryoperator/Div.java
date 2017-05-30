package fr.casden.webhook.calc.binaryoperator;

public class Div extends BinaryOperator {

	@Override
	public int calc(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Divide by 0 is forbidden.");
		}
		return a / b;
	}

	@Override
	public String labelize() {
		return "divided by";
	}
	
	@Override
	public String toString() {
		return "/";
	}
}
