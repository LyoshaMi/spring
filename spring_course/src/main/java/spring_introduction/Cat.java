package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("catBean")
//@Scope(scopeName = "prototype")
public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat bean is created");
    }

    @PostConstruct
    public void init(){
        System.out.println("Class cat init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Class cat destroy method");
    }

    @Override
    public void say() {
        System.out.println("meow-meow");
    }
}
