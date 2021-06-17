package com.example.nogs.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/v1/user/login")
    Call<User> getUserByLogin(@Query("email") String email, @Query("password") String password);

    @GET("api/v1/category/list")
    Call<List<Category>> getCategories();

    @GET("api/v1/ong/list")
    Call<List<Ong>> getOngs();

    @GET("api/v1/donation/list")
    Call<List<Donation>> getDonations();

    @POST("api/v1/donation")
    Call<Donation> createDonation(@Body Donation donation);
}


