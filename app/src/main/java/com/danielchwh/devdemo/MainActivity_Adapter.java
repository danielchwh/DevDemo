package com.danielchwh.devdemo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity_Adapter extends RecyclerView.Adapter<MainActivity_Adapter.ContentsViewHolder> {
    private List<MainActivity_Item> allItems;

    public MainActivity_Adapter(List<MainActivity_Item> allItems) {
        this.allItems = allItems;
    }

    @NonNull
    @Override
    public ContentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.activity_main_item, parent, false);
        return new ContentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContentsViewHolder holder, final int position) {
        // Get item from list and diaplay its content in textView
        MainActivity_Item item = allItems.get(position);
        holder.itemName.setText(item.getItemName());
        holder.itemDescription.setText(item.getItemDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set up button click event
                Intent intent = null;
                if (position == 0) {
                    intent = new Intent(holder.itemView.getContext(), LandscapeLayout.class);
                } else if (position == 1) {
                    intent = new Intent(holder.itemView.getContext(), SaveState.class);
                } else if (position == 2) {
                    intent = new Intent(holder.itemView.getContext(), SaveStateWithMVVM.class);
                } else if (position == 3) {
                    intent = new Intent(holder.itemView.getContext(), SavePreferences.class);
                } else if (position == 4) {
                    intent = new Intent(holder.itemView.getContext(), Timer.class);
                } else if (position == 5) {
                    intent = new Intent(holder.itemView.getContext(), RoomDatabase.class);
                } else if (position == 6) {
                    intent = new Intent(holder.itemView.getContext(), NavigationDemo.class);
                } else if (position == 7) {
                    intent = new Intent(holder.itemView.getContext(), ActionBar.class);
                } else {
                    return;
                }
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allItems.size();
    }

    static class ContentsViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName, itemDescription;

        public ContentsViewHolder(@NonNull View itemView) {
            super(itemView);
            // Get view and context
            itemName = itemView.findViewById(R.id.itemName);
            itemDescription = itemView.findViewById(R.id.itemDescription);
        }
    }
}
