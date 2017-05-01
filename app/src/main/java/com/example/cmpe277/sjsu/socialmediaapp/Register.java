package com.example.cmpe277.sjsu.socialmediaapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * Created by deepika on 4/25/17.
 */

public class Register extends Activity{

    EditText useremail, userpassword;
    Button rbutton;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        rbutton = (Button)findViewById(R.id.rsubmit);
        useremail = (EditText)findViewById(R.id.temail);
        userpassword = (EditText)findViewById(R.id.tpassword);

        rbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //email = useremail.getText().toString();
                //password = userpassword.getText().toString();
                verificationMail();
            }
        });

    }

    private void verificationMail() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://us15.api.mailchimp.com/3.0/lists/7a5fc07dd3")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response);
    }


}
