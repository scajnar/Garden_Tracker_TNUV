package si.uni_lj.fe.tnuv.wtot2_garden_f;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import si.uni_lj.fe.tnuv.wtot2_garden_f.adapters.PlantListaAdapter;
import si.uni_lj.fe.tnuv.wtot2_garden_f.model.PlantModel;
// 28:50
public class MainActivity extends AppCompatActivity implements PlantListaAdapter.PlantListClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Plant List");

        List<PlantModel> plantModelList = getPlantData();

        initRecyclerView(plantModelList);
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

    private void initRecyclerView(List<PlantModel> plantModelList){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PlantListaAdapter adapter = new PlantListaAdapter(plantModelList, this);
        recyclerView.setAdapter(adapter);
    }

    private List<PlantModel> getPlantData(){
        InputStream is = getResources().openRawResource(R.raw.plants);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try{
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while((n = reader.read(buffer))!=-1){
                writer.write(buffer, 0, n);
            }
        }catch(Exception e){

        }

        String jsonStr = writer.toString();
        Gson gson = new Gson();
        PlantModel[] plantModels = gson.fromJson(jsonStr, PlantModel[].class);
        List<PlantModel> restList = Arrays.asList(plantModels);

        return restList;
    }

    @Override
    public void onItemClick(PlantModel plantModel) {

    }
}