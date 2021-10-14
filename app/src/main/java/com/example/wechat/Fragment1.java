package com.example.wechat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fragment1 extends Fragment {
    private ListAdapter listAdapter;
    private People [] peoples={new People(R.drawable.bg,"金克拉","我我我..."),new People(R.drawable.li,"李志明","我喜欢吃屎")
            ,new People(R.drawable.jie,"大顺","我跟楼上一样"),new People(R.drawable.w,"我","我叫马牛逼")
            ,new People(R.drawable.lu,"璐璐","我也叫马牛逼"),new People(R.drawable.pyy,"长沙彭于晏","天天处于战斗状态")};
    private SwipeRefreshLayout swip;
    private List<People> list=new ArrayList<>();
    private ListView listView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.fragment1,container,false);
        swip=view.findViewById(R.id.swip);
        swip.setColorSchemeResources(R.color.design_default_color_primary);
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        listView=view.findViewById(R.id.list);

                        listAdapter=new ListAdapter(list,getActivity());
                        init();

                        listAdapter.notifyDataSetChanged();
                        swip.setRefreshing(false);
                        listView.setAdapter(listAdapter);
                    }
                }).start();
            }
        });

        return view;
    }

    private void refresh() {

    }

    private void init() {
        list.clear();
        for (int i=0;i<50;i++){
            Random random=new Random();
            int index=random.nextInt(peoples.length);
            list.add(peoples[index]);
        }
    }
}
