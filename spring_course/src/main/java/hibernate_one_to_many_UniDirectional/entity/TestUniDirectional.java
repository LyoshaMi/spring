package hibernate_one_to_many_UniDirectional.entity;


import hibernate_one_to_many_UniDirectional.entity.entity.Department;
import hibernate_one_to_many_UniDirectional.entity.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUniDirectional {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("HR", 500, 1500);
//            Employee emp1 = new Employee("Oleg", "Sidorov", 700);
//            Employee emp2 = new Employee("Igor", "Ivanov", 1100);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//
//            session.save(dep);
//
//            session.getTransaction().commit();



//
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Department department = session.get(Department.class, 2);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();



//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();



            session = factory.getCurrentSession();

            session.beginTransaction();

            Department department = session.get(Department.class, 2);
            session.delete(department);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
