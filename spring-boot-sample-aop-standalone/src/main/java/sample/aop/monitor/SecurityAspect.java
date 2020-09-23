package sample.aop.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

	@Around("execution(* sample..transfetMoney(..))")
    public void logcheckCredentialsAdvice(ProceedingJoinPoint pjp) throws Throwable{
        
		Object[] args = pjp.getArgs();  
		if(args[3].equals(true)){
			System.out.println("l'utilisateur est authentifié");   
			pjp.proceed();
		}
		else {
			System.out.println("l'utilisateur n'est pas authentifié !");   
			}
	
	}
	
}
