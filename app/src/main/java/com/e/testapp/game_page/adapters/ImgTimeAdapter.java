package com.e.testapp.game_page.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.testapp.R;
import com.e.testapp.utils.GameItem;

import java.util.List;

public class ImgTimeAdapter extends RecyclerView.Adapter<ImgTimeAdapter.ViewHolder> {

    public interface OnClickImgTimeAdapter {
        void itemOnClick(GameItem item, int position, View view);
    }
    private final OnClickImgTimeAdapter clickImgTimeAdapter;
    private final LayoutInflater inflater;
    private final List<GameItem> items;

    public ImgTimeAdapter(Context context, List<GameItem> items, OnClickImgTimeAdapter clickImgTimeAdapter) {
        this.clickImgTimeAdapter = clickImgTimeAdapter;
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ImgTimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.img_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImgTimeAdapter.ViewHolder holder, int position) {
        GameItem gameItem = items.get(position);
        holder.img.setImageResource(gameItem.getImg_resource());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickImgTimeAdapter.itemOnClick(gameItem, position, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_check);
        }
    }
}
