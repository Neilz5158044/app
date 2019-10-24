package com.example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.OrderItemViewHolder> {


    private Context mContext;
    private LayoutInflater mInflater;
    private List<Goods> mDatas;

    public GoodsAdapter(Context context, List<Goods> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    @Override
    public OrderItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_item, parent, false);
        return new OrderItemViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(OrderItemViewHolder holder, final int position) {
        final Goods food = mDatas.get(position);

        holder.mIvImage.setImageResource(food.getPhoto());
        holder.mTvName.setText(food.getTitle());
        holder.mTvPrice.setText(food.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener!=null){
                    mItemClickListener.onItemClick(food,position);
                }
            }
        });
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
        }


    }
    public interface OnItemClickListener {
        void  onItemClick(Goods food, int position);
    }
    OnItemClickListener mItemClickListener;
    public  void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }
}
