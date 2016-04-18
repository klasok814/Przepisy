package com.androidaplication.bubu.przepisy;

public class Recipe {
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
}
