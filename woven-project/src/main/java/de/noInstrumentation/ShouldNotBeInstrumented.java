package de.noInstrumentation;

public class ShouldNotBeInstrumented {
	public void myMethod() {
		System.out.println("Shouldnt be changed");
	}
}