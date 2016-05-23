package com.source.find.find.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.source.find.find.R;
import com.source.find.find.club.ClubFrament;

public class ChatGroupActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.ib_chat_group_title_pre:
                intent.setClass(ChatGroupActivity.this, ClubFrament.class);
                break;
            case R.id.ib_chatgroup_title_detail:
                intent.setClass(ChatGroupActivity.this,DefaultChatGroupDetailActivity.class);
                break;
        }
        startActivity(intent);
    }
}
