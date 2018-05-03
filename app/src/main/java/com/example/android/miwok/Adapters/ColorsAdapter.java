package com.example.android.miwok.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.LanguageElements.Color;
import com.example.android.miwok.R;

import java.util.ArrayList;

/**
 * Created by ALIN on 3/17/2018.
 */

public class ColorsAdapter extends ArrayAdapter<Color> {

    private TextView tvEnglishColorName,tvMiwokColorName;
    private Color currentColor;
    private ImageView colorImage;
    private View listItemView;


    public ColorsAdapter(Activity activity, ArrayList<Color> arrayList){
        super(activity,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        listItemView = convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_text_view_layout,null);
        }
        currentColor = getItem(position);
        tvEnglishColorName = (TextView)listItemView.findViewById(R.id.subTextView);
        tvMiwokColorName = (TextView)listItemView.findViewById(R.id.headerTextView);
        colorImage = (ImageView)listItemView.findViewById(R.id.elementImageView);
        tvEnglishColorName.setText(currentColor.getmEnglishColor());
        tvMiwokColorName.setText(currentColor.getMiwokColor());
        colorImage.setImageResource(currentColor.getImageId());
        listItemView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.category_colors));

        return listItemView;
    }
}
