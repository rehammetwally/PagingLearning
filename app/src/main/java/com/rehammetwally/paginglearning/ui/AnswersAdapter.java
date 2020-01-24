package com.rehammetwally.paginglearning.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rehammetwally.paginglearning.R;
import com.rehammetwally.paginglearning.data.model.Item;

public class AnswersAdapter extends PagedListAdapter<Item, AnswersAdapter.AnswersViewHolder> {

    private Context context;

    protected AnswersAdapter(Context context) {
        super(diffCallback);
        this.context = context;
    }


    @NonNull
    @Override
    public AnswersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnswersViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnswersViewHolder holder, int position) {
        Item item = getItem(position);
        Glide.with(context).load(item.getOwner().getProfileImage()).into(holder.answer_image);
        holder.answer_name.setText(item.getOwner().getDisplayName());
    }

    private static DiffUtil.ItemCallback<Item> diffCallback = new DiffUtil.ItemCallback<Item>() {
        @Override
        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.getAnswerId() == newItem.getAnswerId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
            return oldItem.equals(newItem);
        }
    };

    public class AnswersViewHolder extends RecyclerView.ViewHolder {
        ImageView answer_image;
        TextView answer_name;

        public AnswersViewHolder(@NonNull View itemView) {
            super(itemView);
            answer_image = itemView.findViewById(R.id.answer_image);
            answer_name = itemView.findViewById(R.id.answer_name);
        }
    }
}
