package com.example.val.wikint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Val on 03/12/2017.
 */

public class DecodeJson {
    public static void main(String[] args) throws JSONException {

        String fichier ="/Users/alexisblervaque/WikInt2.0/WikINT/data.json";

        //String chaine="";

        String json = null;

        //lecture du fichier texte
        try{
            InputStream ips = new FileInputStream(fichier);
            //InputStreamReader ipsr = new InputStreamReader(ips);
            //BufferedReader br=new BufferedReader(ipsr);


            byte[] buffer = new byte[ips.available()];

            ips.read(buffer);

            ips.close();

            json = new String(buffer, "UTF-8");


            //String ligne;




            /*while ((ligne=br.readLine())!=null){
                System.out.println(ligne);
                chaine+=ligne+"\n";
            }*/
            //System.out.println(chaine);
            //br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }




        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();



        JSONObject j;
        Data data = null;

        try
        {
            j = new JSONObject(json);
            data = gson.fromJson(j.toString(), Data.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(data);

    }


    private class Data
    {
        private List<Association> associations;
        private List<Event> events;


        public List<Association> getAssociations() {
            return associations;
        }

        public void setAssociations(List<Association> associations) {
            this.associations = associations;
        }

        public List<Event> getEvents() {
            return events;
        }

        public void setEvents(List<Event> events) {
            this.events = events;
        }
    }

}
