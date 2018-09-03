package net.kikipryd.mymvvm;

import android.app.Application;
import android.content.Context;

import net.kikipryd.mymvvm.dagger.component.ActivityComponent;
import net.kikipryd.mymvvm.dagger.component.DaggerActivityComponent;
import net.kikipryd.mymvvm.dagger.component.DaggerViewModelComponent;
import net.kikipryd.mymvvm.dagger.component.ViewModelComponent;
import net.kikipryd.mymvvm.dagger.module.NetworkModule;

public class App extends Application {

    private static Context context;
    private static NetworkModule networkModule;
    private static ActivityComponent activityComponent;
    private static ViewModelComponent viewModelComponent;

    public static Context getContext() {
        return context;
    }

    public static ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public static ViewModelComponent getViewModelComponent() {
        return viewModelComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        networkModule = new NetworkModule();

        activityComponent = DaggerActivityComponent.builder()
                .networkModule(networkModule)
                .build();

        viewModelComponent = DaggerViewModelComponent.builder()
                .networkModule(networkModule)
                .build();
    }
}
