package fr.casden.webhook.calc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.casden.webhook.calc.Calculator;

public class CalculatorTest {
	
	private Calculator calculator = new Calculator();

	@Test
	public void should_add_2_and_3_and_obtain_5() {
		assertThat(calculator.exec(2, 3, "+")).isEqualTo(5);
	}
	
	@Test
	public void should_substract_4_and_3_and_obtain_1() {
		assertThat(calculator.exec(4, 3, "-")).isEqualTo(1);
	}
	
	@Test
	public void should_multiply_4_and_3_and_obtain_12() {
		assertThat(calculator.exec(4, 3, "*")).isEqualTo(12);
	}
	
	@Test
	public void should_divide_4_and_2_and_obtain_2() {
		assertThat(calculator.exec(4, 2, "/")).isEqualTo(2);
	}
	
	@Test(expected=ArithmeticException.class)
	public void should_not_divide_by_0() {
		assertThat(calculator.exec(4, 0, "/")).isEqualTo(2);
	}
}
