package com.knct_ci4_2025.kumasuta.stamp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.knct_ci4_2025.kumasuta.*;

public class StampDrawActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.view_test);
        View view=findViewById(R.id.customViewTest);
        setContentView(view);
    }
}
