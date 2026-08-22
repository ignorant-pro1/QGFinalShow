package com.example.my_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class UnwelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_unwelcome);
        
        Button leaveButton = findViewById(R.id.btn_leave);
        if (leaveButton != null) {
            leaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(UnwelcomeActivity.this, "感谢您的离开！", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }
}