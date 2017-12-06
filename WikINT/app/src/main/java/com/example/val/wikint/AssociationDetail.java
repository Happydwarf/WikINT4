package com.example.val.wikint;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by alexisblervaque on 24/11/2017.
 */

public class AssociationDetail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.association_detail);


        Bundle bundle = getIntent().getBundleExtra("Association");
        Association asso = bundle.getParcelable("Asso");





        //Button button2 = (Button) findViewById(R.id.button_event);

        //Button button = (Button) findViewById(R.id.button_photos);
    }
}
