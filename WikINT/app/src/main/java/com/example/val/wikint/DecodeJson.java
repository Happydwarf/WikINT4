package com.example.val.wikint;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Val on 03/12/2017.
 */

public class DecodeJson {



    private ArrayList<Association> associations;
    private ArrayList<Event> events;


    public DecodeJson(Context context)
    {
        JsonParser mGparser = new JsonParser();
        Gson mGson = new Gson();
        Gson gson = new GsonBuilder().create();


        String associationJsonString = loadJSONFromAsset(context, "Associations.json");
        JsonArray associationsJsonArray = (JsonArray) mGparser.parse(associationJsonString);
        associations = mGson.fromJson(associationsJsonArray, new TypeToken<ArrayList<Association>>() {}.getType());

        String eventsJsonString = loadJSONFromAsset(context, "Events.json");
        JsonArray eventsJsonArray = (JsonArray) mGparser.parse(eventsJsonString);
        events = mGson.fromJson(eventsJsonArray, new TypeToken<ArrayList<Event>>() {}.getType());


    }


    public ArrayList<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(ArrayList<Association> associations) {
        this.associations = associations;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    private String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
