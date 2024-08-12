package com.VedsAPI.VedsAPI.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VedsAPI.VedsAPI.Controller.JournalEntity.entity;

import java.util.*;


@RestController
@RequestMapping("/Journal")
public class EntryController {
    //from here we can start building our methods and stuffs
    //we dont have database so will just work with JSON objects using any data structure
    //we are using that entity so in above we have just imported it 
    private Map <Long , entity> journalEntity = new HashMap<>();
    
    @GetMapping
    public List<entity> getJournalEntities() {
        return new ArrayList<>(journalEntity.values());

    }
    @PostMapping
    public boolean createEntry(@RequestBody entity mEntity){
        journalEntity.put(mEntity.getId(), mEntity);
        return true;
    }
    //there are two diffrent things path variable and request parameter 
    //if your id is like this localhost:8080/journal/id   -> this is basically path varible 

    //request parameter @GetMapping("id/{myId}")
    @GetMapping("id/{myId}")
    public entity getSpecificEntity(@PathVariable Long myId){
        return journalEntity.get(myId); 
    }

    //if we want to delete some entry
    @DeleteMapping("id/{myId}")
    public entity delete(@PathVariable Long myId){
        return journalEntity.remove(myId);
    }

    //if we just wanted to make a new entity on it 
    @PutMapping("id/{myId}")
    public entity update(@PathVariable Long myId, @RequestBody entity updatedEntity){
        return journalEntity.put(myId, updatedEntity);
    }
}
