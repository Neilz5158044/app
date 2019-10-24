package com.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GoodsDetailActivity extends AppCompatActivity {
    private ImageView ivImg;
    private TextView tvTitle;
    private TextView tvDes;
    private TextView tvPrice;
    private ImageView mIvAdd;
    private ImageView mIvSub;
    private TextView tvCount;
    private Button btAdd;
    private Goods goods;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodsdetail);
        initView();
        goods = (Goods) getIntent().getSerializableExtra("goods");
        goods.setCount(1);
        ivImg.setImageResource(goods.getPhoto());
        tvTitle.setText(goods.getTitle());
        tvDes.setText(goods.getIntroduce());
        tvPrice.setText(goods.getPrice());

    }

    private void initView() {
        ivImg = findViewById(R.id.iv_img);
        findViewById(R.id.iv_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitle = findViewById(R.id.id_tv_name);
        tvPrice = findViewById(R.id.id_tv_price);
        tvDes = findViewById(R.id.id_tv_label);
        tvCount = findViewById(R.id.id_tv_count);
        btAdd = findViewById(R.id.id_btn_pay);
        mIvAdd =  findViewById(R.id.id_iv_add);
        mIvSub =  findViewById(R.id.id_iv_sub);
        mIvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String count = tvCount.getText().toString();
                tvCount.setText((Integer.parseInt(count)+1)+"");
                goods.setCount(Integer.parseInt(count)+1);
            }
        });
        mIvSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = tvCount.getText().toString();
                int num = Integer.parseInt(count);
                if (num>1){
                    tvCount.setText((num-1)+"");
                    goods.setCount(num-1);
                }
            }
        });
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = tvCount.getText().toString();
                int num = Integer.parseInt(count);
                DbManage.insert( goods,num);
                Toast.makeText(GoodsDetailActivity.this,"Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
