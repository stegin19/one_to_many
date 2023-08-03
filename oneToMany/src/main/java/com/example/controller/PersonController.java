package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/show")
    public List<Person>getAllPerson(){
        return (List<Person>) personRepository.findAll();
    }

    @PostMapping("/person")
    public ResponseEntity<String> savePerson(@RequestBody List<Person> perData){
    personRepository.saveAll(perData);
    return ResponseEntity.ok("Data Saved");
    }

    @PostMapping("/personid")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person _person = personRepository .save(new Person(person.getName(),person.getPassword()));
        return new ResponseEntity<>(_person, HttpStatus.CREATED);
    } 

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllPerson(){
        personRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    
}
