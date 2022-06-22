package si.uni_lj.fe.tnuv.wtot2_garden_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

public class InputPlantActivity extends AppCompatActivity {
    Button callInputPlant;
    TextInputLayout name, room, watering;
    Button submitBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_plant);
        name = findViewById(R.id.name);
        room = findViewById(R.id.room);
        watering = findViewById(R.id.watering);
        submitBtn = findViewById(R.id.submitBtn);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Plants");

                String _name = name.getEditText().getText().toString();
                String _room = room.getEditText().getText().toString();
                String _watering = watering.getEditText().getText().toString();
                //Integer _watering =
                Calendar calendar = Calendar.getInstance();
                Integer dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
                String _last_watering = String.valueOf(dayOfYear);
                UserHelperClass helperClass = new UserHelperClass(_name, _room, _watering, _last_watering);

                reference.child(_name+ UUID.randomUUID().toString()).setValue(helperClass);
                Intent intent = new Intent(InputPlantActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}