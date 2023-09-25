package com.e.testapp.game_page.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.testapp.R;
import com.e.testapp.utils.GameItem;

import java.util.List;

public class NameTimeAdapter  extends RecyclerView.Adapter<NameTimeAdapter.ViewHolder> {
    public interface OnClickNameTimeAdapter {
        void itemOnClick(GameItem item, int position, View view);
    }
    private final OnClickNameTimeAdapter clickNameTimeAdapter;
    private final LayoutInflater inflater;
    private final List<GameItem> items;

    public NameTimeAdapter(Context context, List<GameItem> items, OnClickNameTimeAdapter clickNameTimeAdapter) {
        this.clickNameTimeAdapter = clickNameTimeAdapter;
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public NameTimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.name_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameTimeAdapter.ViewHolder holder, int position) {
        GameItem gameItem = items.get(position);
        holder.name.setText(gameItem.getCity_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNameTimeAdapter.itemOnClick(gameItem, position, view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.city_check);
        }
    }
}
