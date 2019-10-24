package com.example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.OrderItemViewHolder> {


    private LayoutInflater mInflater;
    private List<Goods> mDatas;

    public CartAdapter(Context context, List<Goods> datas) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    @Override
    public OrderItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_car, parent, false);
        return new OrderItemViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(OrderItemViewHolder holder, int position) {

        Goods food = mDatas.get(position);
        holder.mIvImage.setImageResource(food.getPhoto());
        holder.mTvName.setText(food.getTitle());
        holder.mTvPrice.setText(food.getPrice() + "$");
        holder.mTvCount.setText("" + food.getCount());

    }

    class OrderItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIvImage;
        public TextView mTvName;
        public TextView mTvLabel;
        public TextView mTvPrice;
        public TextView mTvCount;
        public OrderItemViewHolder(View itemView) {
            super(itemView);
            mIvImage =  itemView.findViewById(R.id.id_iv_image);
            mTvName =  itemView.findViewById(R.id.id_tv_name);
            mTvLabel =  itemView.findViewById(R.id.id_tv_label);
            mTvPrice =  itemView.findViewById(R.id.id_tv_price);
            mTvCount =  itemView.findViewById(R.id.id_tv_count);


        }


    }

}
