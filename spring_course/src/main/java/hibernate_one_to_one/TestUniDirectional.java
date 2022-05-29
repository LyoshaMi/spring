package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUniDirectional {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Aleksey", "Mikhailov", "IT", 500);
//            Detail detail = new Detail("Moscow", "123456789", "leshami@vk.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();



//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//            Detail detail = new Detail("SPB", "987654321", "olejik@vk.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            session.delete(employee);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
