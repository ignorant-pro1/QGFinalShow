package com.example.my_app.reflection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.my_app.R;
import java.util.List;

public class ReflectionAdapter extends RecyclerView.Adapter<ReflectionAdapter.ViewHolder> {

    private List<ListFormwork> dataList;
    private OnItemClickListener listener;

    // 点击事件接口
    public interface OnItemClickListener {
        void onItemClick(ListFormwork item);
        void onItemLongClick(ListFormwork item);
    }

    public ReflectionAdapter(List<ListFormwork> dataList, OnItemClickListener listener) {
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reflection_formwork, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListFormwork item = dataList.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.tvDate.setText(item.getrDate());
        holder.cbComplete.setChecked(item.isCompleted());

        // 点击
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item);
            }
        });

        // 长按
        holder.itemView.setOnLongClickListener(v -> {
            if (listener != null) {
                listener.onItemLongClick(item);
            }
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    // ✅ ViewHolder 内部类
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate;
        CheckBox cbComplete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            cbComplete = itemView.findViewById(R.id.cb_complete);
        }
    }
}