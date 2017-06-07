package com.example.vd;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
            System.out.println(body);
            JsonObject obj = new JsonParser().parse(body).getAsJsonObject();
            String title = obj.get("title").toString().replaceAll("\"", "");

            Vd vd = new Vd((repository.count()+1), title);
            repository.save(vd);

            return new ResponseEntity<Vd>(vd, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
