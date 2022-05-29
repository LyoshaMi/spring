package com.almikhailov.spring.rest;

import com.almikhailov.spring.rest.configuration.MyConfig;
import com.almikhailov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> allEmployees =  communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee empByID = communication.getEmployee(1);
//        System.out.println(empByID);

//        Employee employee = new Employee("Sveta", "Sokolov", "HR", 1000);
//        employee.setId(9);
//        communication.saveEmployee(employee);

        communication.deleteEmployee(9);
    }
}
