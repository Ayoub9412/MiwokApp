package com.example.android.miwok.LanguageElements;

import android.content.Context;

import com.example.android.miwok.R;

import java.security.PublicKey;

/**
 * Created by ALIN on 3/17/2018.
 */

public class Color {
    private String mEnglishColor,mMiwokColor;
    private Context mContext;
    private int mImageId;
    private int mMediaID;

    public Color(Context c,String EnglishColor,String Miwokcolor, int ImageID, int MediaID){

        mContext = c;
        mEnglishColor = EnglishColor;
        mMiwokColor = Miwokcolor;
        mImageId = ImageID;
        mMediaID = MediaID;
    }
    ///////Getters
    public String getmEnglishColor(){
        return mEnglishColor;
    }
    public String getMiwokColor(){
        return mMiwokColor;
    }
    public int getImageId(){
        return mImageId;
    }
    public int getMediaId(){
        return mMediaID;
    }

}
