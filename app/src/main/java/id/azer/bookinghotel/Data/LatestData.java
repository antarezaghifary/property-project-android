package id.azer.bookinghotel.Data;

import java.util.ArrayList;

import id.azer.bookinghotel.Model.LatestModel;
import id.azer.bookinghotel.R;

public class LatestData {
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

    public static ArrayList<LatestModel> getListData() {
        ArrayList<LatestModel> list = new ArrayList<>();
        for (int position = 0; position < 2; position++) {
            LatestModel model = new LatestModel();
            model.setImage(IMAGE[position]);
            model.setName(MENU[position]);
            model.setNama2(MENU2[position]);
            list.add(model);
        }
        return list;
    }
    public static ArrayList<LatestModel> getListDataFull() {
        ArrayList<LatestModel> list = new ArrayList<>();
        for (int position = 0; position < IMAGE.length; position++) {
            LatestModel model = new LatestModel();
            model.setImage(IMAGE[position]);
            model.setName(MENU[position]);
            model.setNama2(MENU2[position]);
            list.add(model);
        }
        return list;
    }
}
