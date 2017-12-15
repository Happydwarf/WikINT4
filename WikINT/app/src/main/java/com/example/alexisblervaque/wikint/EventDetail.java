package com.example.alexisblervaque.wikint;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class EventDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Bundle bundle = getIntent().getBundleExtra("eventBundle");
        final Event event = bundle.getParcelable("event");
        final Association asso = bundle.getParcelable("asso");

        ImageView imageCover = (ImageView)findViewById(R.id.coverEventPicture);
        int imageId = getResources().getIdentifier(event.getImages().get(0),"drawable", getPackageName());
        imageCover.setImageResource(imageId);

        TextView nameOfEvent = (TextView) findViewById(R.id.NameOfEvent);
        nameOfEvent.setText(event.getName());






        Date firstDate = new Date(getIntent().getExtras().getLong("firstDate", -1));
        Date endDate = new Date(getIntent().getExtras().getLong("endDate", -1));



        String[] firstDateArray = firstDate.toString().split(" ");
        String[] endDateArray = endDate.toString().split(" ");



        TextView monthName = (TextView) findViewById(R.id.monthName);
        monthName.setText(firstDateArray[1]);

        TextView dateBig = (TextView)findViewById(R.id.dateBig);
        dateBig.setText(firstDateArray[2]);


        TextView lapsTime = (TextView)findViewById(R.id.lapsTime);
        lapsTime.setText(firstDateArray[2] + " " + firstDateArray[1] + " " + firstDateArray[5] + " " + firstDateArray[3] + " - " + endDateArray[3] );


        TextView lieuxText = (TextView)findViewById(R.id.lieuxText);
        lieuxText.setText(event.getLieu());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(event.getDescription());

        final DecodeJson JsonData = new DecodeJson(this);

        Button voirAsso = (Button)findViewById(R.id.VoirAsso);
        voirAsso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),AssociationDetail.class);
                Bundle b = new Bundle();
                b.putParcelable("Asso",asso);
                i.putExtra("Association", b);
                startActivity(i);
            }
        });

    }

}
