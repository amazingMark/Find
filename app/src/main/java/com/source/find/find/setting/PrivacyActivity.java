package com.source.find.find.setting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.find.R;

import MyView.Switch;

public class PrivacyActivity extends AppCompatActivity {

    Switch sw_phone;
    boolean isopen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        sw_phone = (Switch)findViewById(R.id.sw_phone);
        sw_phone.setState(true);

        SwitchOnStateChangedListener switchlistener = new SwitchOnStateChangedListener();
        sw_phone.setOnStateChangedListener(switchlistener);
    }

    private class SwitchOnStateChangedListener implements Switch.OnStateChangedListener {
        @Override public void toggleToOn() {
            sw_phone.open();
            isopen = true;
            Toast.makeText(PrivacyActivity.this, "open", Toast.LENGTH_SHORT).show();
        }

        @Override public void toggleToOff() {
            Toast.makeText(PrivacyActivity.this, "close", Toast.LENGTH_SHORT).show();
            sw_phone.close();
            isopen = false;
        }
    }
}
