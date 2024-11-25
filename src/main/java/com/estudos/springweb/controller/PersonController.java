package com.estudos.springweb.controller;

import com.estudos.springweb.models.Person;
import com.estudos.springweb.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    PersonService service;

    @GetMapping
    public List<Person> findAll(){
        return  this.service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable Long id){
        return this.service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person){
        return this.service.create(person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }



}
