package com.knct_ci4_2025.kumasuta.stamp;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.knct_ci4_2025.kumasuta.R;

public class StampView extends FrameLayout {
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

    public void setStamp(int id){
        button.setStamp(id);
    }

    public void setStamp(Stamp stamp){
        button.setStamp(stamp);
    }
}

class StampButton extends AppCompatImageButton implements View.OnClickListener {
    public StampButton(Context context,Stamp stamp){
        super(context);
        setStamp(stamp);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        System.out.println(view.toString());
    }

    public void setStamp(int id){
        setStamp(new Stamp(id));
    }

    public void setStamp(Stamp stamp){
        int drawable_id;
        switch (stamp.id){
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
        if (drawable_id!=R.drawable.stamp_empty){
            setImageResource(drawable_id);
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }else{
            setImageDrawable(null);
        }
    }
}
