package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestBiDirectional {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Misha", "Sidorov", "HR", 850);
//            Detail detail = new Detail("London", "4265436265", "mishka@vk.com");
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.beginTransaction();
//            session.save(detail);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 3);
//            System.out.println(detail.getEmployee());
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 3);
//            session.delete(detail);
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 2);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);// чтобы удалить работника у которого поле это FK на details, мы разрушаем связь между ними

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
