package com.rehammetwally.paginglearning.data.repository;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.rehammetwally.paginglearning.data.api.API;
import com.rehammetwally.paginglearning.data.api.DBClient;
import com.rehammetwally.paginglearning.data.model.Item;
import com.rehammetwally.paginglearning.data.model.StackApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Item> {
    public static final int PAGE_SIZE = 50;
    public static final int FIRST_PAGE = 1;
    public static final String SITE_NAME = "stackoverflow";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {
        DBClient.getInstance()
                .create(API.class)
                .getAnswers(FIRST_PAGE, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if (response.body() != null)
                            callback.onResult(response.body().getItems(), null, FIRST_PAGE + 1);
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {
                        callback.onError(t);
                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        DBClient.getInstance()
                .create(API.class)
                .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if (response.body() != null) {
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            callback.onResult(response.body().getItems(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {
                        callback.onError(t);
                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        DBClient.getInstance()
                .create(API.class)
                .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackApiResponse>() {
                    @Override
                    public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
                        if (response.body() != null) {
                            Integer key = response.body().getHasMore() ? params.key + 1 : null;
                            callback.onResult(response.body().getItems(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResponse> call, Throwable t) {
                        callback.onError(t);
                    }
                });
    }
}
