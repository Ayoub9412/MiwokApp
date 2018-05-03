package com.example.android.miwok;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.android.miwok.Adapters.PhrasesAdapter;
import com.example.android.miwok.LanguageElements.Phrase;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    ArrayList<Phrase> phrasesList = new ArrayList<Phrase>();
    PhrasesAdapter phrasesAdapter;
    ListView listView ;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);

        listView= (ListView)findViewById(R.id.listView_items);

        phrasesList.add(new Phrase(this,"Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        phrasesList.add(new Phrase(this,"What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        phrasesList.add(new Phrase(this,"My name is...","oyaaset...",R.raw.phrase_my_name_is));
        phrasesList.add(new Phrase(this,"How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        phrasesList.add(new Phrase(this,"I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        phrasesList.add(new Phrase(this,"Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        phrasesList.add(new Phrase(this,"Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        phrasesList.add(new Phrase(this,"I’m coming.","әәnәm",R.raw.phrase_im_coming));
        phrasesList.add(new Phrase(this,"Let’s go.","yoowutis",R.raw.phrase_lets_go));
        phrasesList.add(new Phrase(this,"Come here.","әnni'nem",R.raw.phrase_come_here));

        final PhrasesAdapter phrasesAdapter = new PhrasesAdapter(this,phrasesList);


        listView.setAdapter(phrasesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (mediaPlayer!=null)
                    mediaPlayer.release();
                mediaPlayer = null;

                mediaPlayer = MediaPlayer.create(getApplicationContext(),phrasesList.get(position).getMediaId());

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
