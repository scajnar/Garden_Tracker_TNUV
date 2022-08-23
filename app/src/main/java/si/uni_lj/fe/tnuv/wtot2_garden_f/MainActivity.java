package si.uni_lj.fe.tnuv.wtot2_garden_f;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import si.uni_lj.fe.tnuv.wtot2_garden_f.finals.MyAdapter;
import si.uni_lj.fe.tnuv.wtot2_garden_f.finals.Plant;

// 28:50
public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<Plant> list;
    ArrayList<String> list_idjev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
        recyclerView = findViewById(R.id.plantList);
        database = FirebaseDatabase.getInstance().getReference("Plants");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        list_idjev = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Plant plant = dataSnapshot.getValue(Plant.class);
                    list.add(plant);
                    list_idjev.add(plant.getId());
                    System.out.println("Plant id je "+ plant.getId());
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Button callInputPlant;
        callInputPlant = findViewById(R.id.go_to_input_plant);
        callInputPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InputPlantActivity.class);
                startActivity(intent);
            }
        });

    }

}
