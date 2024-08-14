package com.VedsAPI.VedsAPI.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.VedsAPI.VedsAPI.JournalEntity.user;

public interface userRepo extends MongoRepository<user , String> {
    //this is already interface give by the mongobd itself it does CURD oprations
    user findByUsername(String username);
}
