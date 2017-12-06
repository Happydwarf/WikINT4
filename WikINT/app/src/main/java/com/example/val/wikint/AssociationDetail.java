package com.example.val.wikint;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by alexisblervaque on 24/11/2017.
 */

public class AssociationDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.association_detail_layout);

        Bundle bundle = getIntent().getBundleExtra("Association");
        Association asso = bundle.getParcelable("Asso");

        String description = asso.getDescription();
        TextView descriptionView = (TextView)findViewById(R.id.description);
        descriptionView.setText(description);

        String president = asso.getPresident();

        String pp = asso.getProfil_picture();
        ImageView photo_profil = (ImageView) findViewById(R.id.profil_picture);
        int imageId = getResources().getIdentifier(pp,"drawable",getPackageName());
        photo_profil.setImageResource(imageId);


        Button button2 = (Button) findViewById(R.id.button_event);

        Button button = (Button) findViewById(R.id.button_photos);
    }
}
