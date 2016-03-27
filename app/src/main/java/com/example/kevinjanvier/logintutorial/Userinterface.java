package com.example.kevinjanvier.logintutorial;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by kevinjanvier on 24/03/16.
 */
public interface Userinterface {
    @FormUrlEncoded
    @POST("stlawrence/login/index.php")
    Call<POJOMessages> login(@Field("name") String email,
                            @Field("password") String password);
}
