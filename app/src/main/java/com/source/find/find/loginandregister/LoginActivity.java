package com.source.find.find.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.source.find.find.R;


public class LoginActivity extends AppCompatActivity {

    Button bt_submit;
    TextView tv_register;
    TextView tv_findpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_submit = (Button)findViewById(R.id.bt_submit);
        tv_register = (TextView)findViewById(R.id.tv_register);
        tv_findpwd = (TextView)findViewById(R.id.tv_findpwd);

        ClickListener clickListener = new ClickListener();

        bt_submit.setOnClickListener(clickListener);
        tv_register.setOnClickListener(clickListener);
        tv_findpwd.setOnClickListener(clickListener);
    }

    private class ClickListener implements View.OnClickListener {
        public void onClick(View v) {
            if (v.getId() == R.id.bt_submit) {
//                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
//                startActivity(intent);
            }else if(v.getId() == R.id.tv_register){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.tv_findpwd){
                Intent intent = new Intent(LoginActivity.this, FindPasswordActivity.class);
                startActivity(intent);
            }
        }
    }
}
