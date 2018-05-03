package com.example.android.miwok.LanguageElements;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.example.android.miwok.R;

import java.security.PublicKey;

/**
 * Created by ALIN on 3/17/2018.
 */

public class Number {

    private Context mContext;
    private String mEnglishNumber, mMiwokNumber;
    private int mImageId;
    private int mMediaID;

    public Number(Context c, String EnglishNumber, String MiwokNumber, int ImageID, int mediaID){
        mEnglishNumber = EnglishNumber;
        mMiwokNumber = MiwokNumber;
        mContext = c;
        mImageId = ImageID;
        mMediaID = mediaID;
    }
    public String getEnglishNumber(){
        return mEnglishNumber;
    }
    public String getMiwokNumber(){
        return mMiwokNumber;
    }
    public int getImageId(){
        return mImageId;
    }
    public int getMediaId(){
        return mMediaID;
    }
}
