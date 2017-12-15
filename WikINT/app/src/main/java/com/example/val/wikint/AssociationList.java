package com.example.val.wikint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.Gravity;
=======
import android.support.annotation.Nullable;
>>>>>>> e1176cdd19d1a3c6e175a0f240a9d6d4fe2bb19a
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
<<<<<<< HEAD
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
=======
>>>>>>> e1176cdd19d1a3c6e175a0f240a9d6d4fe2bb19a

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
