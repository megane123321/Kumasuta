package com.CILiberalArts2025.kumasuta;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.CILiberalArts2025.kumasuta.Stamp.StampCard;

public class MainActivity extends AppCompatActivity {

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

        ConstraintLayout layout=new ConstraintLayout(this);
        StampCard stamp=new StampCard(this);
        View view=findViewById(R.id.customViewTest);
        layout.forceLayout();
//        layout.addView(stamp.getView());
//        layout.addView(findViewById(R.id.customViewTest));
//        Logger logger=Logger.getLogger("debug");
//        logger.info(stamp.getView().toString());
//        addContentView(layout,layout.getLayoutParams());
        layout.addView(view);
        setContentView(layout);
    }
}