package aop2;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	// Around Advice에서 사용할 공통기능 메서드는,
	// 대부분 파라미터로 전달받은 ProceedingJoinPoint의 proceed() 메서드만 호출
	// Proxy역할을 해서 
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toString();
		//핵심 관심사의 실행 메소드
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
		/* 각각의 메소드에 대해 성능 측정하는 */
	}
	
	public void beforeAdvice() {
		System.out.println("beforeAdvide()");
	}

	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}
	
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}
