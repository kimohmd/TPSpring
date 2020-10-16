package sample.data.jpa.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before("execution(* sample..web..*(..))")
	public void logAllAdvice(JoinPoint joinpoint) {
		Signature signature = joinpoint.getSignature();
		String methode = signature.getName();
		String clazz = signature.getDeclaringTypeName();

		System.out.println("log : la classe :"+ clazz + " la methode appellée :" +  methode); 
		
	}
}