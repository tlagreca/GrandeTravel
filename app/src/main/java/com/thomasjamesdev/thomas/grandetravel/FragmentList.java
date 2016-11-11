package com.thomasjamesdev.thomas.grandetravel;

import android.app.Fragment;
import android.app.ListFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Thomas on 9/11/2016.
 */

public class FragmentList extends Fragment {

    ListView listViewPackages;
    PackageAdapter packageAdapter;
    ArrayList<Package> packages;

    public FragmentList() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_list, container, false);

        packages = new ArrayList<>();
        packageAdapter = new PackageAdapter(getActivity(), packages);

        listViewPackages = (ListView)view.findViewById(R.id.listView_packages);
        listViewPackages.setAdapter(packageAdapter);

        InputStream stream = getResources().openRawResource(R.raw.json_dummy_data);
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String line;
            while( (line = reader.readLine()) != null ){
                builder.append(line);
            }

            String jsonString = builder.toString();
            JSONObject jsonObject = new JSONObject(jsonString);

            extractPackages(jsonObject);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return view;
    }

    private void extractPackages(JSONObject jsonObject) {

        try{
            if(jsonObject != null){

                JSONObject jObjectResult = jsonObject.getJSONObject("packages");

                JSONArray jsonPackages = jObjectResult.getJSONArray("package");

                String title;
                String location;
                String description;
                int price;

                for(int i = 0; i < jsonPackages.length(); i++){

                    JSONObject jsonPackage = jsonPackages.getJSONObject(i);


                    title = jsonPackage.getString("PackageTitle");
                    location = jsonPackage.getString("PackageLocation");
                    description = jsonPackage.getString("PackageDescription");
                    price = jsonPackage.getInt("PackagePrice");


                    packages.add(new Package(title, location, description, price));
                }

                for(Package p : packages){
                    packageAdapter.add(p);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
