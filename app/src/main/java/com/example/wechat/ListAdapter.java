package com.example.wechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    List<People> list;
    private Context context;

    public ListAdapter(List<People> list, Context context) {
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
        convertView= LayoutInflater.from(context).inflate(R.layout.list_item,null);
        ImageView imageView=convertView.findViewById(R.id.imgs);
        TextView title=convertView.findViewById(R.id.t1);
        TextView content=convertView.findViewById(R.id.t2);
        imageView.setImageResource(list.get(position).getId());
        title.setText(list.get(position).getTitle());
        content.setText(list.get(position).getContent());
        return convertView;
    }
}
