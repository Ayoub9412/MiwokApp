package com.example.android.miwok.LanguageElements;

import android.content.Context;

import com.example.android.miwok.R;

/**
 * Created by ALIN on 3/17/2018.
 */

public class FamilyMember {
    
    private String mEnglishFamillyMember,mMiwokFamillyMember;
    private Context mContext;
    private int mImageId;
    private int mMediaID;
    public static final int BG_COLOR = R.color.category_family;
    
    public FamilyMember(Context c, String EnglishFamillyMember,String MiwokFamillyMember, int ImageId,int MediaID){
        
        mContext = c;
        mEnglishFamillyMember = EnglishFamillyMember;
        mMiwokFamillyMember = MiwokFamillyMember;
        mImageId = ImageId;
        mMediaID = MediaID;
    }
    /////Getters
    public String getEnglishFamillyMember(){
        return mEnglishFamillyMember;
    }
    public String getMiwokFamillyMember(){
        return mMiwokFamillyMember;
    }
    public int getImageId(){
        return mImageId;
    }
    public int getMediaId(){
        return mMediaID;
    }
}
