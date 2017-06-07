package com.example.vd;

import org.springframework.data.annotation.Id;

/**
 * Created by leandropozer on 30/05/17.
 */
public class Vd {

    @Id
    private long id;
    private String title;
    private User user;

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

    public void setId(long Id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setUser(User user){
        this.user = user;
    }

}
