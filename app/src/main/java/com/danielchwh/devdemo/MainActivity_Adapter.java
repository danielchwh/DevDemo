package com.danielchwh.devdemo;

import android.content.ContentValues;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MainActivity_Item> allItems;
    private static final int NORMAL_VIEW_TYPE = 0;
    private static final int FOOTER_VIEW_TYPE = 1;

    public MainActivity_Adapter(List<MainActivity_Item> allItems) {
        this.allItems = allItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == NORMAL_VIEW_TYPE) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View itemView = layoutInflater.inflate(R.layout.activity_main_item, parent, false);
            return new ContentsViewHolder(itemView);
        } else {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View itemView = layoutInflater.inflate(R.layout.footer_main, parent, false);
            return new FooterViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ContentsViewHolder) {
            ContentsViewHolder cHolder = (ContentsViewHolder) holder;
            // Get item from list and display its content in textView
            MainActivity_Item item = allItems.get(position);
            cHolder.itemName.setText(item.getItemName());
            cHolder.itemDescription.setText(item.getItemDescription());
            cHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Set up button click event
                    Intent intent = new Intent();
                    intent.setClassName(cHolder.itemView.getContext(), item.getClassFullName());
                    cHolder.itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1)
            return FOOTER_VIEW_TYPE;
        else
            return NORMAL_VIEW_TYPE;
    }

    @Override
    public int getItemCount() {
        return allItems.size() + 1;
    }

    static class ContentsViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName, itemDescription;

        public ContentsViewHolder(@NonNull View itemView) {
            super(itemView);
            // Get view and context
            itemName = itemView.findViewById(R.id.textView1_Main);
            itemDescription = itemView.findViewById(R.id.textView2_Main);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
