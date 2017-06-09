package com.example.vd;

import com.google.gson.JsonObject;

/**
 * Created by leandropozer on 06/06/17.
 */
public class User {

    private String name;
    private String cpf;
    private String bank_account;
    private String bank_agency;
    private String project;

    public User(){}

    public User(JsonObject user){
        this.name = user.get("name").getAsString();
        this.cpf = user.get("cpf").getAsString();
        this.bank_account = user.get("bank_account").getAsString();
        this.bank_agency = user.get("bank_agency").getAsString();
        this.project = user.get("project").getAsString();
    }

    public User(String name, String cpf, String bank_account, String bank_agency, String project){
        this.name = name;
        this.cpf = cpf;
        this.bank_account = bank_account;
        this.bank_agency = bank_agency;
        this.project = project;
    }

    public String getName(){
        return this.name;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getBank_account(){
        return this.bank_account;
    }

    public String getBank_agency(){
        return this.bank_agency;
    }

    public String getProject(){
        return this.project;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setBank_account(String bank_account){
        this.bank_account = bank_account;
    }

    public void setBank_agency(String bank_agency){
        this.bank_agency = bank_agency;
    }

    public void setProject(String project){
        this.project = project;
    }


}
