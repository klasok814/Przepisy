package com.androidaplication.bubu.przepisy;

import android.os.Parcel;
import android.os.Parcelable;

public class Categories implements Parcelable {
    private int mIcon;
    private String mName;

    public Categories(){}

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mIcon);
    }

    private Categories(Parcel in){
        mName = in.readString();
        mIcon = in.readInt();
    }

    public static final Creator<Categories> CREATOR = new Creator<Categories>() {
        @Override
        public Categories createFromParcel(Parcel in) {
            return new Categories(in);
        }

        @Override
        public Categories[] newArray(int size) {
            return new Categories[size];
        }
    };
}
