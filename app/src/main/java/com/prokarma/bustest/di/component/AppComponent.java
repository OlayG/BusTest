package com.prokarma.bustest.di.component;


import com.prokarma.bustest.App;
import com.prokarma.bustest.di.module.AppModule;
import com.prokarma.bustest.di.module.BusModule;
import com.prokarma.bustest.view.MainActivity;
import com.prokarma.bustest.view.RxBusExampleActivity;
import com.prokarma.bustest.view.fragment.ExampleFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        BusModule.class,})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App app);

        AppComponent build();

    }

    void inject(MainActivity mainActivity);

    void inject(RxBusExampleActivity rxBusExampleActivity);

    void inject(ExampleFragment exampleFragment);

}
