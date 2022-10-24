package com.xec.hibernate.entity.inheritance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;

public class Application {

    public static void main(String[] args) {
        createEmployee();
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return null;
    }

    public static void createEmployee() {
        System.out.println("****************Creating Employee*************");
        Employee emp = new Employee();
        emp.setName("John");

        ContractEmployee contEmp = new ContractEmployee();
        contEmp.setName("Mike");
        contEmp.setType("CONTRACT");

        PermanentEmployee perEmp = new PermanentEmployee();
        perEmp.setName("Jordan");
        perEmp.setType("PERMANENT");

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(emp);
        session.save(contEmp);
        session.save(perEmp);
        session.getTransaction().commit();
        session.close();
    }
}