    package com.paynestsystem.domain;
    
    //2.Customer class using the same process I used for product

public class Customer {

    private int id;
    private String name;
    private String email;

   public Customer (int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId () {
        return id;
    }
    public String getName () {
        return name;
    }

    public String getEmail () {
        return email;
    }

}



