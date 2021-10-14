package com.example.wechat;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton popu;
    private PopupWindow popupWindow;
    private RadioButton b1,b2,b3,b4;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniViwe();
        hideAction();
        //  微信主界面
        replaceFragment(new Fragment1());
    }

    private void iniViwe() {
        popu=findViewById(R.id.popu);
        popu.setOnClickListener(this);
        b1=findViewById(R.id.wehcat);
        b2=findViewById(R.id.mail);
        b3=findViewById(R.id.find);
        b4=findViewById(R.id.myself);
        relativeLayout=findViewById(R.id.re);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    private void hideAction() {
        //  隐藏菜单 并重新自定义新的菜单
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.popu:
                View popuView= getLayoutInflater().inflate(R.layout.populayout,null,false);
                 popupWindow=new PopupWindow(popuView,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAsDropDown(findViewById(R.id.popu),0,0);
                popuView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (popupWindow!=null&&popupWindow.isShowing()){
                            popupWindow.dismiss();
                            popupWindow=null;
                        }
                        return false;
                    }
                });
                break ;
            case R.id.wehcat:
                replaceFragment(new Fragment1());
                relativeLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.mail:
                relativeLayout.setVisibility(View.VISIBLE);
                replaceFragment(new Fragment2());
                break;
            case R.id.find:
                relativeLayout.setVisibility(View.GONE);
                replaceFragment(new Fragment3());
                break;
            case R.id.myself:
                relativeLayout.setVisibility(View.GONE);
                replaceFragment(new Fragment4());
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
        transaction.addToBackStack(null);
    }
}