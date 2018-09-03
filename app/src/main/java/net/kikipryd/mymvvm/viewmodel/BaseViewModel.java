package net.kikipryd.mymvvm.viewmodel;

import android.arch.lifecycle.ViewModel;

import net.kikipryd.mymvvm.App;
import net.kikipryd.mymvvm.dagger.component.ViewModelComponent;

public abstract class BaseViewModel<CALLBACK extends BaseViewModel.BaseCallback> extends ViewModel {

    protected CALLBACK callback;

    public BaseViewModel() {
        injectPresenterComponent(App.getViewModelComponent());
    }

    protected abstract void injectPresenterComponent(ViewModelComponent viewModelComponent);

    public void attchView(CALLBACK callback) {
        this.callback = callback;
    }

    public void detachView() {
        callback = null;
    }

    public interface BaseCallback {
    }
}
