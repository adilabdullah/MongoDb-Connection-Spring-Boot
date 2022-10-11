package com.spring.mongo;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;

public class MongoTest {

	public static void main(String[] args)
	{
try {
ConnectionString connectionString = new ConnectionString("mongodb+srv://adilabdullah:Alhamd357*@cluster-0.aymgixd.mongodb.net/?retryWrites=true&w=majority");
MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .serverApi(ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build())
        .build();
MongoClient mongoClient = MongoClients.create(settings);
MongoDatabase database = mongoClient.getDatabase("adil");

MongoCollection<Document> collection = database.getCollection("personal_info");

/*    InsertOneResult result = collection.insertOne(new Document()
            .append("_id", new ObjectId())
            .append("title", "Ski Bloopers")
            .append("genres", Arrays.asList("Documentary", "Comedy")));  */
  
		List<Document> movieList = Arrays.asList(
		new Document().append("_id", new ObjectId())
        .append("f_name", "Jeff")
		.append("l_name", "Scott")
		.append("email", "Jeff_scott11@yahoo.com")
		.append("country", "USA")
		.append("city", "New york")
		.append("gender", "male")
        .append("age",31)
        .append("dob", "16-04-1991")
        .append("cnic","4210172345455")
        .append("cell","03323366369")
        .append("address", "Manhattan")
		.append("profession", "Senior Data Scientist"));
        InsertManyResult result = collection.insertMany(movieList);  

/*MongoCursor<Document> cursor = collection.find().iterator();
while(cursor.hasNext()) {
    System.out.println(cursor.next().toJson());
}   */

    System.out.println("Inserted");
    System.out.println("Connected");
}
catch(Exception ex)
{
	ex.printStackTrace();
System.out.println(ex.getMessage());	
}
	}
	
}
