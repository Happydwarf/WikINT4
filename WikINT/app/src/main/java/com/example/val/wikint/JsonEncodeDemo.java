package com.example.val.wikint;


import android.support.annotation.NonNull;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;

/**
 * Created by Val on 01/12/2017.
 */

public class JsonEncodeDemo {

    public static void main(String[] args) throws JSONException{
        HashMap asint = new HashMap();

        asint.put("id", 1);
        asint.put("name", "ASINT");
        asint.put("président", "Alexis Perrin");
        asint.put("local","RDC du Foyer");
        asint.put("eventList", null);


        JSONObject objAsint = new JSONObject();
        objAsint.put("asint",asint);
        String objstring = objAsint.toString();
        try {
            File ff = new File("C:\\User\\Val\\Documents\\objet.txt"); // définir l'arborescence
            ff.createNewFile();
            FileWriter ffw = new FileWriter(ff);
            ffw.write(objstring);  // écrire une ligne dans le fichier resultat.txt
            ffw.write("\n"); // forcer le passage à la ligne
            ffw.close(); // fermer le fichier à la fin des traitements
        }
        catch (Exception e) {}
    }
}
