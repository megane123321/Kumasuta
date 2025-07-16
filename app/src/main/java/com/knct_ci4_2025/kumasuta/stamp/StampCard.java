package com.knct_ci4_2025.kumasuta.stamp;

import java.util.ArrayList;
import java.util.Collections;

public class StampCard {
    ArrayList<Stamp> card;

    public StampCard(Stamp... stamps){
        card=new ArrayList<>();
        Collections.addAll(card, stamps);
    }

    public void addStamp(Stamp stamp){
        card.add(stamp);
    }

    public void addStamp(int id){
        addStamp(new Stamp(id));
    }

    public int getStampsNum(){
        return card.size();
    }

    public Stamp getStamp(int index){
        try {
            return card.get(index);
        }catch (IndexOutOfBoundsException e){
            return new Stamp();
        }
    }
}
