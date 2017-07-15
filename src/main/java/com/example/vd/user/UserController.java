package com.example.vd.user;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leandropozer on 20/06/17.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers(){
        return repository.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody String body){
        try {
            UserService service = new UserService();
            User user = service.createNewUser(body);

            user.setId(repository.count() + 1);

            repository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

}
