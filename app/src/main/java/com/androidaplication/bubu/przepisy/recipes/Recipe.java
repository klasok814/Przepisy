package com.androidaplication.bubu.przepisy.recipes;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable{
    private int mIcon;
    private String mName;
    private int mTime;
    private int mServes;
    private String[] mIngeedients;
    private String[] mDescriptions;

    public Recipe(){}

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getTime() {
        return mTime;
    }

    public void setTime(int time) {
        mTime = time;
    }

    public int getServes() {
        return mServes;
    }

    public void setServes(int serves) {
        mServes = serves;
    }

    public String[] getIngeedients() {
        return mIngeedients;
    }

    public void setIngeedients(String[] ingeedients) {
        mIngeedients = ingeedients;
    }

    public String[] getDescriptions() {
        return mDescriptions;
    }

    public void setDescriptions(String[] descriptions) {
        mDescriptions = descriptions;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mIcon);
        dest.writeString(mName);
        dest.writeInt(mTime);
        dest.writeInt(mServes);
        dest.writeStringArray(mIngeedients);
        dest.writeStringArray(mIngeedients);
    }

    private Recipe(Parcel in){
        mIcon = in.readInt();
        mName = in.readString();
        mTime = in.readInt();
        mServes = in.readInt();
        mIngeedients = in.createStringArray();
        mDescriptions = in.createStringArray();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
