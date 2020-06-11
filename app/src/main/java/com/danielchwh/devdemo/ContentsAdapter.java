package com.danielchwh.devdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContentsAdapter extends RecyclerView.Adapter<ContentsAdapter.ContentsViewHolder> {
    private List<ContentsItem> allItems;
    private Context context;

    public ContentsAdapter(Context context, List<ContentsItem> allItems) {
        this.context = context;
        this.allItems = allItems;
    }

    @NonNull
    @Override
    public ContentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.contents_item, parent, false);
        return new ContentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentsViewHolder holder, int position) {
        ContentsItem item = allItems.get(position);
        holder.itemName.setText(item.getItemName());
        holder.itemDescription.setText(item.getItemDescription());
    }

    @Override
    public int getItemCount() {
        return allItems.size();
    }

    static class ContentsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        public TextView itemName, itemDescription;
        private Context context;
        public ContentsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            this.context = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = null;
            if (position == 0) {
                intent = new Intent(context, LandscapeLayout.class);
            } else if (position == 1) {
                intent = new Intent(context, SaveState.class);
            } else if (position == 2) {
                intent = new Intent(context, SaveStateWithMVVM.class);
            } else if (position == 3) {
                intent = new Intent(context, SavePreferences.class);
            } else if (position == 4) {
                intent = new Intent(context, Timer.class);
            } else if (position == 5) {
                intent = new Intent(context, MainActivity.class);
            }
            context.startActivity(intent);
        }
    }
}
