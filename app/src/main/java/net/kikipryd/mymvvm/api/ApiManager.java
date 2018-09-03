package net.kikipryd.mymvvm.api;

import retrofit2.Call;

public class ApiManager {

    private ApiService apiService;

    public ApiManager(ApiService apiService) {
        this.apiService = apiService;
    }

    public Call<Object> getQuestions() {
        return apiService.getQuestion();
    }
}
