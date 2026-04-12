package com.example.my_app.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.my_app.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import okhttp3.Callback;

public class WeatherFragment extends Fragment{

    private TextView tvweather;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.activity_weather,container,false);
        tvweather = view.findViewById(R.id.weather);
        fetchWeather();
        return view;
    }

    private void  fetchWeather(){
        OkHttpClient client = new OkHttpClient();
        String url = "http://v1.yiketianqi.com/free/day?appid=32936235&appsecret=uw3ttF1h&city=广州&unescape=1";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        //异步执行，防止主线程堵塞
        //主线程就是UI线程就是直接看到的那个过程，防止它卡住死机
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {//@NonNull表示“这个值不可能为空”
                e.printStackTrace();//打印错误信息
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> {
                        tvweather.setText("网络请求失败：" + e.getMessage());
                        Log.e("WeatherFragment", "异常堆栈: ", e);
                    });
                }
            }
            //获得数据
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String jsonData = response.body().string();
                    Log.d("WeatherFragment", "返回的JSON: " + jsonData);
                    if (getActivity() != null) {
                        getActivity().runOnUiThread(() -> {
                            Gson gson = new Gson();
                            WeatherResponse weatherResponse = gson.fromJson(jsonData,WeatherResponse.class);
                            String city = weatherResponse.getCity();
                            String date = weatherResponse.getDate();
                            String tem = weatherResponse.getTem();
                            String wea = weatherResponse.getWea();
                            TextView cityView = getView().findViewById(R.id.city);
                            TextView temView = getView().findViewById(R.id.temperature);
                            TextView weaView = getView().findViewById(R.id.weather);
                            TextView dateView = getView().findViewById(R.id.date);
                            cityView.setText(city);
                            temView.setText(tem + "℃");
                            weaView.setText(wea);
                            dateView.setText(date);

                        });
                    }
                }
            }
        });
    }
}
