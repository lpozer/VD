package com.example.vd.user;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static java.util.Arrays.asList;

/**
 * Created by leandropozer on 12/07/17.
 */
public class UserService {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User createNewUser(String body){
        JsonObject user_json = new JsonParser().parse(body).getAsJsonObject().getAsJsonObject("user");
        System.out.println(user_json);
        User user = new User();

        user.setName(user_json.get("name").getAsString());
        user.setCpf(user_json.get("cpf").getAsString());
        user.setBank_account(user_json.get("bank_account").getAsString());
        user.setBank_agency(user_json.get("bank_agency").getAsString());
        user.setProject(user_json.get("project").getAsString());
        user.setUserName(user_json.get("userName").getAsString());
        user.setPassword(
                passwordEncoder().encode(
        user_json.get("password").getAsString()));

        //user.setPassword(user_json.get("password").getAsString());

        user.setAuthorities(asList("user"));

        return user;
    }
}
