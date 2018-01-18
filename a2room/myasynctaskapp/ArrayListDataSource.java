package a2room.myasynctaskapp;


import java.util.ArrayList;

/**
 * Created by Alexis Garcia Pagan on 1/17/2018.
 */

public class ArrayListDataSource {

    private static ArrayList<String> datasource = new ArrayList<>();

    public ArrayList<String> getDatasource() {

        datasource.add(0, "Alexis");
        datasource.add(1, "Pedro");
        datasource.add(2, "Alexander");
        datasource.add(3, "Jose");

        return datasource;
    }

}
