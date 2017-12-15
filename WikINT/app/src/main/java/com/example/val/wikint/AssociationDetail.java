package com.example.val.wikint;

import android.app.Activity;
import android.os.Bundle;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

=======
import android.support.annotation.Nullable;
import android.widget.TextView;

import org.w3c.dom.Text;

>>>>>>> e1176cdd19d1a3c6e175a0f240a9d6d4fe2bb19a
/**
 * Created by alexisblervaque on 24/11/2017.
 */

public class AssociationDetail extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.association_detail_layout);

        TextView description = (TextView)findViewById(R.id.description);


        description.setText(getIntent().getStringExtra("description"));

    }
}
