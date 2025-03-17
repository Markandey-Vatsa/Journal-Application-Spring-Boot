package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Repository.UserEntryRepository;
import net.engineeringdigest.journalApp.Services.JournalEntryService;
import net.engineeringdigest.journalApp.Services.UserService;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

//    -> To update password, if username is given.

//    Below method assumes that the user is already authenticated and it is changing the password/username.
    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDB = userService.findByUserName(username);
            userInDB.setUserName(user.getUserName());
            userInDB.setPassword(user.getPassword());
          userService.saveUserEntry(userInDB);
            return new ResponseEntity<>(HttpStatus.OK);
    }




}
