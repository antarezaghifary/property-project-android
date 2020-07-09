package id.azer.bookinghotel.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.azer.bookinghotel.Model.FavoriteModel;
import id.azer.bookinghotel.R;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MenuGrid> {

    private ArrayList<FavoriteModel> favoriteModels;
    private FavoriteAdapter.OnClickListener onClickListener;

    public FavoriteAdapter(ArrayList<FavoriteModel> favoriteModels, OnClickListener onClickListener) {
        this.favoriteModels = favoriteModels;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public FavoriteAdapter.MenuGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoriteAdapter.MenuGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_favorite, parent, false), onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.MenuGrid holder, int position) {
        holder.sefDataMenu(favoriteModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (favoriteModels != null) return favoriteModels.size();
        else return 0;
    }
    static class MenuGrid extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle,tvTitle2;
        private ImageView ivPhoto;
        private FavoriteAdapter.OnClickListener onClickListener;

        MenuGrid(@NonNull View itemView, FavoriteAdapter.OnClickListener onClickListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textViewFav);
            tvTitle2 = itemView.findViewById(R.id.textView2Fav);
            ivPhoto = itemView.findViewById(R.id.imageViewFav);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        void sefDataMenu(FavoriteModel favoriteModel){
            tvTitle.setText(favoriteModel.getName());
            tvTitle2.setText(favoriteModel.getNama2());
            ivPhoto.setImageResource(favoriteModel.getImage());
            ivPhoto.setBackgroundResource(favoriteModel.getColor());
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
