package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(void abc*(..))")
//    @Pointcut("execution(void add*(..))")
    public void allAddMethods(){}
}
