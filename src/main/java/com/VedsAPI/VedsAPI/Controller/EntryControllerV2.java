package com.VedsAPI.VedsAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.VedsAPI.VedsAPI.JournalEntity.entity;
import com.VedsAPI.VedsAPI.Service.journalServiceEntry;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Journal")
public class EntryControllerV2 {

    @Autowired
    private journalServiceEntry entryService;

    @GetMapping
    public List<entity> getJournalEntities() {
        return entryService.getAllEntries();
    }

    @PostMapping
    public ResponseEntity<entity> createEntry(@RequestBody entity myEntity) {
        entity createdEntity = entryService.saveEntry(myEntity);
        return ResponseEntity.ok(createdEntity);
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<entity> getJournalEntityById(@PathVariable Long myId) {
        Optional<entity> foundEntity = entryService.getEntryById(myId);
        return foundEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<Void> delete(@PathVariable Long myId) {
        boolean isDeleted = entryService.deleteEntry(myId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<entity> update(@PathVariable Long myId, @RequestBody entity updatedEntity) {
        Optional<entity> updated = entryService.updateEntry(myId, updatedEntity);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
