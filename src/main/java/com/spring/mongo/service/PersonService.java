package com.spring.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.mongo.model.Person;
import com.spring.mongo.model.Response;
import com.spring.mongo.repository.PersonRepo;

@Service
public class PersonService {
	
	 @Autowired
     private PersonRepo personRepo;
	
	public Response insertPerson(Person per)
	{
		try {
	//	personRepo.insert(new Person("1","Asghar","Mehmood","asghar.mehmood1@gmail.com","China","Beijing","Male",25,"21-09-2000","5465354654","0332541125","China town-Koln",3200.35,"Engineer"));
		personRepo.insert(per);
		return new Response(100,"SUCCESS");
		}
		catch(Exception ex)
		{
			return new Response(99,ex.getMessage());
		}
	}
	
	public Response deletePerson(String id)
	{
		personRepo.deleteById(id);
		return new Response(100,"SUCCESS");
	}
	
	public List<Person> allPerson()
	{
		return personRepo.findAll();
		
	}
	
	public Optional<Person> specificPerson(String name)
	{
		return personRepo.findById(name);//.findItemByName(name);
		
	}
	
	public Response updatePerson(String id,Person per)
	{
		Optional<Person> ps=personRepo.findById(id);
		if(ps.isPresent())
		{
			Person pq=ps.get();
			pq.setF_name(per.getF_name());
			pq.setL_name(per.getL_name());
			pq.setEmail(per.getEmail());
			pq.setCountry(per.getCountry());
			pq.setCity(per.getCity());
			pq.setGender(per.getGender());
			pq.setAge(per.getAge());
			pq.setDob(per.getDob());
			pq.setCnic(per.getCnic());
			pq.setCell(per.getCell());
			pq.setAddress(per.getAddress());
			pq.setSalaray(per.getSalaray());
			pq.setProfession(per.getProfession());
			personRepo.save(pq);
			return new Response(100,"SUCCESS");
	//		return new ResponseEntity<>(personRepo.save(pq),HttpStatus.OK);
		}
		else
		{
			return new Response(95,"NOT FOUND");
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
