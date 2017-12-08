package com.example.val.wikint;

import android.media.Image;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Val on 29/11/2017.
 */

public class Event {


    private Date date;
    private String name;
    private String description;
    private ArrayList<String> images;
    private String lieu;
    private int id_association;

    public Event(Date date, String name, String description, ArrayList<String> images, String lieu, int id_association) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.images = images;
        this.lieu = lieu;
        this.id_association = id_association;
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", lieu='" + lieu + '\'' +
                ", id_association=" + id_association +
                '}';
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImage(ArrayList<String> images) {
        this.images = images;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getId_association() {
        return id_association;
    }

    public void setId_association(int id_association) {
        this.id_association = id_association;
    }
}
