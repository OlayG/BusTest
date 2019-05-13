package com.prokarma.bustest.bus;

import com.prokarma.bustest.event.CHUM;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * This bus takes CHUM enum as its flag
 */
public class RxBusChum {

    private static final PublishSubject<CHUM> bus = PublishSubject.create();

    public RxBusChum() {
    }

    public void send(CHUM chum) {
        bus.onNext(chum);
    }

    public Observable<CHUM> toObservable() {
        return bus;
    }
}
