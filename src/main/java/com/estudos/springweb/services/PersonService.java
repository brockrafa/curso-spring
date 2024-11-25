package com.estudos.springweb.services;

import com.estudos.springweb.models.Person;
import com.estudos.springweb.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResolutionException("No records found for this id"));
    }

    public Person create(Person person) {
        logger.info("Nova pessoa criada");
        return repository.save(person);
    }

    public Person update(Person person){
        Person pessoa = repository.findById(person.getId())
                .orElseThrow(()-> new ResolutionException("No records found for this id"));
        pessoa.setFirstName(person.getFirstName());
        pessoa.setLastName(person.getLastName());
        pessoa.setAddress(person.getAddress());
        pessoa.setGenre(person.getGenre());
        return repository.save(pessoa);
    }

    public void delete(Long id){
        Person pessoa = repository.findById(id)
                .orElseThrow(()-> new ResolutionException("No records found for this id"));
        repository.delete(pessoa);
    }
}
