package com.brainybrains.newsdaily.jSON;

import com.brainybrains.newsdaily.fromAPI.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JSONplaceHolder {
    @GET
    Call<List<News>> getNewses(@Url String uil);
}
