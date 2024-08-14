package com.VedsAPI.VedsAPI.JournalEntity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//there is project named lombok from which using the anotatoin we can just build a setter , getter and many applications in compile time itself

@Document(collation = "journal_entries")
public class entity {
    @Id
    private String id ; 
    
    private String name ; 
    private String content;
    private Date date ;
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
}
