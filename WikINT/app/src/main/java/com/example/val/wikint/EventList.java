package com.example.val.wikint;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by alexisblervaque on 06/12/2017.
 */

public class EventList extends Activity {

    private LinearLayout scrollContent;
    private ArrayList<Event> listeEvent;
    private ArrayList<String> images;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);

        scrollContent = findViewById(R.id.eventContainer);
/*        listeEvent = new ArrayList<>();
        images = new ArrayList<>();
        images.add("clinique");

*/
        DecodeJson JsonData = new DecodeJson(this);
        ArrayList<Event> listeEvent = JsonData.getEvents();



        for (Event event : listeEvent)
        {
            LinearLayout linear = eventLayout(event, JsonData);
            scrollContent.addView(linear);
        }





    }


    private LinearLayout eventLayout(final Event event, final DecodeJson JsonData)
    {
        LinearLayout result = new LinearLayout(this);
        LinearLayout.LayoutParams paramsFirst = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsFirst.setMargins(0,0,0,20);
        result.setLayoutParams(paramsFirst);
        //result.setBackgroundResource(R.drawable.border);
        result.setOrientation(LinearLayout.VERTICAL);



        //Head of the event
        LinearLayout headLayout = new LinearLayout(this);
        headLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100));
        headLayout.setOrientation(LinearLayout.HORIZONTAL);

        // Button logo for the head
        ImageButton logoButton = new ImageButton(this);
        logoButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        logoButton.setBackgroundColor(Color.TRANSPARENT);
        logoButton.setPadding(15,15,15,15);
        int imageLogoID = getResources().getIdentifier(JsonData.getAssociations().get(event.getId_association()).getPictures().get(0),"drawable", getPackageName());
        logoButton.setImageResource(imageLogoID);

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),AssociationDetail.class);
                Bundle b = new Bundle();
                Association asso = JsonData.getAssociations().get(event.getId_association());
                b.putParcelable("Asso",asso);
                i.putExtra("Association", b);
                startActivity(i);
            }
        });


        //Description of the head
        LinearLayout descriptionHead = new LinearLayout(this);
        descriptionHead.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100));
        descriptionHead.setOrientation(LinearLayout.VERTICAL);
        descriptionHead.setPadding(5,5,5,5);

        TextView typeOfEvent = new TextView(this);
        LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,40);
        param1.gravity = Gravity.CENTER;
        typeOfEvent.setLayoutParams(param1);
        typeOfEvent.setGravity(Gravity.CENTER_HORIZONTAL);

        String associationName = JsonData.getAssociations().get(event.getId_association()).getName();
        String type = "Evenement de " + associationName;
        typeOfEvent.setText(type);

        TextView nameOfEvent = new TextView(this);
        LinearLayout.LayoutParams param2= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,30);
        param2.gravity = Gravity.CENTER;
        nameOfEvent.setLayoutParams(param2);
        nameOfEvent.setGravity(Gravity.CENTER_HORIZONTAL);
        nameOfEvent.setText(event.getName());

        TextView dateOfEvent = new TextView(this);
        LinearLayout.LayoutParams param3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        param3.gravity = Gravity.END | Gravity.BOTTOM;
        dateOfEvent.setLayoutParams(param3);
        dateOfEvent.setGravity(Gravity.CENTER_HORIZONTAL);
        SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yyyy");
        String dateString = simpleDate.format(event.getFirstDate());
        dateOfEvent.setText(dateString);

        descriptionHead.addView(typeOfEvent);
        descriptionHead.addView(nameOfEvent);
        descriptionHead.addView(dateOfEvent);

        headLayout.addView(logoButton);
        headLayout.addView(descriptionHead);

        // Line in the midle
        LinearLayout line = new LinearLayout(this);
        LinearLayout.LayoutParams paramLine = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,2);
        paramLine.setMargins(40,20,40,20);
        line.setLayoutParams(paramLine);
        line.setBackgroundColor(Color.parseColor("#ff33b5e5"));

        // Image of the event
        ImageView image = new ImageView(this);
        LinearLayout.LayoutParams paramImage = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
        paramImage.setMargins(20,0,20,0);
        image.setLayoutParams(paramImage);
        int idOfImage = getResources().getIdentifier(event.getImages().get(0),"drawable",getPackageName());
        image.setImageResource(idOfImage);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Buttons for the event
        LinearLayout buttonLinear = new LinearLayout(this);
        buttonLinear.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buttonLinear.setPadding(10,10,10,10);

        Button buttonNotification = new Button(this);
        buttonNotification.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buttonNotification.setGravity(Gravity.CENTER);
        buttonNotification.setText("Prévenir des ami(e)s");

        Button buttonDetail = new Button(this);
        buttonDetail.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buttonDetail.setGravity(Gravity.CENTER);
        buttonDetail.setText("Détails");

        buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),EventDetail.class);
                Bundle b = new Bundle();
                b.putParcelable("event",event);
                Association asso = JsonData.getAssociations().get(event.getId_association());
                b.putParcelable("asso",asso);
                i.putExtra("eventBundle", b);
                i.putExtra("firstDate",event.getFirstDate().getTime());
                i.putExtra("endDate",event.getEndDate().getTime());
                startActivity(i);
            }
        });


        buttonLinear.addView(buttonNotification);
        buttonLinear.addView(buttonDetail);



        //Add the view to the result
        result.addView(headLayout);
        result.addView(line);
        result.addView(image);
        result.addView(buttonLinear);


        return result;
    }
}
