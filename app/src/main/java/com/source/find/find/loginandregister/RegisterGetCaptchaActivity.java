package com.source.find.find.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.find.R;

public class RegisterGetCaptchaActivity extends AppCompatActivity {

    Button bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_get_captcha);

        bt_submit = (Button)findViewById(R.id.bt_submit);

        ClickListener clickListener = new ClickListener();

        bt_submit.setOnClickListener(clickListener);


    }

    private class ClickListener implements View.OnClickListener {
        public void onClick(View v) {
            if (v.getId() == R.id.bt_submit) {
                Intent intent = new Intent(RegisterGetCaptchaActivity.this, UserInfoActivity.class);
                startActivity(intent);
            }
        }
    }
}
