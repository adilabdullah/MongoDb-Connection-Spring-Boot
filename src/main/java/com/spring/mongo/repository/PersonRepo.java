package com.spring.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.mongo.model.Person;

@Repository
public interface PersonRepo extends MongoRepository<Person, String>{
 /*   @Query("{name:'?0'}")
    Person findItemByName(String name);
    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Person> findAll(String category);
    
    public long count(); */
}
