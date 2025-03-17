package net.engineeringdigest.journalApp.Services;


import net.engineeringdigest.journalApp.Repository.UserEntryRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    private UserEntryRepository UserRepository;

    public void saveUserEntry(User UserEntry){
        UserRepository.save(UserEntry);
    }


    public void saveNewUserEntry(User UserEntry){
        UserEntry.setPassword(passwordEncoder.encode(UserEntry.getPassword()));
        UserEntry.setRoles(Arrays.asList("USER"));
        UserRepository.save(UserEntry);
    }




    public List<User> getAllEntries(){
        return UserRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){  // -> optional -> isme ya to ho sakta hai ya nhi bhi ho sakta hai
        return UserRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        UserRepository.deleteById(id);
    }


    public User findByUserName(String userName){
        return UserRepository.findByUserName(userName);
    }


    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("ADMIN","USER"));
        UserRepository.save(user);
    }

    public void newFunction(){
        System.out.println("hello");
    }
}
