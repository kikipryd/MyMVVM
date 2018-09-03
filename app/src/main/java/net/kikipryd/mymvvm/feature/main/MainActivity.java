package net.kikipryd.mymvvm.feature.main;

import android.arch.lifecycle.ViewModelProvider;
import android.view.View;
import android.widget.TextView;

import net.kikipryd.mymvvm.R;
import net.kikipryd.mymvvm.dagger.component.ActivityComponent;
import net.kikipryd.mymvvm.feature.BaseActivity;
import net.kikipryd.mymvvm.model.MainModel;
import net.kikipryd.mymvvm.viewmodel.main.MainViewModel;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements MainViewModel.Callback {

    private MainViewModel mainViewModel;

    @Override
    protected void injectActivityComponent(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        mainViewModel.detachView();
        super.onDestroy();
    }

    @Override
    protected void initViewModel(ViewModelProvider viewModelProvider) {
        mainViewModel = viewModelProvider.get(MainViewModel.class);
        mainViewModel.attchView(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void attachData() {
    }

    @OnClick({
    })
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
        }
    }

    @Override
    public void onLoading() {
    }

    @Override
    public void onResponse(Response response) {
    }

    @Override
    public void onFailure(String message) {
    }
}
