package com.cafe24.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MesureExecutionTimeAspect {

	@Around("execution(* *..repository.*.*(..)) || execution(* *..controller.*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		//before
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();
		//after
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;
		sw.stop();
		System.out.println(taskName +" 얼마나 걸리냐 : "+sw.getTotalTimeMillis());
		return result;
	}
}
