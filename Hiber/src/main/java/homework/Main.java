package homework;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Shopper.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(OrderKey.class)
                .buildSessionFactory();
        Session session = null;

        try{
            Scanner input = new Scanner(System.in);

            while(input.hasNext()){
                String command = input.nextLine();
                if (command.equals("exit")){
                    break;
                }

                String[] commands = command.split(" ");
                switch (commands[0]){
                    case "/buy":
                        System.out.println("/buy");
                        session = factory.getCurrentSession();
                        session.beginTransaction();

                        Shopper shopper = (Shopper) session
                                .createQuery("FROM Shopper s WHERE s.name = :name")
                                        .setParameter("name", commands[1]).getSingleResult();

                        Product product = (Product) session
                                .createQuery("FROM Product p WHERE p.name = :name")
                                        .setParameter("name", commands[2]).getSingleResult();

                        OrderKey orderKey = new OrderKey();
                        orderKey.setShopperId(shopper.getId());
                        orderKey.setProductId(product.getId());

                        Order order = new Order();
                        order.setOrderKey(orderKey);
                        order.setCost(product.getCost());
                        session.save(order);
                        session.getTransaction().commit();
                        break;

                    case "/showProductByShopper":
                        System.out.println("/showProductByShopper");
                        session = factory.getCurrentSession();
                        session.beginTransaction();

                        shopper = (Shopper) session
                                .createQuery("FROM Shopper s WHERE s.name = :name")
                                        .setParameter("name", commands[1]).getSingleResult();

                        List<Order> orders = shopper.getOrders();

                        orders.forEach(o ->
                                System.out.println("Shopper products " + shopper.getName() + ": " + o.getProduct().toString()));
                        session.getTransaction().commit();
                        break;
                    case "/findShopperByProductTitle":
                        System.out.println("findShopperByProductTitle");
                        session = factory.getCurrentSession();
                        session.beginTransaction();

                        product = (Product) session
                                .createQuery("FROM Product p WHERE p.name = :name")
                                        .setParameter("name", commands[1]).getSingleResult();
                        orders = product.getOrders();
                        orders.forEach(o ->
                                System.out.println("Products for " + product.getName() + ": " + o.getShopper().toString()));
                        session.getTransaction().commit();
                        break;
                }
            }
        } finally {
            factory.close();
            session.close();

        }
    }
}
