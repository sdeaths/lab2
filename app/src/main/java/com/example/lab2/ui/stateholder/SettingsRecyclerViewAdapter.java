package com.example.lab2.ui.stateholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.data.database.entity.ProfileSettingListItem;

import java.util.List;

public class SettingsRecyclerViewAdapter extends RecyclerView.Adapter<SettingsRecyclerViewAdapter.SettingViewHolder> {

    private static final int TITLE = 100;
    private static final int NON_TITLE = 101;
    public OnSettingItemListClickListener onSettingItemListClickListener = null;
    private List<ProfileSettingListItem> items;

    public SettingsRecyclerViewAdapter(List<ProfileSettingListItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SettingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        View view;
        if (viewType == TITLE) {
            layout = R.layout.item_profile_header_list;
        } else if (viewType == NON_TITLE) {
            layout = R.layout.item_profile_setting_list;
        }
        view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);

        return new SettingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingViewHolder holder, int position) {
        ProfileSettingListItem item = items.get(position);
        holder.textView.setText(item.getSettingsTitle());
        holder.imageView.setImageResource(item.getSettingIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSettingItemListClickListener.onSettingItemListClickListener(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        ProfileSettingListItem item = items.get(position);
        if (item.isTitle()) {
            return TITLE;
        } else {
            return NON_TITLE;
        }
    }

    static class SettingViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public SettingViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.settingsTitle);
            imageView = itemView.findViewById(R.id.settingIcon);
        }
    }

    public interface OnSettingItemListClickListener {
        void onSettingItemListClickListener(int position);
    }
}
