package net.kikipryd.mymvvm.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ApiCallback<RESPONSE> implements Callback<RESPONSE> {

    @Override
    public void onResponse(Call<RESPONSE> call, Response<RESPONSE> response) {
        onResponse(response);
    }

    @Override
    public void onFailure(Call<RESPONSE> call, Throwable throwable) {
        onFailure(throwable.toString());
    }

    public abstract void onResponse(Response response);

    public abstract void onFailure(String message);
}
