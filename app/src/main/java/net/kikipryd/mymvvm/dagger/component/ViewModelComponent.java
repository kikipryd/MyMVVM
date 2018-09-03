package net.kikipryd.mymvvm.dagger.component;

import net.kikipryd.mymvvm.dagger.module.NetworkModule;
import net.kikipryd.mymvvm.viewmodel.main.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface ViewModelComponent {
    void inject(MainViewModel mainViewModel);
}
