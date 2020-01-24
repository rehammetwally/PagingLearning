package com.rehammetwally.paginglearning.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DBClient {
    private static Retrofit instance;
    private static final String BASE_URL="https://api.stackexchange.com/2.2/";

    public static Retrofit getInstance(){
        if (instance == null){
            instance=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return instance;
    }
}
