package com.example.applicatksu.zayavlenie.dokuments;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DataClass implements Parcelable {
    private  String imageURL, caption;
    public DataClass(){

    }
    public DataClass(String imageURL, String caption) {
        this.imageURL = imageURL;
        this.caption = caption;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(imageURL);
        dest.writeString(caption);
    }
    public static final Parcelable.Creator<DataClass> CREATOR = new Parcelable.Creator<DataClass>() {
        @Override
        public DataClass createFromParcel(Parcel in) {
            return new DataClass(in);
        }
        @Override
        public DataClass[] newArray(int size) {
            return new DataClass[size];
        }
    };
    private DataClass(Parcel in) {
        imageURL = in.readString();
        caption = in.readString();
    }
}
