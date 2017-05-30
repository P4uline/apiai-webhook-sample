package fr.casden.webhook.calc.binaryoperator;

public class Mult extends BinaryOperator {

	@Override
	public int calc(int a, int b) {
		return a * b;
	}

	@Override
	public String labelize() {
		return "multiplied by";
	}
	
	@Override
	public String toString() {
		return "*";
	}

}
