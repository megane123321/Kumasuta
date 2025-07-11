package com.knct_ci4_2025.kumasuta;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    final static int STAMP_CARD_WID=3;
    final static int STAMP_CARD_HEI=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        setContentView(R.layout.activity_stamp_card);
        ConstraintLayout view=(ConstraintLayout)findViewById(R.id.stamp_home);
        TableLayout stamp_card_view=(TableLayout)findViewById(R.id.stamp_card);
        Resources res=this.getBaseContext().getResources();
        for (int i = 0; i < STAMP_CARD_HEI; i++) {
            TableRow stamp_card_line=(TableRow)stamp_card_view.getChildAt(i);
            for (int j = 0; j < STAMP_CARD_WID; j++) {
                ImageView img=new ImageView(this.getBaseContext());
                Drawable drawable= ResourcesCompat.getDrawable(res,R.drawable.stamp_empty,null);
                img.setImageResource(R.drawable.stamp_empty);
                img.setMaxHeight(1000);
                img.setMinimumWidth(1000);
                img.setVisibility(View.VISIBLE);
//                img.setImageDrawable(drawable);
                System.out.println(img.getHeight()+" "+img.getWidth());
                stamp_card_line.addView(new Button(this.getBaseContext()));
                stamp_card_line.addView(img);
            }
        }
//        ImageView img=new ImageView(this.getBaseContext());
//        Drawable drawable= ResourcesCompat.getDrawable(res,R.drawable.stamp_empty,null);
//        img.setImageResource(R.drawable.stamp_empty);
//        img.setMaxHeight(1000);
//                img.setVisibility(View.VISIBLE);
//                img.setImageDrawable(drawable);
//        System.out.println(img.getHeight());
//        stamp_card_line.addView(new Button(this.getBaseContext()));
//        view.addView(img);
        setContentView(view);
    }
}