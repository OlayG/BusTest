package com.prokarma.bustest.bus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * This bus can take multiple event objects
 */
public class RxBus {

    private final PublishSubject<Object> bus = PublishSubject.create();

    public RxBus() {
    }

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public boolean hasObserver() {
        return bus.hasObservers();
    }
}
