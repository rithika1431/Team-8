package com.example.karkapazhagu;


public class Uploads {
    public String description;
    public  String url;


    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Uploads() {
    }

    public Uploads( String description, String url) {
        this.description=description;
        this.url=url;
    }


    public String getDescription(){
        return description;
    }

    public String getUrl(){
        return  url;
    }
}
