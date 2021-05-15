package com.personalprojects.shaddiapplication;

import com.personalprojects.shaddiapplication.pojo.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("/api/?results")
    Call<Root> loadCards();
}
