package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
//    @Pointcut("execution(void aop.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(void aop.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(void aop.UniLibrary.get*()) || execution(void aop.UniLibrary.return*())")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log#1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing Log#2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log#3");
//    }



    //    @Before("execution(public void aop.UniLibrary.getBook())") // то что в скобках - pointcut
    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature " + methodSignature);
        System.out.println("methodSignature.getMethod() " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() " + methodSignature.getName());

        if(methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for(Object obj:arguments){
                if(obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("информация о книге: название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() + ", год издания - " + myBook.getYearOfPublication());
                }
                else if(obj instanceof String){
                    System.out.println("книгу в библиотеку добавляет " + obj);
                }
            }
        }

        System.out.println("beforeGetBookAdvice: попытка получить книгу/журнал");
        System.out.println("-----------------------------------");
    }

//    @Before("execution(public * returnBook())")
//    public void beforeReturnBookAdvice() {
//        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
//    }
}
