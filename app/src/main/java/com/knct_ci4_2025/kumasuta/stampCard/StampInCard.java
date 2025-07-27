package com.knct_ci4_2025.kumasuta.stampCard;

import android.content.Context;
import android.view.View;

import com.knct_ci4_2025.kumasuta.stamp.Stamp;
import com.knct_ci4_2025.kumasuta.stamp.StampView;

public class StampInCard extends StampView {

    public StampInCard(Context context){
        super(context);
    }
    public StampInCard(Context context, Stamp stamp){
        super(context,stamp);
    }
    @Override
    public void onClick(View v){
        System.out.println(v.toString());
    }
}
