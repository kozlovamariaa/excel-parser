package com.kozlovam.excelparser.util;

import com.kozlovam.excelparser.models.Animal;
import com.kozlovam.excelparser.models.Bird;
import com.kozlovam.excelparser.models.Dog;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    public HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Animal.class);
                configuration.addAnnotatedClass(Dog.class);
                configuration.addAnnotatedClass(Bird.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}