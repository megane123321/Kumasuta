package com.knct_ci4_2025.kumasuta.stamp;

public class Stamp {
    private StampId id;
    public Stamp(){
        this(StampId.STAMP_EMPTY);
    }

    public Stamp(StampId stampId){
        id=stampId;
    }

    public StampId getId(){
        return id;
    }

    public Stamp(int stampId){
        try {
            id = StampId.values()[stampId];
        }catch(ArrayIndexOutOfBoundsException e) {
            id=StampId.STAMP_EMPTY;
        }
    }
}
