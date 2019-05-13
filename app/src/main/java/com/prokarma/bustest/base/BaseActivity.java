package com.prokarma.bustest.base;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends AppCompatActivity {
    protected final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
