package com.example.val.wikint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by alexisblervaque on 24/11/2017.
 */

public class AssociationList extends Activity {

    private GridLayout AssoContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.association_list);


        AssoContainer = findViewById(R.id.AssoContainer);

        DecodeJson JsonData = new DecodeJson(this);
        ArrayList<Association> associations = JsonData.getAssociations();





        AssoContainer.setRowCount(associations.size()/2 + associations.size()%2);

        int i = 0;
        for (Association asso : associations)
        {
            GridLayout.Spec titleTxtSpecColumn = GridLayout.spec(i%2,GridLayout.FILL);
            GridLayout.Spec titleRowSpec = GridLayout.spec(i/2);
            FrameLayout frame = createFrame(asso);
            AssoContainer.addView(frame, new GridLayout.LayoutParams(titleRowSpec , titleTxtSpecColumn) );
            i++;
        }



    }

    private FrameLayout createFrame(final Association asso)
    {
        FrameLayout result = new FrameLayout(this);
        result.setLayoutParams(new FrameLayout.LayoutParams(AssoContainer.getWidth()/2,120));

        ImageButton button = new ImageButton(this);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setPadding(5,5,5,5);
        button.setImageResource(R.drawable.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),AssociationDetail.class);
                Bundle b = new Bundle();
                b.putParcelable("Asso",asso);
                i.putExtra("Association", b);
                startActivity(i);

            }
        });

        ImageView image = new ImageView(this);
        LinearLayout.LayoutParams imageParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        imageParam.gravity = Gravity.CENTER;
        image.setLayoutParams(imageParam);
        int imageId = getResources().getIdentifier(asso.getPictures().get(0),"drawable",getPackageName());
        image.setImageResource(imageId);
        image.setPadding(10,30,10,10);


        TextView text = new TextView(this);
        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        textParam.gravity = Gravity.BOTTOM;
        text.setLayoutParams(textParam);
        text.setPadding(10,10,10,10);
        text.setText(asso.getName());
        text.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);


        result.addView(button);
        result.addView(image);
        result.addView(text);


        return result;
    }

    private class JsonData
    {
        private ArrayList<Association> associations;
        private ArrayList<Event> events;

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


    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Associations.json");
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
