package id.azer.bookinghotel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import id.azer.bookinghotel.MainActivity;
import id.azer.bookinghotel.Model.FavoriteModel;
import id.azer.bookinghotel.R;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MenuGrid> {

    private ArrayList<FavoriteModel> favoriteModels;
    private FavoriteAdapter.OnClickListener onClickListener;
    private Context context;

    public FavoriteAdapter(ArrayList<FavoriteModel> favoriteModels, OnClickListener onClickListener, Context context) {
        this.favoriteModels = favoriteModels;
        this.onClickListener = onClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteAdapter.MenuGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoriteAdapter.MenuGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_favorite, parent, false), onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.MenuGrid holder, final int position) {
        final FavoriteModel model = favoriteModels.get(position);
        holder.sefDataMenu(favoriteModels.get(position));
        holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ini","posisi : "+position);
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("tvTitle",model.getName());
                intent.putExtra("tvTitle2",model.getNama2());
                intent.putExtra("ivPhoto",model.getImage());
                intent.putExtra("detail", model.getNama3());
                context.startActivity(intent);
            }
        });
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ini","posisi : "+position);
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("tvTitle",model.getName());
                intent.putExtra("tvTitle2",model.getNama2());
                intent.putExtra("ivPhoto",model.getImage());
                intent.putExtra("detail", model.getNama3());
                context.startActivity(intent);
            }
        });
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
        private LinearLayout linearLayout;

        MenuGrid(@NonNull View itemView, FavoriteAdapter.OnClickListener onClickListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textViewFav);
            tvTitle2 = itemView.findViewById(R.id.textView2Fav);
            ivPhoto = itemView.findViewById(R.id.imageViewFav);
            linearLayout = itemView.findViewById(R.id.linearFav);
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
