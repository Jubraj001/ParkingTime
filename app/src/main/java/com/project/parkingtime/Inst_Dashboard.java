package com.project.parkingtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Inst_Dashboard extends AppCompatActivity {

    private FirebaseUser Inst_user;
    private DatabaseReference reference;
    private String InstID;
    private TextView disp_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst_dashboard);

        Inst_user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Institution");
        InstID = Inst_user.getUid();
        final TextView disp_name = (TextView) findViewById(R.id.dispInstName);
        reference.child(InstID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Inst_Data Inst_profile =snapshot.getValue(Inst_Data.class);
                if(Inst_profile != null){
                    String name = Inst_profile.name;
                    disp_name.setText(name+" Dashboard");

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Inst_Dashboard.this, "Something went wrong!", Toast.LENGTH_LONG).show();
            }
        });
    }


}