package com.example.vd;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by leandropozer on 04/07/17.
 */
@Controller
public class ViewController {

    @RequestMapping("/login")
    public String greeting() {
        return "login";
    }

    @RequestMapping("/hello")
    public String hello() { return "hello"; }
}
