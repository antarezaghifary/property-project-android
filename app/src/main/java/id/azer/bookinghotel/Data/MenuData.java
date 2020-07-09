package id.azer.bookinghotel.Data;

import java.util.ArrayList;

import id.azer.bookinghotel.Model.MenuModel;
import id.azer.bookinghotel.R;

public class MenuData {
    private static String[] MENU = {
            "House",
            "Apartement",
            "Villa",
            "Other",

    };

    private static int[] IMAGE = {
            R.drawable.user_empty,
            R.drawable.user_empty,
            R.drawable.user_empty,
            R.drawable.user_empty,
    };

    public static ArrayList<MenuModel> getListData() {
        ArrayList<MenuModel> list = new ArrayList<>();
        for (int position = 0; position < IMAGE.length; position++) {
            MenuModel model = new MenuModel();
            model.setImage(IMAGE[position]);
            model.setName(MENU[position]);
            list.add(model);
        }
        return list;
    }
}
