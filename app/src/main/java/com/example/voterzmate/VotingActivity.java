package com.example.voterzmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class VotingActivity extends AppCompatActivity {
    Button v1,v2,v3,v4;
    private FirebaseAuth mAuth;
    private FirebaseFirestore Fstore;
    private String userID;
    public static int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
        v4 = findViewById(R.id.v4);
        mAuth = FirebaseAuth.getInstance();
        Fstore = FirebaseFirestore.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                if (count == 1)
                {
                    count = 0;
                    Fstore.collection("users").document(userID).update("voterCount", "A");

                }
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                if (count == 1)
                {
                    count = 0;
                    Fstore.collection("users").document(userID).update("voterCount", "B");
                }
            }
        });

        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                if (count == 1)
                {
                    count = 0;
                    Fstore.collection("users").document(userID).update("voterCount", "C");
                }
            }
        });

        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                if (count == 1)
                {
                    count = 0;
                    Fstore.collection("users").document(userID).update("voterCount", "D");
                }
            }
        });
    }
    public void openDialog()
    {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(),"voting_dialog");
    }
}