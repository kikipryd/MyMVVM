package net.kikipryd.mymvvm.viewmodel.main;

import net.kikipryd.mymvvm.api.ApiCallback;
import net.kikipryd.mymvvm.api.ApiManager;
import net.kikipryd.mymvvm.dagger.component.ViewModelComponent;
import net.kikipryd.mymvvm.model.MainModel;
import net.kikipryd.mymvvm.viewmodel.BaseViewModel;

import javax.inject.Inject;

import retrofit2.Response;

public class MainViewModel extends BaseViewModel<MainViewModel.Callback> {

    @Inject
    ApiManager apiManager;

    private MainModel mainModel;

    @Override
    protected void injectPresenterComponent(ViewModelComponent viewModelComponent) {
        viewModelComponent.inject(this);
    }

    public void getQuestions() {
        callback.onLoading();
        apiManager.getQuestions().enqueue(new ApiCallback<Object>() {
            @Override
            public void onResponse(Response response) {
                callback.onResponse(response);
            }

            @Override
            public void onFailure(String message) {
                callback.onFailure(message);
            }
        });
    }

    public MainModel getMainModel() {
        return mainModel;
    }

    public void setMainModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public interface Callback extends BaseViewModel.BaseCallback {
        void onLoading();

        void onResponse(Response response);

        void onFailure(String message);
    }
}
