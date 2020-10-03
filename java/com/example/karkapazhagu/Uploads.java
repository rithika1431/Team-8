package com.example.karkapazhagu;


public class Uploads {
    public String description;
    public  String url;


   
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
