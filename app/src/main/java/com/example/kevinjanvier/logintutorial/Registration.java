package com.example.kevinjanvier.logintutorial;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by kevinjanvier on 27/03/16.
 */
public interface Registration {
    @FormUrlEncoded
    @POST("stlawrence/login/signup.php")
    Call<Results> postRegestraion(@Field("name") String name,
                                  @Field("email") String email,
                                  @Field("password") String password);
}