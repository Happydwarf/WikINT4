package com.example.alexisblervaque.wikint;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.concurrent.Semaphore;

/**
 * Created by alexisblervaque on 14/12/2017.
 */

public class Login extends BaseActivity {

    private FirebaseAuth mAuth;
    private StorageReference mStorageRef;

    private static final String TAG = "AnonymousAuth";
    private EditText mEmailField;
    private EditText mPasswordField;
    private ProgressDialog progressDialog;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();

        progressDialog = new ProgressDialog(this);


        mEmailField = (EditText) findViewById(R.id.editTextEmail);
        mPasswordField = (EditText) findViewById(R.id.editTextPassword);

        Button button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(mEmailField.getText().toString(),mPasswordField.getText().toString());


                if (mAuth.getCurrentUser() != null) {
                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    startActivity(i);
                }


            }
        });


        Button button_create = (Button) findViewById(R.id.button_create_account);
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(v.getContext(), SignIn.class);
                startActivity(i2);
            }
        });

    }


    private void loginUser(String email, final String password) {
        final Semaphore semaphore = new Semaphore(0);

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful())
                        {
                            Log.d("Connexion","XXXXXXXXXXXXXXXX");
                            semaphore.release();
                        }
                        else{
                            Log.d("Connexion", "Reussi");
                            semaphore.release();
                        }
                    }
                });
    }



}
