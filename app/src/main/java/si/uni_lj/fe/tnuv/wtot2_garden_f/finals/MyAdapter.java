package si.uni_lj.fe.tnuv.wtot2_garden_f.finals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

import si.uni_lj.fe.tnuv.wtot2_garden_f.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Plant> list;

    public MyAdapter(Context context, ArrayList<Plant> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemplantf, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Plant plant = list.get(position);
        holder.name.setText(plant.getName());
        holder.room.setText(plant.getRoom());
        holder.watering.setText(plant.getWatering());

        Calendar calendar = Calendar.getInstance();
        Integer today = calendar.get(Calendar.DAY_OF_YEAR);
        Integer int_last_watered = Integer.parseInt(plant.getLast_watering());
        String str_last_watered = String.valueOf(today-int_last_watered);
        holder.last_watered.setText(str_last_watered);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, room, watering, last_watered;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvPlantName);
            room = itemView.findViewById(R.id.tvPlantRoom);
            watering = itemView.findViewById(R.id.tvWatering);
            last_watered = itemView.findViewById(R.id.tvLastWatered);
        }
    }
}
