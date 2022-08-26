package si.uni_lj.fe.tnuv.wtot2_garden_f.finals;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

import si.uni_lj.fe.tnuv.wtot2_garden_f.InputPlantActivity;
import si.uni_lj.fe.tnuv.wtot2_garden_f.MainActivity;
import si.uni_lj.fe.tnuv.wtot2_garden_f.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    RecyclerView recyclerView;

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
        System.out.println("Pred calendar");

        Calendar calendar = Calendar.getInstance();
        System.out.println("Po calendar");

        Integer today = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("Po today");
        System.out.println("po po today");
        System.out.println("get last watering je "+ plant.getLast_watering());
        System.out.printf("Today je %s ,   getLast_watering() je %s", today, plant.getLast_watering());

        Integer int_last_watered = Integer.parseInt(plant.getLast_watering());
        System.out.println("Po int last watered");

        String str_last_watered = String.valueOf(today-int_last_watered);
        System.out.println("Po str last watered");

        holder.last_watered.setText(str_last_watered);
        System.out.println("Po holder last watered");

        holder.button_plant_id.setTag(position);

        holder.button_plant_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) holder.button_plant_id.getTag();
                FirebaseDatabase rootNode;
                DatabaseReference reference;
                String plant_name = list.get(position).getName();
                String plant_id = list.get(position).getId();
                ArrayList<Plant> duplicate_list = list;
                list.clear();
                System.out.println("water plant" +  plant_name +plant_id);
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Plants");
                reference.child(plant_name+plant_id).child("last_watering").setValue(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_YEAR)));
                list.addAll(duplicate_list);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, room, watering, last_watered;
        Button button_plant_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvPlantName);
            room = itemView.findViewById(R.id.tvPlantRoom);
            watering = itemView.findViewById(R.id.tvWatering);
            last_watered = itemView.findViewById(R.id.tvLastWatered);
            button_plant_id = itemView.findViewById(R.id.WaterIt);
        }
    }
}
