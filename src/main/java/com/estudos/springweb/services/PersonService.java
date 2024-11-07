package com.estudos.springweb.services;

import com.estudos.springweb.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        List<Person> pessoas =  new ArrayList<>();
        pessoas.add(new Person(counter.incrementAndGet(),"Rafael","Male"));
        pessoas.add(new Person(counter.incrementAndGet(),"Dilaine","Female"));
        return pessoas;
    }

    public Person findById(Long id){
        return new Person(id,"Dilaine","Female");
    }

    public Person create(Person person) {
        logger.info("Nova pessoa criada");
        return person;
    }
}
