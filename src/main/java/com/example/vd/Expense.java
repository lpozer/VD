package com.example.vd;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by leandropozer on 08/06/17.
 */
public class Expense {
    private String name;
    private float value;

    public Expense(){}

    public Expense(JsonObject expense){
        this.name = expense.get("name").getAsString();
        this.value = expense.get("value").getAsFloat();
    }

    public Expense(String name, float value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public float getValue(){
        return this.value;
    }
}
