package com.knct_ci4_2025.kumasuta.stamp;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.knct_ci4_2025.kumasuta.R;

public class StampView extends ConstraintLayout {
    public StampView(Context context) {
        this(context, new Stamp());
    }
    public StampView(Context context,Stamp stamp){
        super(context);
        ImageView stamp_bg=new ImageView(context);
        stamp_bg.setImageResource(R.drawable.stamp_empty);
        stamp_bg.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(stamp_bg);
        button=new StampButton(context,stamp);
        addView(button);
    }

    StampButton button;

    public ImageButton getButton(){
        return (ImageButton)button;
    }
}

class StampButton extends AppCompatImageButton implements View.OnClickListener {
    public StampButton(Context context,Stamp stamp){
        super(context);
        int drawable_id;
        switch (stamp.id){
            case StampId.STAMP_1:
                drawable_id=R.drawable.stamp_1;
            break;

            case StampId.STAMP_2:
                drawable_id=R.drawable.stamp_2;
            break;

            case StampId.STAMP_3:
                drawable_id=R.drawable.stamp_3;
            break;

            case StampId.STAMP_4:
                drawable_id=R.drawable.stamp_4;
            break;

            case StampId.STAMP_5:
                drawable_id=R.drawable.stamp_5;
            break;

            default:
                drawable_id=R.drawable.stamp_empty;
            break;
        }
        if (drawable_id!=R.drawable.stamp_empty){
            setImageResource(drawable_id);
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        System.out.println(view.toString());
    }
}
