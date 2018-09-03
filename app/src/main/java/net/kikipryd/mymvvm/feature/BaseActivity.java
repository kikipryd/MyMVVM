package net.kikipryd.mymvvm.feature;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import net.kikipryd.mymvvm.App;
import net.kikipryd.mymvvm.dagger.component.ActivityComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected Context context;
    protected Bundle bundle;
    private Unbinder unbinder;

    protected void launchActivity(Context context, Class<?> classActivity, Bundle bundle) {
        Intent intent = new Intent(context, classActivity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    protected void launchActivity(Context context, Class<?> classActivity) {
        launchActivity(context, classActivity, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        unbinder = ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        context = this;
        injectActivityComponent(App.getActivityComponent());
        initViewModel(ViewModelProviders.of(this));
        initData();
        attachData();
    }

    protected abstract int getContentView();

    protected abstract void injectActivityComponent(ActivityComponent activityComponent);

    protected abstract void initViewModel(ViewModelProvider viewModelProvider);

    protected abstract void initData();

    protected abstract void attachData();

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    protected void showMessage(String message) {
        AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.setMessage(message);
        dialog.show();
    }
}
