package com.example.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private UsersDao usersDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        usersDao = new UsersDao(this);
        Button TurnToRegister = (Button) findViewById(R.id.turn_to_register);
        Button TurnToLogin = (Button) findViewById(R.id.turn_to_login);
        Button Register = (Button) findViewById(R.id.register);
        TurnToLogin.setOnClickListener(this);
        TurnToRegister.setOnClickListener(this);
        Register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        //效率比较低，但是switch case后面不能用R.id.XXX,后续根据运行情况观察是否有解决方法
        EditText usernameInput = findViewById(R.id.username_input);
        EditText passwordInput = findViewById(R.id.password_input);
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        if (v.getId() == R.id.register){
            //后续要加用户名和密码的校对，不同情况下的不同Toast，忘记密码功能。
            //明天再完善
            boolean success = usersDao.register(username,password);
            if (success){
                Toast.makeText(RegisterActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(RegisterActivity.this,"登录失败！",Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.login) {
            boolean success = usersDao.login(username,password);
            if (success){
                Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(RegisterActivity.this,"用户名已存在！",Toast.LENGTH_SHORT).show();
            }
            //后续可以考虑加自动跳转回登录页面，以及注册的相关要求。
        } else if (v.getId() == R.id.turn_to_register) {
            finish();
        } else if (v.getId() == R.id.turn_to_login){
            Intent intent = new Intent(RegisterActivity .this,LoginActivity.class);
            startActivity(intent);
        }
    }
}