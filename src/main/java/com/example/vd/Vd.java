package com.example.vd;

/**
 * Created by leandropozer on 30/05/17.
 */
public class Vd {

    private long id;
    private String title;
    private User user;

    public Vd(){}

    public Vd(long id, String title, User user){
        this.id = id;
        this.title = title;
        this.user = user;
    }

    public long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public User getUser() { return this.user; }

}
