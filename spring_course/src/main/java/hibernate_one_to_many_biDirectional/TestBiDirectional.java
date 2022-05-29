package hibernate_one_to_many_biDirectional;

import hibernate_one_to_many_biDirectional.entity.Department;
import hibernate_one_to_many_biDirectional.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestBiDirectional {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("Sales", 300, 1200);
//            Employee emp1 = new Employee("Aleksey", "Mikhailov", 800);
//            Employee emp2 = new Employee("Igor", "Ivanov", 1000);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1100);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//
//            session.save(dep);
//
//            session.getTransaction().commit();




            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Get departament:");
            Department department = session.get(Department.class, 3);

            System.out.println("Show departament:");
            System.out.println(department);

            System.out.println("Show employees of the department:");
            System.out.println(department.getEmps());

            session.getTransaction().commit();



//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();


//
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 2);
//
//            session.delete(employee);

//            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
