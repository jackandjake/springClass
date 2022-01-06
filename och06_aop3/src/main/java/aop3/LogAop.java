package aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	@Pointcut("within(aop3.buz.*)") // aop3.buz 패키지 안에 있는 모든 메소드
	private void pointcutMethod() {
	}
	
	    @Around("pointcutMethod()")
		public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
			String signatureStr = joinpoint.getSignature().toShortString();
			System.out.println( signatureStr + " is start. ");
			long st = System.currentTimeMillis();
			
			try { 
				//핵심관심사를 실행시킴
				Object obj = joinpoint.proceed();
				return obj;
			} finally {
				long et = System.currentTimeMillis();
				System.out.println( signatureStr + " is finished.");
				System.out.println( signatureStr + " 경과시간: " + (et- st));		
			}
	}
	@Before("within(aop3.buz.*)")
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	@After("within(aop3.buz.*)")
	public void afterAdvice() {
		System.out.println("@AfterAdvice()");
	}
}

