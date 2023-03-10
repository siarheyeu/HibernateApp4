package ru.alishev.springcourse.repositories;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.models.Mood;
import ru.alishev.springcourse.models.Person;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne (int id){
        Optional<Person> foundPeson = peopleRepository.findById(id);

        return foundPeson.orElse(null);
    }


    @Transactional
    public void save(Person person){
        person.setMood(Mood.CALM);
        peopleRepository.save(person);
    }

    @Transactional
    public void update (int id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);


        public void test(){
            System.out.println("Testing here with debug. Inside Hibernate Transaction");
        }
    }
}
