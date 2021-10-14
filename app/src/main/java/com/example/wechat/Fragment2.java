package com.example.wechat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {
    private List<ManKind> list;
    private ListView listView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment2,container,false);
        listView=view.findViewById(R.id.list_item);
        list=new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add(new ManKind(R.drawable.w,"彭佳亮(已黑化)"));
            list.add(new ManKind(R.drawable.lu,"璐璐(已黑化)"));
            list.add(new ManKind(R.drawable.jie,"大顺(已黑化)"));
            list.add(new ManKind(R.drawable.pyy,"长沙彭于晏(已黑化)"));

        }
        listView.setAdapter(new ManKindAdapter(list,getActivity()));
        return view;
    }
}
