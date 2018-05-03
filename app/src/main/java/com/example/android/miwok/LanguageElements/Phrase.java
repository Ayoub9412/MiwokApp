package com.example.android.miwok.LanguageElements;

import android.content.Context;

/**
 * Created by ALIN on 3/17/2018.
 */

public  class Phrase {

    private String mEnglishWord, mMiwokWord;
    private Context mContext;
    private int mMediaID;

    public Phrase(Context c, String EnglishWord, String MiwokWord,int MediaID) {
        mContext = c;
        mEnglishWord = EnglishWord;
        mMiwokWord = MiwokWord;
        mMediaID = MediaID;
    }

    public String getEnglishWord() {
        return mEnglishWord;
    }

    public String getMiwokWord() {
        return mMiwokWord;
    }

    public int getMediaId(){
        return mMediaID;
    }


}

