package de.test;

import de.noInstrumentation.ShouldNotBeInstrumented;

class NonFinalFieldConstructorExample {

	private Integer parameters = 5;

	public Integer getParameters() {
		return parameters;
	}

}

public class MainClass {
	public static void main(String[] args) {
		NonFinalFieldConstructorExample example = new NonFinalFieldConstructorExample();
		System.out.println(example.getParameters());
		
		new ShouldNotBeInstrumented().myMethod();
	}
}
