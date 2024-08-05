package net.engineeringdigest.journalApp.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection  = "user")
@Data
public class userEntity {
@Id    
private ObjectId id;
//add the spring.data.mongodb.auto-index-creation=true in applicatn.properties file to enable this 
//indexing
@Indexed(unique = true)
@NonNull
private String userName;
@NonNull
private String Password;

 //creating a reference in collection user of collection JournalEntry it will store the object id/reference of 
 //journal entries
    @DBRef
   private List<JournalEntry> journalEntries = new ArrayList<>();
}
