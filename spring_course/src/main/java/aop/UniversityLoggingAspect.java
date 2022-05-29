package aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* addStudents())")
//    public void beforeGetStudentsLoggingAdvice(){
//        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов" +
//                "перед методом getStudents");
//    }

//    @AfterReturning(pointcut = "execution(* getStudents())",
//            returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
//        Student firstStudent = students.get(0);
//
//        String nameSurname = firstStudent.getName();
//        nameSurname = "Mr. " + nameSurname;
//        firstStudent.setName(nameSurname);
//
//        double avgGrade = firstStudent.getAvgGrade();
//        avgGrade = avgGrade + 1.0;
//        firstStudent.setAvgGrade(avgGrade);
//
//        System.out.println("afterReturningStudentsLoggingAdvice: логируем получение списка студентов" +
//                "после работы метода getStudents");
//    }

//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс" +
//                "исключения " + exception);
//
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: логируем нормальное окончание работы" +
                "метода getStudents или выброс исключения");
    }
}
