package fr.casden.webhook.calc.binaryoperator;

public abstract class BinaryOperator {
	

	public static BinaryOperator getInstance(String op) {
		switch(op) {
			case "+": return new Plus();
			case "-": return new Sub();
			case "*": return new Mult();
			case "/": return new Div();
			default : throw new IllegalStateException("Unknown binary operator : '" + op + "'. Known binary operators are +, -, * and /.");
		}
	}

	public abstract int calc(int a, int b);
	
	public abstract String labelize();
	
}
