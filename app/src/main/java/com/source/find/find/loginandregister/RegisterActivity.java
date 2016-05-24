package com.source.find.find.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.source.find.find.R;

public class RegisterActivity extends AppCompatActivity {

    Button bt_getCaptcha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bt_getCaptcha = (Button)findViewById(R.id.bt_getCaptcha);

        ClickListener clickListener = new ClickListener();

        bt_getCaptcha.setOnClickListener(clickListener);
    }

    private class ClickListener implements View.OnClickListener {
        public void onClick(View v) {
            if (v.getId() == R.id.bt_getCaptcha) {
                Intent intent = new Intent(RegisterActivity.this, RegisterGetCaptchaActivity.class);
                startActivity(intent);
            }
        }
    }
}
