package com.example.whatsappclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class login extends AppCompatActivity  {
    private EditText E1,E2;
    private Button n1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        E1=findViewById(R.id.logu);
        E2=findViewById(R.id.logp);
        n1=findViewById(R.id.login);
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();
                ProgressDialog progressDialog = new ProgressDialog(login.this);
                progressDialog.setMessage("Logging in");
                progressDialog.show();


                user.logInInBackground(E1.getText().toString(), E2.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null && e == null) {
                            progressDialog.dismiss();
                            FancyToast.makeText(login.this, user.getUsername() + " is Logged in suceessfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                            Intent intent=new Intent(login.this,Users.class);
                            startActivity(intent);

                        } else {
                            FancyToast.makeText(login.this, "ERROR", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                        }
                    }
                });
            }
        });

    }



}