package com.source.find.find.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.source.find.find.R;
import com.source.find.find.activity.CreateClubActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubFrament extends Fragment {

    private TextView mCreate;

    public ClubFrament() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club, container, false);

        mCreate = (TextView) view.findViewById(R.id.tv_club_title_create);
        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), CreateClubActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
