package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.security.Permission;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar idProgressBar;
    private RelativeLayout idHome;
    private TextView idTvCityName, idTvTemperature, condition;
    private TextInputLayout idTLCity;
    private ImageView idIVSearch, idIVWeatherIcon;
    private RecyclerView idTodayWeatherRV;
    private ArrayList<RecycleViewWeatherModel> weatherModelsArraylist;
    private RecycleViewWeatherAdapter weatherAdapter;
    public Context context;
    public static final int PERMISSION_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);



        idProgressBar = findViewById(R.id.idProgressBar);
        idHome = findViewById(R.id.idHome);
        idTvTemperature = findViewById(R.id.idTvTemperature);
        idTvCityName = findViewById(R.id.idTvCityName);
        condition = findViewById(R.id.condition);
        idTLCity= findViewById(R.id. idTLCity);
        idIVSearch = findViewById(R.id.idIVSearch);
        idIVWeatherIcon = findViewById(R.id.idIVWeatherIcon);
        idTodayWeatherRV = findViewById(R.id.idTodayWeatherRV);
        context = this.context;

        weatherModelsArraylist = new ArrayList<>();
        weatherAdapter = new RecycleViewWeatherAdapter(context,weatherModelsArraylist);
        idTodayWeatherRV.setAdapter(weatherAdapter);
        someMethod(context);

        if(ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_CODE);

        }








    }

    public void someMethod(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    private Window getWindow() {
        Window window = getWindow();
        return window;
    }

    private void getWeatherInfo(String cityName){
        String url = "http://api.weatherapi.com/v1/forecast.json?key=24f9fbb588444f18a63121102241810&q="+cityName+"&days=1&aqi=no&alerts=no";

    }

}