package com.knct_ci4_2025.kumasuta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.knct_ci4_2025.kumasuta.stamp.StampDrawActivity;

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
        View view=findViewById(R.id.stamp_home);
        TableRow stamp_table=(TableRow)findViewById(R.id.stamp_card_0);
        stamp_table.addView(new Button(this.getBaseContext()));
        setContentView(view);
    }
}