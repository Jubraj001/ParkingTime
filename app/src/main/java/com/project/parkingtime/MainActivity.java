package com.project.parkingtime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.project.parkingtime.Inst_Reg;
import com.project.parkingtime.R;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout inst_btn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inst_btn=(RelativeLayout) findViewById(R.id.inst);
        inst_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInst_Reg();
            }
        });
    }
    public void openInst_Reg(){
        Intent intent = new Intent(this, Inst_Reg.class);
        startActivity(intent);
    }
}