package com.knct_ci4_2025.kumasuta.stamp;

import java.util.ArrayList;
import java.util.Collections;

public class StampCard {

    public final static int STAMP_CARD_WID=3;
    public final static int STAMP_CARD_HEI=5;

    public final static int STAMP_NUM;

    static{
        STAMP_NUM=STAMP_CARD_WID*STAMP_CARD_HEI;
    }
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

    static int foo=0;

    public Stamp getStamp(int index){
        foo++;
        System.out.println(foo);
        try {
            return card.get(index);
        }catch (IndexOutOfBoundsException e){
            return new Stamp(foo);
        }
    }
}
