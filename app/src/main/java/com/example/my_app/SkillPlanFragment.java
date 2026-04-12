package com.example.my_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SkillPlanFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.activity_skill_plan,container,false);
//        TextView textView = view.findViewById(R.id.text_view);
//        textView.setText("这是技能规划页面");
        return view;
    }
}
