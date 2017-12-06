package com.example.val.wikint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by alexisblervaque on 24/11/2017.
 */

public class AssociationList extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.association_list);


        Button button = (Button)findViewById(R.id.detail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AssociationDetail.class);
                String idOfButton = ((Button)(view)).getTag().toString();
                i.putExtra("idOfButton",idOfButton);
                i.putExtra("description","Voivi la description faisons un test");
                startActivity(i);
            }
        });
    }
}
