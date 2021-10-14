package com.example.wechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ManKindAdapter extends BaseAdapter {
    List<ManKind> list;
    private Context context;

    public ManKindAdapter(List<ManKind> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.list_itmes,null);
        ImageView img=convertView.findViewById(R.id.img);
        TextView textView=convertView.findViewById(R.id.text1);
        img.setImageResource(list.get(position).getId());
        textView.setText(list.get(position).getName());
        return convertView;
    }
}
