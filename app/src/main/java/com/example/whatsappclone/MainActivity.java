package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private EditText edtmail,edtuser,edtpass;
private Button btn1;
private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtmail=findViewById(R.id.eid);
       edtpass=findViewById(R.id.pass);
        btn1=findViewById(R.id.sign);
        edtuser=findViewById(R.id.Usrers);
        mTextView=findViewById(R.id.T1);
        btn1.setOnClickListener(this);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish(); 
            }
        });



    }

    @Override
    public void onClick(View view) {
        ParseUser user = new ParseUser();
        // Set the user's username and password, which can be obtained by a forms
        user.setEmail(edtmail.getText().toString());
        user.setUsername(edtuser.getText().toString() );
        user.setPassword( edtpass.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    FancyToast.makeText(MainActivity.this," Signed Up",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();

                    Intent intent=new Intent(MainActivity.this,login.class);
                    startActivity(intent);


                }

                else{
                    Toast.makeText(MainActivity.this, "ERROR"+e.getMessage(), Toast.LENGTH_LONG).show();
                    FancyToast.makeText(MainActivity.this,"ERROR",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                }
            }
        });


    }
}