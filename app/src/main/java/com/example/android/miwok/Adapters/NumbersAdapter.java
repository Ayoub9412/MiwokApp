package com.example.android.miwok.Adapters;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.miwok.LanguageElements.Number;
import com.example.android.miwok.R;

import java.util.ArrayList;

/**
 * Created by ALIN on 3/17/2018.
 */

public class NumbersAdapter extends ArrayAdapter<Number> {

    private TextView tvMiwokNumber,tvEnglishNumber;
    private ImageView numberImage,playButton;

    public NumbersAdapter(Activity context, ArrayList<Number> list){

        super(context,0,list);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listITem = convertView;
        if (listITem==null){
            listITem = LayoutInflater.from(getContext()).inflate(R.layout.custom_text_view_layout,null);
        }
        Number currentNumber = getItem(position);

        tvMiwokNumber = (TextView)listITem.findViewById(R.id.headerTextView);
        tvEnglishNumber = (TextView)listITem.findViewById(R.id.subTextView);
        numberImage = (ImageView)listITem.findViewById(R.id.elementImageView);
        playButton = (ImageView)listITem.findViewById(R.id.playButton);

        tvEnglishNumber.setText(currentNumber.getEnglishNumber());
        tvMiwokNumber.setText(currentNumber.getMiwokNumber());
        numberImage.setImageResource(currentNumber.getImageId());
        listITem.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.category_numbers));



        return listITem;
    }
}
