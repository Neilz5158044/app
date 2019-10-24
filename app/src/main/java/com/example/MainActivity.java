package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private GoodsAdapter goodsAdapter;
    private List<Goods> contentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        initView();
        loadData();
    }
    private void initView( ) {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        goodsAdapter = new GoodsAdapter(this, contentList);
        recyclerView.setAdapter(goodsAdapter);

        goodsAdapter.setOnItemClickListener(new GoodsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Goods goods, int position) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, GoodsDetailActivity.class);
                intent.putExtra("goods",goods);
                startActivity(intent);
            }
        });
    }
    private void loadData() {


        contentList.add(new Goods(1,"Apple","An apple is a sweet, edible fruit produced by an apple tree.", "3" , R.drawable.apple));
        contentList.add(new Goods(2,"Banana","A banana is an edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa.", "4" , R.drawable.banana));
        contentList.add(new Goods(3,"Orange","The orange is the fruit of the citrus species Citrus × sinensis in the family Rutaceae", "3" , R.drawable.orange));
        contentList.add(new Goods(4,"Peach","The peach (Prunus persica) is a deciduous tree native to the region of Northwest China between the Tarim Basin and the north slopes of the Kunlun Mountains.", "6" , R.drawable.peach));
        contentList.add(new Goods(5,"Beef","Beef is the culinary name for meat from cattle, particularly skeletal muscle.", "15" , R.drawable.beef));
        contentList.add(new Goods(6,"Lamb","Lamb, hogget and mutton are the meat of domestic sheep.", "18" , R.drawable.lamb));
        contentList.add(new Goods(7,"Pork","Pork is the culinary name for the flesh of a domestic pig.", "23" , R.drawable.pork));
        contentList.add(new Goods(8,"Rice","Rice is the seed of the grass species Oryza sativa (Asian rice) or Oryza glaberrima (African rice).", "1" , R.drawable.rice));
        contentList.add(new Goods(9,"Blueberry","Blueberries are perennial flowering plants with blue– or purple–colored berries.", "4" , R.drawable.blueberry));
        contentList.add(new Goods(10,"Pitaya","A pitaya or pitahaya the fruit of several different cactus species indigenous to the Americas.", "7" , R.drawable.pitaya));
        contentList.add(new Goods(11,"Lettuce","It is most often grown as a leaf vegetable, but sometimes for its stem and seeds.", "3" , R.drawable.lettuce));
        contentList.add(new Goods(12,"Tomato","Tomato, (Solanum lycopersicum), flowering plant of the nightshade family (Solanaceae), cultivated extensively for its edible fruits. ", "5" , R.drawable.tomato));
        contentList.add(new Goods(13,"Potato","The potato is a root vegetable, a starchy tuber of the plant Solanum tuberosum, and the plant itself, a perennial in the family Solanaceae.", "4" , R.drawable.potato));
        contentList.add(new Goods(14,"Fish","Fish are gill-bearing aquatic craniate animals that lack limbs with digits. ", "18" , R.drawable.fish));
        contentList.add(new Goods(15,"Milk","Milk is a nutrient-rich, white liquid food produced by the mammary glands of mammals.", "4" , R.drawable.milk));

        goodsAdapter.notifyDataSetChanged();
    }

    public void viewCar(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, CartActivity.class);
        startActivity(intent);
    }
}
