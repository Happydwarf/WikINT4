package com.example.val.wikint;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Val on 29/11/2017.
 */

public class Association implements Parcelable {
    private String name;
    private int id;
    private String profil_picture;
    private String president;
    private String local;
    private String description;
    private String cover_picture;
    private List<String> members;
    private List<Event> eventList;

    public Association(String name, int id, String profil_picture, String president, String local, String description, String cover_picture, List<String> members, List<Event> eventList) {
        this.name = name;
        this.id = id;
        this.profil_picture = profil_picture;
        this.president = president;
        this.local = local;
        this.description = description;
        this.cover_picture = cover_picture;
        this.members = members;
        this.eventList = eventList;
    }


    protected Association(Parcel in) {
        name = in.readString();
        id = in.readInt();
        profil_picture = in.readString();
        president = in.readString();
        local = in.readString();
        description = in.readString();
        members = in.createStringArrayList();
        cover_picture = in.readString();
    }

    public static final Creator<Association> CREATOR = new Creator<Association>() {
        @Override
        public Association createFromParcel(Parcel in) {
            return new Association(in);
        }

        @Override
        public Association[] newArray(int size) {
            return new Association[size];
        }
    };



    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getCover_picture() {
        return cover_picture;
    }

    public void setCover_picture(String cover_picture) {
        this.cover_picture = cover_picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfil_picture() {
        return profil_picture;
    }

    public void String(String profil_picture) {
        this.profil_picture = profil_picture;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeString(profil_picture);
        dest.writeString(president);
        dest.writeString(local);
        dest.writeString(description);
        dest.writeStringList(members);
        dest.writeString(cover_picture);
    }


}
