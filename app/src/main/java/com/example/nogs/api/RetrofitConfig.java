package com.example.nogs.api;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    public Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.15.37:8000/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
    }

    public Call<User> getUserFromLogin(String email, String password) {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<User> response = apiService.getUserByLogin(email, password);

        return response;
    }

    public Call<List<Category>> getCategories() {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Category>> response = apiService.getCategories();

        return response;
    }

    public Call<List<Ong>> getOngs() {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Ong>> response = apiService.getOngs();

        return response;
    }

    public Call<List<Donation>> getDonations() {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Donation>> response = apiService.getDonations();

        return response;
    }

    public Call<Donation> createDonation(Donation donation) {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Donation> response = apiService.createDonation(donation);

        return response;
    }
}