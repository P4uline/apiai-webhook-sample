package fr.casden.webhook.calc.binaryoperator;

public class Plus extends BinaryOperator {

	@Override
	public int calc(int a, int b) {
		return a + b;
	}

	@Override
	public String labelize() {
		return "plus";
	}
	
	@Override
	public String toString() {
		return "+";
	}

}
