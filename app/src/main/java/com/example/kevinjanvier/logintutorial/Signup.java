package com.example.kevinjanvier.logintutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Signup extends AppCompatActivity {

    @Bind(R.id.btn_signup)
    Button btn_signup;
    @Bind(R.id.input_name)
    EditText input_name;
    @Bind(R.id.input_email) EditText input_email;
    @Bind(R.id.input_password) EditText input_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);



        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit =new Retrofit.Builder()
                        .baseUrl("http://kevinjanvier.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Registration registration = retrofit.create(Registration.class);
                Call<Results> reg = registration.postRegestraion(input_name.getText().toString(), input_email.getText().toString(), input_password.getText().toString());
                reg.enqueue(new Callback<Results>() {
                    @Override
                    public void onResponse(Response<Results> response, Retrofit retrofit) {
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Signup.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });


            }
        });


    }
}
