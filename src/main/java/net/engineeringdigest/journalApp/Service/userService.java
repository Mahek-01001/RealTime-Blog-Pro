package net.engineeringdigest.journalApp.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.Repository.userRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
@Component
public class userService {
 @Autowired
    private userRepository UserRepository;

    public void SaveEntry(user journalEntry){

        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    //optional id a type bos means it can have data or maybe not
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void DeleteById(ObjectId id){
         journalEntryRepository.deleteById(id);
    }
}
