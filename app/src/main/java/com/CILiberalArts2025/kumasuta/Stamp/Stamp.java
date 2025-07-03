package com.example.kumasuta.Stamp;

public class Stamp {
    protected int id;
    private String date;

    Stamp(){
        this("yyyy/mm/dd");
    }

    Stamp(String date){
        this.date=date;
    }
}
