package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.Services.UserService;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    UserService userService;
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUserEntry(user);
    }


}
