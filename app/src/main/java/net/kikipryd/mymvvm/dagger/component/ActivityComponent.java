package net.kikipryd.mymvvm.dagger.component;

import net.kikipryd.mymvvm.dagger.module.NetworkModule;
import net.kikipryd.mymvvm.feature.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
