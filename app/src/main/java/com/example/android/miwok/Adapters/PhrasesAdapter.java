package com.example.android.miwok.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.miwok.LanguageElements.*;
import com.example.android.miwok.R;

import java.util.ArrayList;

/**
 * Created by ALIN on 3/17/2018.
 */
    public class PhrasesAdapter extends ArrayAdapter<Phrase> {

    private TextView headerTextView, subTextView;


        public PhrasesAdapter(Activity context, ArrayList<Phrase> wordsArrayList){

            super(context, 0,wordsArrayList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItemView = convertView;
            if (listItemView == null){
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_phrases_text_view,parent,false);
            }
            Phrase currentPhrase = getItem(position);
            headerTextView = (TextView)listItemView.findViewById(R.id.headerTextView);
            subTextView = (TextView)listItemView.findViewById(R.id.subTextView);

            headerTextView.setText(currentPhrase.getMiwokWord());
            subTextView.setText(currentPhrase.getEnglishWord());

            return listItemView;
        }
    }
