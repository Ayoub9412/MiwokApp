package com.example.android.miwok;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.android.miwok.LanguageElements.*;
import com.example.android.miwok.Adapters.*;
import com.example.android.miwok.LanguageElements.Number;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<Number> tvChilds = new ArrayList<Number>();
    NumbersAdapter numbersAdapter;
    ImageView playButtonImage;
    MediaPlayer mediaPlayer;
    AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
    AudioManager mAudioManager;
    int audioFocusState;
    AudioFocusRequest maudioFocusRequest;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);

        tvChilds.add(new Number(this,"One","lutti",R.mipmap.number_one,R.raw.number_one));
        tvChilds.add(new Number(this,"Two","otiiko",R.mipmap.number_two,R.raw.number_two));
        tvChilds.add(new Number(this,"Three","tolookosu",R.mipmap.number_three,R.raw.number_three));
        tvChilds.add(new Number(this,"four","oyyisa",R.mipmap.number_four,R.raw.number_four));
        tvChilds.add(new Number(this,"five","massokka",R.mipmap.number_five,R.raw.number_five));
        tvChilds.add(new Number(this,"six","temmokka",R.mipmap.number_six,R.raw.number_six));
        tvChilds.add(new Number(this,"seven","kenekaku",R.mipmap.number_seven,R.raw.number_seven));
        tvChilds.add(new Number(this,"eight","kawinta",R.mipmap.number_eight,R.raw.number_eight));
        tvChilds.add(new Number(this,"nine","wo'e",R.mipmap.number_nine,R.raw.number_nine));
        tvChilds.add(new Number(this,"Ten","na'aacha",R.mipmap.number_ten,R.raw.number_ten));


        numbersAdapter  =  new NumbersAdapter(this,tvChilds);
        mAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

        mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {

                switch (focusChange){
                    case AudioManager.AUDIOFOCUS_GAIN :
                        mediaPlayer.start();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS :
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mAudioManager.abandonAudioFocus(mAudioFocusListener);
                        mediaPlayer= null;
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT :
                        mediaPlayer.pause();
                        break;
                }
            }
        };

        ListView listView =(ListView) findViewById(R.id.listView_items);

        listView.setAdapter(numbersAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mediaPlayer!=null)
                    mediaPlayer.release();
                mediaPlayer = null;
                mediaPlayer = MediaPlayer.create(getApplicationContext(),tvChilds.get(position).getMediaId());

                audioFocusState = mAudioManager.requestAudioFocus(mAudioFocusListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);
                if (audioFocusState == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer.start();
                }
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
