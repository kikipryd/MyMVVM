package net.kikipryd.mymvvm.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("questions")
    Call<Object> getQuestion();

}
