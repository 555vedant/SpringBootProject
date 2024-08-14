package com.VedsAPI.VedsAPI.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.VedsAPI.VedsAPI.JournalEntity.entity;


public interface journalRepository extends MongoRepository<entity , String> {
    //this is already interface give by the mongobd itself it does CURD oprations
    
}
