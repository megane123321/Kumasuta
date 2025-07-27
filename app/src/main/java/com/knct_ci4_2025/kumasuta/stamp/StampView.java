package com.knct_ci4_2025.kumasuta.stamp;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.knct_ci4_2025.kumasuta.DataBase;
import com.knct_ci4_2025.kumasuta.R;

public abstract class StampView extends ConstraintLayout implements View.OnClickListener {
    public StampView(Context context) {
        this(context, new Stamp());
    }
    public StampView(Context context,Stamp stamp){
        super(context);
        stamp_bg=new ImageView(context);
        stamp_bg.setImageResource(R.drawable.stamp_empty);
        stamp_bg.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(stamp_bg);
        button=new StampButton(context,stamp,this);
        addView(button);
    }

    @Override
    public abstract void onClick(View view);

    protected ImageView stamp_bg;
    protected StampButton button;

    public ImageButton getButton(){
        return (ImageButton)button;
    }

    public void setStamp(int id){
        button.setStamp(id);
    }

    public void setStamp(Stamp stamp){
        button.setStamp(stamp);
    }

    public void setAdjustViewBounds(boolean bool){
        stamp_bg.setAdjustViewBounds(bool);
        button.setAdjustViewBounds(bool);
    }
}

class StampButton extends AppCompatImageButton {
    public StampButton(Context context, Stamp stamp, StampView view){
        super(context);
        setStamp(stamp);
        setOnClickListener(view);
    }

    public StampButton(Context context,StampView view){
        this(context,new Stamp(),view);
    }

    public void setStamp(int id){
        setStamp(new Stamp(id));
    }

    public void setStamp(Stamp stamp){
        int drawable_id=DataBase.getDrawAbleId(stamp.getId());
        if (drawable_id!=R.drawable.stamp_empty){
            setImageResource(drawable_id);
            setScaleType(ScaleType.FIT_CENTER);
        }else{
            setImageDrawable(null);
        }
    }
}
