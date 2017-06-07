package com.example.vd;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by leandropozer on 30/05/17.
 */

@RestController
public class VdController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/vd", method = RequestMethod.GET)
    public Vd getVd(){
        return new Vd(counter.getAndIncrement(), "Vd de Teste");
    }

    @RequestMapping(value = "/vd", method = RequestMethod.POST)
    public ResponseEntity<Vd> createVd(@RequestBody String body) throws IOException {
        try {
            System.out.println(body);
            JsonObject obj = new JsonParser().parse(body).getAsJsonObject();
            System.out.println(obj.get("title").toString().replaceAll("\"", ""));
            System.out.println(obj.get("erro").toString());
            return new ResponseEntity<Vd>(new Vd(Long.parseLong(obj.get("id").toString()), obj.get("title").toString().replaceAll("\"", "")), HttpStatus.OK);
        } catch (NullPointerException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
