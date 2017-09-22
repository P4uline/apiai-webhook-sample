package fr.casden.webhook.calc.binaryoperator;

public class Sub extends BinaryOperator {

	@Override
	public int calc(int a, int b) {
		return a - b;
	}

	@Override
	public String labelize() {
		return "moins";
	}
	
	@Override
	public String toString() {
		return "-";
	}

}
