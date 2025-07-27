package com.knct_ci4_2025.kumasuta;

import com.knct_ci4_2025.kumasuta.stampCard.StampCard;
import com.knct_ci4_2025.kumasuta.stamp.StampId;

import java.util.Arrays;

public class DataBase {
    private static StampCard card;
    private static boolean[] unlocked;

    public static final int STAMP_VAL;

    public static StampCard getCard(){
        return card;
    }

    public static boolean getUnlocked(StampId id){
        return getUnlocked(getIntId(id));
    }

    public static int getDrawAbleId(StampId id){
        int drawable_id;
        switch (id){
            case STAMP_1:
                drawable_id=R.drawable.stamp_1;
                break;

            case STAMP_2:
                drawable_id=R.drawable.stamp_2;
                break;

            case STAMP_3:
                drawable_id=R.drawable.stamp_3;
                break;

            case STAMP_4:
                drawable_id=R.drawable.stamp_4;
                break;

            case STAMP_5:
                drawable_id=R.drawable.stamp_5;
                break;

            default:
                drawable_id=R.drawable.stamp_empty;
                break;
        }
        return drawable_id;
    }

    public static boolean getUnlocked(int id){
        if(inStampId(id)){
            return unlocked[id];
        }
        return false;
    }

    public static int getIntId(StampId id){
        StampId[] tmp=StampId.values();
        for (int i=1;i<tmp.length;i++){
            if(tmp[i].equals(id)){
                return i-1;
            }
        }
        return 0;
    }

    public static StampId getStampId(int id){
        if (inStampId(id)){
            return StampId.values()[id+1];
        }
        return StampId.STAMP_EMPTY;
    }

    private static boolean inStampId(int id){
        return id>=0&&id<STAMP_VAL;
    }

    static{
        STAMP_VAL=StampId.values().length-1;
        card=new StampCard();
        unlocked=new boolean[STAMP_VAL];
        Arrays.fill(unlocked, false);
    }
}
