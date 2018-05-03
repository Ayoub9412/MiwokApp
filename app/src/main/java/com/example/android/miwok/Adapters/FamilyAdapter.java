package com.example.android.miwok.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.LanguageElements.*;
import com.example.android.miwok.R;

import java.util.ArrayList;

/**
 * Created by ALIN on 3/17/2018.
 */

public class FamilyAdapter extends ArrayAdapter {

    private TextView tvENglishFamillyMember,tvMiwokFamillyMember;
    private FamilyMember currentFamilyMember;
    private ImageView memberImage;

    public FamilyAdapter(Activity activity, ArrayList<FamilyMember> arrayList){

        super(activity,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_text_view_layout,null);
        }
        currentFamilyMember =(FamilyMember) getItem(position);

        tvENglishFamillyMember = (TextView)listItemView.findViewById(R.id.subTextView);
        tvMiwokFamillyMember = (TextView)listItemView.findViewById(R.id.headerTextView);
        memberImage = (ImageView)listItemView.findViewById(R.id.elementImageView);
        tvENglishFamillyMember.setText(currentFamilyMember.getEnglishFamillyMember());
        tvMiwokFamillyMember.setText(currentFamilyMember.getMiwokFamillyMember());
        memberImage.setImageResource(currentFamilyMember.getImageId());
        listItemView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.category_family));



        return listItemView;
    }
}
