package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Catalog.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Reader.class)
                .buildSessionFactory();
        Session session = null;

        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Reader reader = session.get(Reader.class, 1);
            Book book = session.get(Book.class, 2);
            reader.getBooks().add(book);
            //reader.getBooks().clear();
            session.getTransaction().commit();


//            session = factory.getCurrentSession();
//            Author author = new Author();
//            author.setName("Rowling");
//            session.beginTransaction();
//            session.save(author);
//            session.getTransaction().commit();


            // CREATE
//            session = factory.getCurrentSession();
//            Catalog catalog = new Catalog("Fantasy #14");
//            session.beginTransaction();
//            session.save(catalog);
//            session.getTransaction().commit();

            //READ
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog2 = session.get(Catalog.class, 2L);
//            session.getTransaction().commit();
//            System.out.println(catalog2);

            // UPDATE
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog = session.get(Catalog.class, 1L);
//            session.detach(catalog);
//            catalog.setTitle("Fantasy #8");
//            session.getTransaction().commit();

            // DELETE
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog = session.get(Catalog.class, 1L);
//            session.delete(catalog);
//            session.getTransaction().commit();



        } finally {
            factory.close();
            session.close();

        }
    }
}
