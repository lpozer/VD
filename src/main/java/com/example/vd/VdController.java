package com.example.vd;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandropozer on 30/05/17.
 */

@RestController
@SpringBootApplication
public class VdController {

    @Autowired
    private VdRepository repository;

    @RequestMapping(value = "/vd", method = RequestMethod.GET)
    public List<Vd> getVd(){
        return repository.findAll();
    }

    @RequestMapping(value = "/vd/{id}", method = RequestMethod.GET)
    public Vd getVdById(@PathVariable String id){
        return repository.findById(Long.parseLong(id));
    }

    @RequestMapping(value = "/vd", method = RequestMethod.POST)
    public ResponseEntity<Vd> createVd(@RequestBody String body) throws IOException {
        try {
            Vd vd = parseBody(body);

            repository.save(vd);

            return new ResponseEntity<Vd>(vd, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private Vd parseBody(String body){
        //parse body
        JsonObject body_json = new JsonParser().parse(body).getAsJsonObject();
        String title = body_json.get("title").getAsString();

        //create VD object
        Vd vd = new Vd(repository.count() + 1, title);
        vd.setNumber(Long.toString(repository.count() + 1));
        //parse user
        User user = new User(body_json.getAsJsonObject("user"));
        vd.setUser(user);

        //parse expenses
        JsonArray expenses_array = body_json.getAsJsonArray("expenses");
        for(JsonElement element : expenses_array){
            Expense expense = new Expense(element.getAsJsonObject());
            vd.getExpenses().add(expense);
        }
        vd.setTotal();

        return vd;
    }

}
