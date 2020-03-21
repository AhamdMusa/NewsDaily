package com.brainybrains.newsdaily.jSON;


import com.brainybrains.newsdaily.fromAPI.News;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JSONplaceHolder {
    @GET("everything?q=coronavirus&language=en&from=2020-02-20&sortBy=publishedAt&apiKey=85f7a4bf8b714e4dbab47ec7bc08ae61")
    Call <News> getNewses();
}