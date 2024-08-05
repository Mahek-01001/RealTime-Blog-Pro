package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Service.JournalEntryService;
import net.engineeringdigest.journalApp.entity.JournalEntry;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2{
    @Autowired
    private JournalEntryService journalEntryService;

    @SuppressWarnings("static-access")
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<JournalEntry> all = journalEntryService.getAll();
        if(all != null && !all.isEmpty()){
        return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PostMapping
    public ResponseEntity<JournalEntry> CreateEntry(@RequestBody JournalEntry myEntry){
       try{
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.SaveEntry(myEntry);
         return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
       }
       catch(Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
       
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId  myId){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent()){
           return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
        }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId  myId){
        journalEntryService.DeleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId  id,JournalEntry newEntry){
        JournalEntry old= (JournalEntry) journalEntryService.findById(id).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.SaveEntry(old);
        return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
