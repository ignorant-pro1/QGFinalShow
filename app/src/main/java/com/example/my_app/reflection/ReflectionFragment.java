package com.example.my_app.reflection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_app.R;

import java.util.ArrayList;
import java.util.List;

public class ReflectionFragment extends Fragment {
    private RecyclerView recyclerView;
    private ReflectionAdapter adapter;
    private List<ListFormwork> dataList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.activity_reflection,container,false);
        recyclerView = view.findViewById(R.id.rv_reflection);
        //布局管理器 确认竖向滚动
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        dataList.add(new ListFormwork("学习 ConstraintLayout", "2026-04-12"));
        adapter = new ReflectionAdapter(dataList, new ReflectionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListFormwork item) {
                Toast.makeText(getContext(), "点击了: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(ListFormwork item) {
                Toast.makeText(getContext(), "长按了: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }
}
