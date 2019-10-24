package com.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CartActivity extends AppCompatActivity {
    private List<Goods> mDatas = new ArrayList<>();
    private CartAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private TextView mTvCount;
    private int mTotalPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carlist);
        initView();
        init();
    }
    private void initView() {
        findViewById(R.id.iv_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRecyclerView =  findViewById(R.id.id_recyclerview);
        mTvCount =  findViewById(R.id.id_tv_count);
        mAdapter = new CartAdapter(this, mDatas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);


    }


    public void init() {
        mDatas.clear();
        List<Goods> list = DbManage.goodsArrayList;
        mDatas.addAll(list);
        mAdapter.notifyDataSetChanged();
        mTotalPrice = 0;
        for (Goods food:mDatas){
            mTotalPrice += food.getCount() * Integer.parseInt(food.getPrice());
        }
        mTvCount.setText("Total：$" + mTotalPrice);
        mAdapter.notifyDataSetChanged();
    }



}
