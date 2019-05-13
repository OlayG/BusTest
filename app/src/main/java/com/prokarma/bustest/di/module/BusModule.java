package com.prokarma.bustest.di.module;

import com.prokarma.bustest.bus.PlayerResponseBus;
import com.prokarma.bustest.bus.RxBus;
import com.prokarma.bustest.bus.RxBusChum;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BusModule {
    @Singleton
    @Provides
    PlayerResponseBus providesPlayerResponseBus() {
        return new PlayerResponseBus();
    }

    @Singleton
    @Provides
    RxBus providesRxBus() {
        return new RxBus();
    }
    @Singleton
    @Provides
    RxBusChum providesRxBusCHUM() {
        return new RxBusChum();
    }

}
