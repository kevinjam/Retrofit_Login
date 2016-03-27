package com.example.kevinjanvier.logintutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.input_username)
    EditText input_username;
    @Bind(R.id.input_password)
    EditText input_password;
    @Bind(R.id.login_btn)
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://kevinjanvier.com")
                        .build();
                LogIn logIn = retrofit.create(LogIn.class);
                Call<LogInResult> reg  = logIn.login(input_username.getText().toString(), input_password.getText().toString());
                reg.enqueue(new Callback<LogInResult>() {
                    @Override
                    public void onResponse(Response<LogInResult> response, Retrofit retrofit) {
                        if (response.body().getCode() == 0){
                        Snackbar.make(input_password, response.body().getName(), Snackbar.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), Dashboard.class).putExtra("info", response.body()));
                        }else{
                            Snackbar.make(input_username, response.body().getMessage(), Snackbar.LENGTH_INDEFINITE).setAction("wron", null).show();
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

            }
        });



    }

}
