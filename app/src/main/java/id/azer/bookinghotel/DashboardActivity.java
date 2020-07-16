package id.azer.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.azer.bookinghotel.Adapter.FavoriteAdapter;
import id.azer.bookinghotel.Adapter.LatestAdapter;
import id.azer.bookinghotel.Adapter.MenuAdapter;
import id.azer.bookinghotel.Data.FavoriteData;
import id.azer.bookinghotel.Data.LatestData;
import id.azer.bookinghotel.Data.MenuData;
import id.azer.bookinghotel.Model.FavoriteModel;
import id.azer.bookinghotel.Model.LatestModel;
import id.azer.bookinghotel.Model.MenuModel;

public class DashboardActivity extends AppCompatActivity implements MenuAdapter.OnClickListener, LatestAdapter.OnClickListener, FavoriteAdapter.OnClickListener{

    private ArrayList<MenuModel> menuModels = new ArrayList<>();
    MenuAdapter menuAdapter;
    RecyclerView recyclerView;

    private ArrayList<LatestModel> latestModels = new ArrayList<>();
    LatestAdapter latestAdapter;
    RecyclerView rvLates;

    private ArrayList<FavoriteModel> favoriteModels = new ArrayList<>();
    FavoriteAdapter favoriteAdapter;
    RecyclerView rvFovorite;

    TextView getAllLatest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvProperties();
        rvLates();
        showAllLatest();
        rvFavorite();

    }

    @Override
    public void onMenuClickListener(int position) {
        switch(position) {
            case 0:
                Toast.makeText(this, "Menu House Coming Soon", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(this, "Menu Apartement Coming Soon", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this, "Menu Villa Coming Soon", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(this, "Menu Other Coming Soon", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(this, "Menu Coming Soon", Toast.LENGTH_LONG).show();
                break;
        }

    }

    private void rvProperties(){
        recyclerView = new RecyclerView(this);
        recyclerView = findViewById(R.id.rvChoose);
        recyclerView.setHasFixedSize(true);
        menuModels.addAll(MenuData.getListData());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        menuAdapter = new MenuAdapter(menuModels, this);
        recyclerView.setAdapter(menuAdapter);
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
    }

    private void rvLates(){
        rvLates = new RecyclerView(this);
        rvLates = findViewById(R.id.rvLates);
        rvLates.setHasFixedSize(true);
        latestModels.addAll(LatestData.getListData());
        rvLates.setLayoutManager((new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, true)));
        latestAdapter = new LatestAdapter(latestModels, this, this);
        rvLates.setAdapter(latestAdapter);
        ViewCompat.setNestedScrollingEnabled(rvLates, false);

    }

    private void showAllLatest(){
        getAllLatest = findViewById(R.id.getAllLatest);
        getAllLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new AllLatesFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_dash, newFragment);
                Bundle bundle = new Bundle();
                newFragment.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private void rvFavorite(){
        rvFovorite = new RecyclerView(this);
        rvFovorite = findViewById(R.id.rvFavotiro);
        rvFovorite.setHasFixedSize(true);
        favoriteModels.addAll(FavoriteData.getListData());
        rvFovorite.setLayoutManager(new GridLayoutManager(this, 1));
        favoriteAdapter = new FavoriteAdapter(favoriteModels, this, this);
        rvFovorite.setAdapter(favoriteAdapter);
        ViewCompat.setNestedScrollingEnabled(rvFovorite, false);
    }
}