package id.azer.bookinghotel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import id.azer.bookinghotel.Model.LatestModel;
import id.azer.bookinghotel.R;

public class AllLatestAdapter extends RecyclerView.Adapter<AllLatestAdapter.MenuGrid> {
    private ArrayList<LatestModel> latestModels;
    private Context onClickListener;

    public AllLatestAdapter(ArrayList<LatestModel> latestModel,  Context onClickListener) {
        this.latestModels = latestModel;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public AllLatestAdapter.MenuGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AllLatestAdapter.MenuGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_all_lates, parent, false), onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AllLatestAdapter.MenuGrid holder, int position) {
        holder.sefDataMenu(latestModels.get(position));

    }

    @Override
    public int getItemCount() {
        if (latestModels != null) return latestModels.size();
        else return 0;
    }
    static class MenuGrid extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle,tvTitle2;
        private ImageView ivPhoto;
        private Context onClickListener;

        MenuGrid(@NonNull View itemView, Context onClickListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textView);
            tvTitle2 = itemView.findViewById(R.id.textView2);
            ivPhoto = itemView.findViewById(R.id.imageView);
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
            ivPhoto.setImageResource(latestModel.getImage());
            ivPhoto.setBackgroundResource(latestModel.getColor());
        }

        @Override
        public void onClick(View v) {
            onClickListener.getApplicationContext();
        }
    }

    public interface OnClickListener {
        void onMenuClickListener(int position);
    }
}
