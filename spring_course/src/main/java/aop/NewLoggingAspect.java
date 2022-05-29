package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturningBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturningBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        long begin = System.currentTimeMillis();
        Object targetMethodResult = proceedingJoinPoint.proceed();
        targetMethodResult = "Преступление и наказание"; // можно изменить результат работы метода
        long end = System.currentTimeMillis() - begin;

        System.out.println("aroundReturningBookLoggingAdvice: в библиотеку успешно вернули книгу");
        System.out.println("aroundReturningBookLoggingAdvice: метод returnBook " +
                "выполнил работу за " + end + "миллисекунд");
        return targetMethodResult;
    }
}
