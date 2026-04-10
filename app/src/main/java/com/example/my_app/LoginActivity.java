package com.example.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private UsersDao usersDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        usersDao = new UsersDao(this);
        Button TurnToRegister = (Button) findViewById(R.id.turn_to_register);
        Button login = (Button) findViewById(R.id.login);
        TurnToRegister.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        EditText usernameInput = findViewById(R.id.username_input);
        EditText passwordInput = findViewById(R.id.password_input);
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        if (v.getId() == R.id.login) {
            Log.d("click","get username and password");
            boolean success = usersDao.login(username,password);
            if (success){
                Toast.makeText(LoginActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(LoginActivity.this,"用户名已存在！",Toast.LENGTH_SHORT).show();
            }
            //后续可以考虑加自动跳转回登录页面，以及注册的相关要求。
        } else if (v.getId() == R.id.turn_to_register) {
            finish();
        }
    }
}