package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import java.util.Optional;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void SaveEntry(JournalEntry journalEntry){

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
