package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog myDog = context.getBean("dogBean", Dog.class);
        myDog.say();
        context.close();
//        Dog yourDog = context.getBean("dogBean", Dog.class);
//
//        System.out.println("Перменные ссылаются на один и тот же объект? "
//        + (myDog == yourDog));
//
//        System.out.println(myDog);
//        System.out.println(yourDog);
    }
}
