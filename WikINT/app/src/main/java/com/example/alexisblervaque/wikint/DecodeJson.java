package com.example.alexisblervaque.wikint;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static android.content.ContentValues.TAG;

/**
 * Created by alexisblervaque on 13/12/2017.
 */

public class DecodeJson {


    private FirebaseAuth mAuth;
    private String userID;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ArrayList<Association> associations = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private boolean wait;

    public DecodeJson(Context context)
    {

        wait = true;
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG,"___________CONNECTER______________________________");
                    //toastMessage("Successfully signed in with: " + user.getEmail());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    //toastMessage("Successfully signed out.");
                }
                // ...
            }
        };

        final Semaphore semaphore = new Semaphore(0);

        myRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                /*String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);*/
                actualizeData(dataSnapshot);
                semaphore.release();


                //showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

    private void actualizeData(DataSnapshot dataSnapshot) {



        DataSnapshot snapAsso = dataSnapshot.child("Associations");
        for (DataSnapshot ds: snapAsso.getChildren())
        {
            Association asso = new Association();


            asso.setId(Integer.parseInt(ds.child("id").getValue(String.class)));

            asso.setName(ds.child("name").getValue(String.class));
            asso.setPresident(ds.child("president").getValue(String.class));
            asso.setLocal(ds.child("local").getValue(String.class));
            asso.setDescription(ds.child("description").getValue(String.class));

            DataSnapshot picturesData = ds.child("pictures");
            ArrayList<String> pictures = new ArrayList<>();
            for (int i = 0; i<ds.child("pictures").getChildrenCount();i++)
            {
                String picture = picturesData.child(String.valueOf(i)).getValue(String.class);
                pictures.add(picture);
            }
            asso.setPictures(pictures);

            DataSnapshot membersData = ds.child("members");
            ArrayList<String> members = new ArrayList<>();
            for (int i = 0; i<ds.child("members").getChildrenCount();i++)
            {
                String member = membersData.child(String.valueOf(i)).getValue(String.class);
                members.add(member);
            }
            asso.setMembers(members);


            DataSnapshot id_EventsData = ds.child("id_Events");
            ArrayList<Integer> id_Events = new ArrayList<>();
            for (int i = 0; i<ds.child("id_Events").getChildrenCount();i++)
            {
                String id_Event = id_EventsData.child(String.valueOf(i)).getValue(String.class);
                int id_EventInt = Integer.parseInt(id_Event);
                id_Events.add(id_EventInt);
            }
            asso.setId_Events(id_Events);


            associations.add(asso);
        }

        DataSnapshot snapEvent = dataSnapshot.child("Events");
        for (DataSnapshot ds: snapEvent.getChildren())
        {
            Event event = new Event();

            event.setId(Integer.parseInt(ds.child("id").getValue(String.class)));

            event.setName(ds.child("name").getValue(String.class));

            String dateString = ds.child("firstDate").getValue(String.class);
            event.setFirstDate(convertToDate(dateString));

            dateString = ds.child("endDate").getValue(String.class);
            event.setEndDate(convertToDate(dateString));

            event.setDescription(ds.child("description").getValue(String.class));
            event.setLieu(ds.child("lieu").getValue(String.class));

            DataSnapshot imagesData = ds.child("images");
            ArrayList<String> images = new ArrayList<>();
            for (int i = 0; i<ds.child("images").getChildrenCount();i++)
            {
                String image = imagesData.child(String.valueOf(i)).getValue(String.class);
                images.add(image);
            }
            event.setImages(images);

            event.setId_association(Integer.parseInt(ds.child("id_association").getValue(String.class)));


            this.events.add(event);

        }

        wait = false;

    }


    private class gsonDate{
        public gsonDate(Date date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "gsonDate{" +
                    "date=" + date +
                    '}';
        }

        private Date date;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    private Date convertToDate(String dateString)
    {
        String jsonString = "{\"date\": \"" + dateString + "\"}";
        Gson gson = new GsonBuilder().create();
        gsonDate date = gson.fromJson(jsonString,gsonDate.class);
        return date.date;
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




}
