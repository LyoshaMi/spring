package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();

//            Section section1 = new Section("Football");
//            Child child1 = new Child("Aleksey", 7);
//            Child child2 = new Child("Dima", 7);
//            Child child3 = new Child("Masha", 6);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            section1.addChildrenToSection(child1);
//            section1.addChildrenToSection(child2);
//            section1.addChildrenToSection(child3);
//
//            session.save(child1);
//            session.save(child2);
//            session.save(child3);
//
//            session.getTransaction().commit();


//            Section section1 = new Section("Dance");
//            Child child1 = new Child("Olya", 12);
//            Child child2 = new Child("Grisha", 9);
//            Child child3 = new Child("Pavlik", 10);
//            section1.addChildrenToSection(child1);
//            section1.addChildrenToSection(child2);
//            section1.addChildrenToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(section1);
//
//            session.getTransaction().commit();



//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Misha", 7);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();



//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 4);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();


//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 7);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();


            session.beginTransaction();

            Section section = session.get(Section.class, 7);
            session.delete(section);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
