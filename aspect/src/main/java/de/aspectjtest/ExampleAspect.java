package de.aspectjtest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExampleAspect {

	@Pointcut("!within(de.aspectjtest..*)")
	public void notWithinAspect() {
	}

	@Pointcut("!set(private * *)")
	public void noSet() {
		
	}
	
	@Pointcut("execution(* *(..)) || execution(new(..))")
	public void isAnExecution() {
		
	}
	
	@Before("notWithinAspect() && noSet() && isAnExecution()")
	public void aroundStuff(final JoinPoint thisJoinPoint)
			throws Throwable {
		System.out.println("=== Call1: " + thisJoinPoint.getSignature() + " " + thisJoinPoint.getKind());
	}
}
