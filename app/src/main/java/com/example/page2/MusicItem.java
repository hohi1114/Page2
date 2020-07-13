package com.example.page2;

import android.graphics.drawable.Drawable;

public class MusicItem {
    private Drawable icon;
    private String info1;
    private String info2;

    public MusicItem(Drawable profile, String info1,String info2){
        this.icon=profile;
        this.info1=info1;
        this.info2=info2;
    }
    public Drawable getProfile(){
        return this.icon;
    }
    public String getInfo1(){
        return this.info1;
    }
    public String getInfo2() { return this.info2;}
}
