package com.example.vd;

import com.example.vd.user.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leandropozer on 30/05/17.
 */
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class Vd {

    @Id
    private long id;
    private String number;
    private String title;
    private User user;
    private List<Expense> expenses = new ArrayList<Expense>();
    private float total;

    public Vd(){}

    public Vd(long id, String title){
        this.id = id;
        this.title = title;
        //this.user = user;
    }

    public long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public User getUser() { return this.user; }

    public List<Expense> getExpenses() { return this.expenses; }

    public String getNumber() { return this.number; }

    public float getTotal() { return this.total; }

    public void setId(long Id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setExpenses(List<Expense> expenses){ this.expenses = expenses; }

    public void setNumber(String number){
        Date date = new Date();
        String year = Integer.toString(date.getYear());
        this.number = number + "/" + year.substring(1);
    }

    public void setTotal(){
        float total = 0;
        for(Expense expense : expenses){
            total += expense.getValue();
        }
        this.total = total;
    }

}
