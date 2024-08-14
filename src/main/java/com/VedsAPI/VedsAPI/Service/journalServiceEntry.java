// package com.VedsAPI.VedsAPI.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
// import org.springframework.stereotype.Component;

// import com.VedsAPI.VedsAPI.Controller.JournalEntity.entity;
// import com.VedsAPI.VedsAPI.Repository.journalRepository;

// @Component


// //basically Component annotation is used to inject the class into beans
// public class journalServiceEntry{
//     //controller -> service -> repository 
//     //we will follow this path for project
//     private journalRepository journalRepository;
//     @Autowired
//     public journalServiceEntry(entity Entity){
//         // this.journalRepository = journalRepository;
//         journalRepository.save(Entity);
//     }

// }

// ----------------------------------------------------------------------
package com.VedsAPI.VedsAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VedsAPI.VedsAPI.JournalEntity.entity;
import com.VedsAPI.VedsAPI.Repository.journalRepository;

@Service
public class journalServiceEntry {

    private final journalRepository journalRepository;

    @Autowired
    public journalServiceEntry(journalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    // Removed @Autowired from the method
    public entity saveEntry(entity entity) {
        return journalRepository.save(entity);
    }

    public Optional<entity> getEntryById(Long myId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEntryById'");
    }

    public boolean deleteEntry(Long myId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEntry'");
    }

    public Optional<entity> updateEntry(Long myId, entity updatedEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEntry'");
    }

    public List<entity> getAllEntries() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEntries'");
    }
}
