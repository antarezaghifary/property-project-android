package id.azer.bookinghotel;

import android.os.Bundle;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Objects;

import id.azer.bookinghotel.Adapter.AllLatestAdapter;
import id.azer.bookinghotel.Data.LatestData;
import id.azer.bookinghotel.Model.LatestModel;


public class AllLatesFragment extends Fragment implements AllLatestAdapter.OnClickListener{

    private ArrayList<LatestModel> latestModels = new ArrayList<>();
    AllLatestAdapter allLatestAdapter;
    RecyclerView rvLates;
    View view;

    public AllLatesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_all_lates, container, false);
        // Inflate the layout for this fragment
        rvAllLatest();

        return view;
    }

    @Override
    public void onMenuClickListener(int position) {

    }

    private void rvAllLatest(){
        rvLates = new RecyclerView(Objects.requireNonNull(getContext()));
        rvLates = view.findViewById(R.id.rvAllLates);
        rvLates.setHasFixedSize(true);
        latestModels.addAll(LatestData.getListDataFull());
        rvLates.setLayoutManager((new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, true)));
        allLatestAdapter = new AllLatestAdapter(latestModels, getContext());
        rvLates.setAdapter(allLatestAdapter);
        ViewCompat.setNestedScrollingEnabled(rvLates, false);
    }
}