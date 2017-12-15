package com.example.val.wikint;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alexisblervaque on 24/11/2017.
 */

public class AssociationDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.association_detail_layout);

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
