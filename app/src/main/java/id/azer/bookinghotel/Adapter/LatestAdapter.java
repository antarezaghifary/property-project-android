package id.azer.bookinghotel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import id.azer.bookinghotel.MainActivity;
import id.azer.bookinghotel.Model.LatestModel;
import id.azer.bookinghotel.R;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.MenuGrid> {

    private ArrayList<LatestModel> latestModels;
    private LatestAdapter.OnClickListener onClickListener;
    private Context context;

    public LatestAdapter(ArrayList<LatestModel> latestModel, LatestAdapter.OnClickListener onClickListener, Context context) {
        this.latestModels = latestModel;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public LatestAdapter.MenuGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LatestAdapter.MenuGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_latest, parent, false), onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LatestAdapter.MenuGrid holder, final int position) {
        final LatestModel model = latestModels.get(position);
        holder.sefDataMenu(latestModels.get(position));
        holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ini ","posisi : "+position);
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("tvTitle",model.getName());
                intent.putExtra("tvTitle2",model.getNama2());
                intent.putExtra("ivPhoto",model.getImage());
                //intent.putExtra("textView3",model.getNama3());
                intent.putExtra("detail", model.getNama3());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (latestModels != null) return latestModels.size();
        else return 0;
    }
    static class MenuGrid extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle,tvTitle2;
        private ImageView ivPhoto;
        private LatestAdapter.OnClickListener onClickListener;

        MenuGrid(@NonNull View itemView, LatestAdapter.OnClickListener onClickListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textView);
            tvTitle2 = itemView.findViewById(R.id.textView2);
            ivPhoto = itemView.findViewById(R.id.imageView);
            //textView3 = itemView.findViewById(R.id.detail);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        void sefDataMenu(LatestModel latestModel){
            tvTitle.setText(latestModel.getName());
            tvTitle2.setText(latestModel.getNama2());
            //textView3.setText(latestModel.getNama3());
            ivPhoto.setImageResource(latestModel.getImage());
            ivPhoto.setBackgroundResource(latestModel.getColor());
        }

        @Override
        public void onClick(View v) {
            onClickListener.onMenuClickListener(getAdapterPosition());
        }
    }

    public interface OnClickListener {
        void onMenuClickListener(int position);
    }
}
