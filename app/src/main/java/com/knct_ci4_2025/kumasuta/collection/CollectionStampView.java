package com.knct_ci4_2025.kumasuta.collection;

import android.content.Context;
import android.view.View;

import com.knct_ci4_2025.kumasuta.R;
import com.knct_ci4_2025.kumasuta.stamp.Stamp;
import com.knct_ci4_2025.kumasuta.stamp.StampView;

public class CollectionStampView extends StampView {
    public CollectionStampView(Context context) {
        super(context);
        init();
    }
    public CollectionStampView(Context context,Stamp stamp) {
        super(context, stamp);
        init();
    }

    private void init(){
        setAdjustViewBounds(true);
    }

    @Override
    public void onClick(View v){
        System.out.println(getContext().getString(R.string.app_name));
    }
}
