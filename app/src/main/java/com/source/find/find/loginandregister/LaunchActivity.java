package com.source.find.find.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.find.R;

public class LaunchActivity extends AppCompatActivity {

    Button bt_login;
    Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_login = (Button)findViewById(R.id.bt_login);
        bt_register = (Button)findViewById(R.id.bt_register);

        ClickListener clickListener = new ClickListener();

        bt_login.setOnClickListener(clickListener);
        bt_register.setOnClickListener(clickListener);
    }

    private class ClickListener implements View.OnClickListener {
        public void onClick(View v) {
            if (v.getId() == R.id.bt_login) {
                Intent intent = new Intent(LaunchActivity.this, LoginActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.bt_register){
                Intent intent = new Intent(LaunchActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        }
    }
}
