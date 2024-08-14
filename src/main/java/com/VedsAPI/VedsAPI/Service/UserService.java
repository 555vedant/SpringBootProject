// package com.VedsAPI.VedsAPI.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
// import org.springframework.stereotype.Component;

// import com.VedsAPI.VedsAPI.Controller.JournalEntity.entity;
// import com.VedsAPI.VedsAPI.Repository.userRepo;

// @Component


// //basically Component annotation is used to inject the class into beans
// public class journalServiceEntry{
//     //controller -> service -> repository 
//     //we will follow this path for project
//     private userRepo userRepo;
//     @Autowired
//     public journalServiceEntry(entity Entity){
//         // this.userRepo = userRepo;
//         userRepo.save(Entity);
//     }

// }

// ----------------------------------------------------------------------
package com.VedsAPI.VedsAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VedsAPI.VedsAPI.JournalEntity.user;
import com.VedsAPI.VedsAPI.Repository.userRepo;

@Service
public class UserService {

    private final userRepo userRepo;

    @Autowired
    public UserService(userRepo userRepo) {
        this.userRepo = userRepo;
    }

    public user saveEntry(user userx) {
        return userRepo.save(userx);
    }

    public List<user> getAll() {
        return userRepo.findAll();
    }

    public user findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
