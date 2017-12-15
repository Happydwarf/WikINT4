package com.example.alexisblervaque.wikint;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AssociationDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_detail);
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

        // Recovery of data from Association list

        Bundle bundle = getIntent().getBundleExtra("Association");
        Association asso = bundle.getParcelable("Asso");


        // Automaticaly create the template of the association asso

        String name = asso.getName();
        TextView nom_asso = (TextView)findViewById(R.id.nom_asso);
        nom_asso.setText(name);

        String description = asso.getDescription();
        TextView descriptionView = (TextView)findViewById(R.id.description);
        descriptionView.setText(description);

        String president = asso.getPresident();
        TextView pres = (TextView)findViewById(R.id.nom_prez);
        pres.setText(president);

        String local = asso.getLocal();
        TextView emplacement_local = (TextView)findViewById(R.id.lieu_local);
        emplacement_local.setText(local);

        String pp = asso.getPictures().get(0);
        ImageView photo_profil = (ImageView) findViewById(R.id.profil_picture);
        int imageId = getResources().getIdentifier(pp,"drawable",getPackageName());
        photo_profil.setImageResource(imageId);

        String cover = asso.getPictures().get(1);
        ImageView cover_pict = (ImageView) findViewById(R.id.cover_picture);
        int imageId2 = getResources().getIdentifier(cover,"drawable",getPackageName());
        cover_pict.setImageResource(imageId2);


        // Attach the different buttons to the different activities

        Button button2 = (Button) findViewById(R.id.button_event);

        Button button = (Button) findViewById(R.id.button_photos);

    }

}
