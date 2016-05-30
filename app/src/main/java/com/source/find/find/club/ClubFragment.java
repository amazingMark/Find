package com.source.find.find.club;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.source.find.find.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClubFragment extends ListFragment {

    private TextView mCreate;
    private ListView mClubList;
    private List<Map<String, Object>> clubList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    public ClubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club, container, false);

        mCreate = (TextView) view.findViewById(R.id.tv_club_title_create);
        mClubList = (ListView) view.findViewById(R.id.lv_club_list);
        mLayoutInflater = LayoutInflater.from(getContext());
        //填充社团列表listview
        Adapter adapter = new SimpleAdapter(getContext(),
                getData(),
                R.layout.item_clubs,
                new String[]{"icon", "name"},
                new int[]{R.id.iv_item_clubs_icon, R.id.tv_item_clubs_name});

        mClubList.setAdapter(new ClubListAdapter());

        mCreate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), CreateClubActivity.class);
                startActivity(intent);
            }
        });

        mClubList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return view;
    }

    public List<Map<String, Object>> getData() {


        Map<String, Object> map = new HashMap<>();

        map.put("icon", R.mipmap.chat_group_icon);
        map.put("name", "武汉大学印刷摄影协会");
        clubList.add(map);

        map = new HashMap<>();
        map.put("icon", R.mipmap.chat_group_icon);
        map.put("name", "武汉大学印刷摄影协会");
        clubList.add(map);

        return clubList;
    }


    class ClubListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return getData().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = mLayoutInflater.inflate(R.layout.item_clubs,null);

            ImageView clubIcon = (ImageView) view.findViewById(R.id.iv_item_clubs_icon);
            TextView clubName = (TextView) view.findViewById(R.id.tv_item_clubs_name);

            clubIcon.setImageResource(Integer.parseInt(getData().get(position).get("icon").toString()));
            clubName.setText(getData().get(position).get("name").toString());

            return view;
        }
    }

}

