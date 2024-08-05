package net.engineeringdigest.journalApp.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;


import java.time.LocalDateTime;


@Document(collection ="Journal_entries")

public class JournalEntry {
 @Id
    private ObjectId id;
    @NonNull
    private  String title;
    private String content;
    private LocalDateTime date;
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

   
   
}
