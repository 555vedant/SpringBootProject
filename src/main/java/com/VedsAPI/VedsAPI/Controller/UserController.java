package com.VedsAPI.VedsAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VedsAPI.VedsAPI.JournalEntity.user;
import com.VedsAPI.VedsAPI.Service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<user> getAllUser() {
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<user> createUser(@RequestBody user user) {
    try {
        // Validate the user object if needed
        if (user.getUsername() == null || user.getPassword() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Bad Request if username or password is missing
        }

        // Save the user and return the created entity
        user createdUser = userService.saveEntry(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // Return 201 Created status

      } catch (Exception e) {
        // Log the exception (optional)
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Return 500 Internal Server Error
      }
    }


    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody user userx) {
        user userInDb = userService.findByUsername(userx.getUsername());
        if (userInDb != null) {
            userInDb.setUsername(userx.getUsername());
            userInDb.setPassword(userx.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

