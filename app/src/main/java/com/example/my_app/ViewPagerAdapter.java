package com.example.my_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.my_app.reflection.ReflectionFragment;
import com.example.my_app.weather.WeatherFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    // 页面列表
    private final Fragment[] fragments = {
            //天气 学习计划 个人中心 可以参考倒数日
            new WeatherFragment(),
            new SkillPlanFragment(),
            new ReflectionFragment(),
            new ProfileFragment()
    };

    public ViewPagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;  // 返回页面数量
    }
}