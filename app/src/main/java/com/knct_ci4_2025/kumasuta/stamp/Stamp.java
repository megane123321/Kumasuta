package com.knct_ci4_2025.kumasuta.stamp;

public class Stamp {
    int id;
    public Stamp(){
        this(StampId.STAMP_EMPTY);
    }

    public Stamp(int stampId){
        id=stampId;
    }
}
