package com.example.weatherapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecycleViewWeatherAdapter extends RecyclerView.Adapter<RecycleViewWeatherAdapter.Viewholder> {

    private Context context;
    private ArrayList<RecycleViewWeatherModel> weatherModelsArrayList;

    public RecycleViewWeatherAdapter(Context context, ArrayList<RecycleViewWeatherModel> weatherModelsArrayList) {
        this.context = context;
        this.weatherModelsArrayList = weatherModelsArrayList;
    }

    @Override
    public RecycleViewWeatherAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_items,parent,false);
        return  new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewWeatherAdapter.Viewholder holder, int position) {

        RecycleViewWeatherModel model = weatherModelsArrayList.get(position);
        holder.idTvDspTemperature.setText(model.getTemperature()+"°C");
        Picasso.get().load("http:".concat(model.getIcon())).into(holder.IVDsplCondition);
        holder.idTVWindSpeed.setText(model.getWindSpeed()+"km/h");
        SimpleDateFormat formatinput = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat formatoutput = new SimpleDateFormat("hh:mm aa");

        try{
            Date date = formatinput.parse(model.getTime());
            holder.idTvTime.setText(formatoutput.format(date));
        }catch (ParseException e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return weatherModelsArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView idTvTime,idTvDspTemperature,idTVWindSpeed;
        private ImageView IVDsplCondition;
        public Viewholder(View itemView) {
            super(itemView);

            idTvTime = itemView.findViewById(R.id.idTvTime);
            idTvDspTemperature = itemView.findViewById(R.id.idTvDspTemperature);
            idTVWindSpeed = itemView.findViewById(R.id.idTVWindSpeed);
            IVDsplCondition = itemView.findViewById(R.id.IVDsplCondition);
        }
    }
}
