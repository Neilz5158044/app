package com.example;

import java.util.ArrayList;

public class DbManage {
    static ArrayList<Goods> goodsArrayList =  new ArrayList<>();

    public static void insert(Goods goods, int num) {
        boolean contains = false;
        for (int i = 0; i < goodsArrayList.size(); i++) {
               if (goodsArrayList.get(i).id==goods.id){
                   contains = true;
                   goodsArrayList.get(i).count =    goodsArrayList.get(i).count+num;
                   break;
               }
        }
        if (!contains){
            goods.setCount(num);
            goodsArrayList.add(goods);
        }
    }
}
