package com.thomasjamesdev.thomas.grandetravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Thomas on 8/11/2016.
 */

public class PackageAdapter extends ArrayAdapter<Package>{

    public PackageAdapter(Context context, ArrayList<Package> packages) {
        super(context, 0, packages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Package p = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
        }

        TextView textPackageTitle = (TextView)convertView.findViewById(R.id.tvPackageTitle);
        TextView textPackageLocation = (TextView)convertView.findViewById(R.id.tvPackageLocation);
        TextView textPackageDescription = (TextView)convertView.findViewById(R.id.tvPackageDescription);
        TextView textViewPackagePrice = (TextView)convertView.findViewById(R.id.tvPackagePrice);

        textPackageTitle.setText(p.getPackageTitle());
        textPackageLocation.setText(p.getPackageLocation());
        textPackageDescription.setText(p.getPackageDescription());

        String priceOutput = "$" + p.getPackagePrice();

        textViewPackagePrice.setText(priceOutput);

        return convertView;
    }


}
