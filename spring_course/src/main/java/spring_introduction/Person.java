package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("personBean")
public class Person {

//    @Autowired
//    @Qualifier("catBean")
    private Pet pet;
//    @Value("Mikhailov")
    @Value("${person.surname}")
    private String surname;
//    @Value("21")
    @Value("${person.age}")
    private int age;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Person(){}

//    @Autowired
//    public Person(@Qualifier("dogBean") Pet pet) {
//        this.pet = pet;
//    }
//

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }
//    @Autowired
//    @Qualifier("dogBean")
//    // pet -> setPet
//    public void setPet(Pet pet) {
//        System.out.println("Class person set pet");
//        this.pet = pet;
//    }

    public void callYourPet(){
        System.out.println("Hello my pet!");
        pet.say();
    }
}
