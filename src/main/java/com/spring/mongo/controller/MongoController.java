package com.spring.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.model.Person;
import com.spring.mongo.model.Response;
import com.spring.mongo.service.PersonService;

@RestController
public class MongoController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/save")
	public ResponseEntity<Response> insertPerson(@RequestBody Person per)
	{
		return ResponseEntity.ok().body(personService.insertPerson(per));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deletePerson(@PathVariable("id") String id)
	{
		return ResponseEntity.ok().body(personService.deletePerson(id));
	}
	
	@GetMapping("/all/{id}")
	public  ResponseEntity<List<Person>> allPerson()
	{
		return ResponseEntity.ok().body(personService.allPerson());
		
	}
	
	@GetMapping("/specific")
	public ResponseEntity<Optional<Person>> specificPerson(@RequestParam("name") String name)
	{
		return ResponseEntity.ok().body(personService.specificPerson(name));
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updatePerson(@PathVariable("id") String id,@RequestBody Person per)
	{
		return ResponseEntity.ok().body(personService.updatePerson(id,per));
	}
	
}
