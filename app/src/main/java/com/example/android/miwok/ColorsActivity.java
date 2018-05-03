package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.android.miwok.Adapters.ColorsAdapter;
import com.example.android.miwok.LanguageElements.Color;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    ArrayList<Color> arrayList= new ArrayList<Color>();
    ListView listView;
    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);

        arrayList.add(new Color(this,"red","weṭeṭṭi",R.mipmap.color_red,R.raw.color_red));
        arrayList.add(new Color(this,"green","chokokki",R.mipmap.color_green,R.raw.color_green));
        arrayList.add(new Color(this,"brown","ṭakaakki",R.mipmap.color_brown,R.raw.color_brown));
        arrayList.add(new Color(this,"gray","ṭopoppi",R.mipmap.color_gray,R.raw.color_gray));
        arrayList.add(new Color(this,"black","kululli",R.mipmap.color_black,R.raw.color_black));
        arrayList.add(new Color(this,"white","kelelli",R.mipmap.color_white,R.raw.color_white));
        arrayList.add(new Color(this,"dusty yellow","ṭopiisә",R.mipmap.color_dusty_yellow,R.raw.color_dusty_yellow));
        arrayList.add(new Color(this,"mustard yellow","chiwiiṭә",R.mipmap.color_mustard_yellow,R.raw.color_mustard_yellow));

        listView = (ListView)findViewById(R.id.listView_items);

        ColorsAdapter colorsAdapter = new ColorsAdapter(this,arrayList);

        listView.setAdapter(colorsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (mediaPlayer!=null)
                    mediaPlayer.release();
                mediaPlayer = null;

                mediaPlayer = MediaPlayer.create(ColorsActivity.this,arrayList.get(position).getMediaId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (mediaPlayer!=null){
                            mediaPlayer.release();
                        }
                        mediaPlayer = null;
                    }
                });


            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer!=null)
            mediaPlayer.release();
        mediaPlayer = null;
    }

}
