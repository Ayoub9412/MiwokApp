package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.android.miwok.Adapters.FamilyAdapter;
import com.example.android.miwok.LanguageElements.FamilyMember;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    ArrayList<FamilyMember> arrayList = new ArrayList<FamilyMember>();
    ListView listView;
    FamilyAdapter familyAdapter;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);

        arrayList.add(new FamilyMember(this,"father","әpә",R.mipmap.family_father,R.raw.family_father));
        arrayList.add(new FamilyMember(this,"mother","әṭa",R.mipmap.family_mother,R.raw.family_mother));
        arrayList.add(new FamilyMember(this,"son","angsi",R.mipmap.family_son,R.raw.family_son));
        arrayList.add(new FamilyMember(this,"daughter","tune",R.mipmap.family_daughter,R.raw.family_daughter));
        arrayList.add(new FamilyMember(this,"older brother","taachi",R.mipmap.family_older_brother,R.raw.family_older_brother));
        arrayList.add(new FamilyMember(this,"younger brother","chalitti",R.mipmap.family_younger_brother,R.raw.family_younger_brother));
        arrayList.add(new FamilyMember(this,"older sister","teṭe",R.mipmap.family_older_sister,R.raw.family_older_sister));
        arrayList.add(new FamilyMember(this,"younger sister","kolliti",R.mipmap.family_younger_sister,R.raw.family_younger_sister));
        arrayList.add(new FamilyMember(this,"grandmother","ama",R.mipmap.family_grandmother,R.raw.family_grandmother));
        arrayList.add(new FamilyMember(this,"grandfather","paapa",R.mipmap.family_grandfather,R.raw.family_grandfather));

        listView = (ListView)findViewById(R.id.listView_items);
        familyAdapter = new FamilyAdapter(this,arrayList);
        listView.setAdapter(familyAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (mediaPlayer!=null)
                    mediaPlayer.release();
                mediaPlayer = null;

                mediaPlayer = MediaPlayer.create(getApplicationContext(),arrayList.get(position).getMediaId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.release();
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
