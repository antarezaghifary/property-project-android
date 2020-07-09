package id.azer.bookinghotel.Data;

import java.util.ArrayList;

import id.azer.bookinghotel.Model.FavoriteModel;
import id.azer.bookinghotel.R;

public class FavoriteData {
    private static String[] MENU = {
            "Rumah Kentang",
            "Rumah Kakek",
            "Rumah Kentang",
            "Rumah Kakek","Rumah Kentang",
            "Rumah Kakek","Rumah Kentang",
            "Rumah Kakek","Rumah Kentang",
            "Rumah Kakek","Rumah Kentang",
            "Rumah Kakek",

    };

    private static String[] MENU2 = {
            "5 kamar \n3 kamar mandi",
            "5 kamar \n3 kamar mandi",
            "5 kamar \n3 kamar mandi",
            "5 kamar \n3 kamar mandi","5 kamar \n3 kamar mandi",
            "5 kamar \n3 kamar mandi","5 kamar \n3 kamar mandi",
            "5 kamar \n3 kamar mandi","5 kamar \n3 kamar mandi",
            "5 kamar \n3 kamar mandi","5 kamar \n3 kamar mandi",
            "5 kamar \n3 kamar mandi",
    };

    private static int[] IMAGE = {
            R.drawable.hotel_one,
            R.drawable.hotel_one,
            R.drawable.hotel_one,
            R.drawable.hotel_one,R.drawable.hotel_one,
            R.drawable.hotel_one,R.drawable.hotel_one,
            R.drawable.hotel_one,R.drawable.hotel_one,
            R.drawable.hotel_one,R.drawable.hotel_one,
            R.drawable.hotel_one,
    };

    public static ArrayList<FavoriteModel> getListData() {
        ArrayList<FavoriteModel> list = new ArrayList<>();
        for (int position = 0; position < 3; position++) {
            FavoriteModel model = new FavoriteModel();
            model.setImage(IMAGE[position]);
            model.setName(MENU[position]);
            model.setNama2(MENU2[position]);
            list.add(model);
        }
        return list;
    }
}
