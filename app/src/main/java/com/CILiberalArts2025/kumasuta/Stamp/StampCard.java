package com.example.kumasuta.Stamp;

import android.app.ActionBar;
import android.content.Context;
import android.view.View;
import android.widget.TextView;


import androidx.constraintlayout.widget.Constraints;

import java.util.ArrayList;
import java.util.Collections;

public class StampCard {
    ArrayList<Stamp> card;
    Context context;

    public StampCard(Context context, Stamp... stamps){
        card=new ArrayList<>();
        Collections.addAll(card, stamps);
    }

    public int getStampsNum(){
        return card.size();
    }

    public View getView(){
        TextView text=new TextView(context);
        char[] textChar="Oh!Banana.".toCharArray();
        text.setText(textChar,0,textChar.length);
        text.setTextColor(0);
        text.setLayoutParams(
                new Constraints.LayoutParams(100,100)
        );
        return text;
    }
}
