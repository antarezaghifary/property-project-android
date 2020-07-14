package id.azer.bookinghotel.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import id.azer.bookinghotel.DetailAllItemFavoriteFragment;
import id.azer.bookinghotel.DetailAllItemLatesFragment;
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
        holder.sefDataMenu(latestModels.get(position));
        holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ini ","posisi : "+position);
                Fragment newFragment = new DetailAllItemLatesFragment();
                FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_dash, newFragment);
                Bundle bundle = new Bundle();
                newFragment.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.commit();
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
            onClickListener.onMenuClickListener(getAdapterPosition());
        }
    }

    public interface OnClickListener {
        void onMenuClickListener(int position);
    }
}
