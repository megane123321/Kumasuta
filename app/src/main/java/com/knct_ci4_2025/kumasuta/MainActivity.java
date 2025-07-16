package com.knct_ci4_2025.kumasuta;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.knct_ci4_2025.kumasuta.stamp.Stamp;
import com.knct_ci4_2025.kumasuta.stamp.StampId;
import com.knct_ci4_2025.kumasuta.stamp.StampView;

public class MainActivity extends AppCompatActivity{

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
        Resources res=getBaseContext().getResources();
        for (int i = 0; i < STAMP_CARD_HEI; i++) {
            TableLayout.LayoutParams line_layout=new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            line_layout.weight=1;
            TableRow stamp_card_line=(TableRow)stamp_card_view.getChildAt(i);
            stamp_card_line.setLayoutParams(line_layout);
            for (int j = 0; j < STAMP_CARD_WID; j++) {
                int index=i*STAMP_CARD_WID+j;
                TableRow.LayoutParams params=new TableRow.LayoutParams();
                params.weight=1;
                StampView stamp=new StampView(getBaseContext(),DataBase.card.getStamp(index));
                stamp.setLayoutParams(params);
                stamp_card_line.addView(stamp);
            }
        }
        TextView stamp_num=(TextView)findViewById(R.id.stampNum);
        stamp_num.setText(String.format(getString(R.string.stamp_num),DataBase.card.getStampsNum()));
        setContentView(view);
    }
}