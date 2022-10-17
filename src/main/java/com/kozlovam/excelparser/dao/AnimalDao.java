package com.kozlovam.excelparser.dao;

import com.kozlovam.excelparser.models.Animal;
import com.kozlovam.excelparser.util.HibernateSessionFactoryUtil;
import com.kozlovam.excelparser.models.Animal;
import com.kozlovam.excelparser.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AnimalDao {
    @Autowired
    HibernateSessionFactoryUtil hibernateSessionFactoryUtil;

    public void save(List<Animal> list)  {
        Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for(Animal animal:  list){
            session.save(animal);
        }
        tx1.commit();
        session.close();
    }
}

