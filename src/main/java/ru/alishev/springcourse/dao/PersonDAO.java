package ru.alishev.springcourse.dao;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1(){
        Session session = entityManager.unwrap(Session.class);

        //1 запрос
        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();

        //N запросов к БД
        for (Person person:
             people) {
            System.out.println("Person" + person.getName() + " has: " + person.getItems());
            }


    }
}
