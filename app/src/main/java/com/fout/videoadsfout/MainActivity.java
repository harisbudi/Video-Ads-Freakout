package com.fout.videoadsfout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.RecyclerView_bt)
    public void usingRecyclerview(){
        startActivity(new Intent(MainActivity.this, UsingRecyclerView.class));
    }
    @OnClick(R.id.ListView_bt)
    public void usingListview(){
        startActivity(new Intent(MainActivity.this, UsingListView.class));
    }

}
