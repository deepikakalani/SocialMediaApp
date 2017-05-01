package com.example.cmpe277.sjsu.socialmediaapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.IOException;

import com.android.volley.*;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.*;
import com.squareup.okhttp.Request;


/**
 * Created by deepika on 4/25/17.
 */

public class Register extends Activity{

    EditText useremail, userpassword;
    Button rbutton;
    String email, password;
    private static final String TAG = Register.class.getName();
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    private String url = "http://www.mocky.io/v2/5907a8ce10000042179bd83f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        rbutton = (Button)findViewById(R.id.rsubmit);
        useremail = (EditText)findViewById(R.id.temail);
        userpassword = (EditText)findViewById(R.id.tpassword);
        //verificationMail();

        rbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //email = useremail.getText().toString();
                //password = userpassword.getText().toString();
                //verificationMail();
                sendRequest();


            }
        });

    }

  /* private void verificationMail() {
        //initialize the httpClient
        OkHttpClient client = new OkHttpClient();

        //initiaize a request
        Request request = new Request.Builder()
                .url("https://us15.api.mailchimp.com/3.0/lists/7a5fc07dd3")
                .build();

        //execute the request
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.i("TAG", e.getMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.i("TAG", response.body().string());
            }
        });
        //System.out.println(response);
    }*/

    public void sendRequest(){

        mRequestQueue = Volley.newRequestQueue(this);

        stringRequest = new StringRequest(com.android.volley.Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, response.toString());
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.i(TAG, "Error: " + error.toString());
            }
        });

        mRequestQueue.add(stringRequest);
    }



}
