package com.spring.mongo.model;

import java.sql.Timestamp;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("personal_info")
public class Person {

	 @Id
	 String id;
     String f_name;
	 String l_name;
	 String email;
	 String country;
	 String city;
	 String gender;
     int age;
     String dob;
     String cnic;
     String cell;
     String address;
     double salaray;
     String profession;
}
