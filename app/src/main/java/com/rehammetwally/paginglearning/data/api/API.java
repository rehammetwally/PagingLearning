package com.rehammetwally.paginglearning.data.api;

import com.rehammetwally.paginglearning.data.model.StackApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface API {
    @GET("answers")
    Call<StackApiResponse> getAnswers(
            @Query("page") int page,
            @Query("pagesize") int pagesize,
//            @Query("order") String order,
//            @Query("sort") String sort,
            @Query("site") String site
    );
}
