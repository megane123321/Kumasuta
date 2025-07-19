package com.knct_ci4_2025.kumasuta.collection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.knct_ci4_2025.kumasuta.R;
import com.knct_ci4_2025.kumasuta.stamp.StampCard;
import com.knct_ci4_2025.kumasuta.stamp.StampId;
import com.knct_ci4_2025.kumasuta.stamp.StampView;

public class CollectionActivity extends AppCompatActivity {
    final static int COLLECTION_WID=2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.collection), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Insets motionArea=insets.getInsets(WindowInsetsCompat.Type.systemGestures());
            v.findViewById(R.id.collection_stamps).setPadding(motionArea.left,motionArea.top,motionArea.right,motionArea.bottom);
            return insets;
        });

        ImageButton collectionButton=(ImageButton) findViewById(R.id.back_form_collection);
        collectionButton.setOnClickListener((v)->{
            finish();
        });
    }
}
