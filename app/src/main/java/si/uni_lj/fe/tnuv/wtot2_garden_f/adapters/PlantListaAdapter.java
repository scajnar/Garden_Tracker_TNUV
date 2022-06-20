package si.uni_lj.fe.tnuv.wtot2_garden_f.adapters;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import si.uni_lj.fe.tnuv.wtot2_garden_f.R;
import si.uni_lj.fe.tnuv.wtot2_garden_f.model.PlantModel;


public class PlantListaAdapter extends RecyclerView.Adapter<PlantListaAdapter.MyViewHolder> {
    private List<PlantModel> plantModelList;
    private PlantListClickListener clickListener;

    public PlantListaAdapter(List<PlantModel> plantModelList, PlantListClickListener clickListener ){
        this.plantModelList = plantModelList;
        this.clickListener = clickListener;
    }

    public void updateData(List<PlantModel> plantModelList){
        this.plantModelList = plantModelList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PlantListaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantListaAdapter.MyViewHolder holder, int position) {
        holder.plantName.setText(plantModelList.get(position).getName());
        holder.plantAddress.setText("Plant address" +plantModelList.get(position).getAddress());
        holder.plantHours.setText("Today's hours" + plantModelList.get(position).getHours().getTodayHours());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clickListener.onItemClick(plantModelList.get(position));
            }
        });
        Glide.with(holder.thumbImage).load(plantModelList.get(position).getImage())
                .into(holder.thumbImage);
    }

    @Override
    public int getItemCount() {
        return plantModelList.size();
    }

    static class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView plantName;
        TextView plantAddress;
        TextView plantHours;
        ImageView thumbImage;


        public MyViewHolder(View view){
            super(view);
            plantName = view.findViewById(R.id.plantName);
            plantAddress = view.findViewById(R.id.plantAddress);
            plantHours = view.findViewById(R.id.plantHours);
            thumbImage = view.findViewById(R.id.thumbImage);
        }
    }

    public interface PlantListClickListener{
        public void onItemClick(PlantModel plantModel);
    }
}
