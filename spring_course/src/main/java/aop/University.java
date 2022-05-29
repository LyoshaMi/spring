package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Aleksey Mikhailov", 2, 4.5);
        Student st2 = new Student("Dimas Pavlov", 4, 5.8);
        Student st3 = new Student("Kirill Ivanov", 1, 4.2);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("начало работы метода getStudents ");
//        System.out.println(students.get(3));
        System.out.println("information from method getStudents:");
        System.out.println(students);
        return students;
    }
}
