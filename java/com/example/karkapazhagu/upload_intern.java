package com.example.karkapazhagu;

public class upload_intern {

    public String name;
    public String description;
    public String url;


    
    public upload_intern() {
    }

    public upload_intern(String name, String description, String url) {
        this.name = name;
        this.description=description;
        this.url= url;

    }

    public String getName() {
        return name;
    }

    public String getDescription(){return description;}

    public String getUrl() {
        return url;
    }



}
