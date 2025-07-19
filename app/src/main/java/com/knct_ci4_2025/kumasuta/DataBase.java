package com.knct_ci4_2025.kumasuta;

import com.knct_ci4_2025.kumasuta.stamp.StampCard;
import com.knct_ci4_2025.kumasuta.stamp.StampId;

import java.util.Arrays;

public class DataBase {
    public static StampCard card;
    public static boolean[] unlocked;

    static{
        card=new StampCard();
        unlocked=new boolean[StampId.values().length];
        Arrays.fill(unlocked, false);
    }
}
