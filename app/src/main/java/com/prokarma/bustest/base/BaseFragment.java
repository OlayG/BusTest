package com.prokarma.bustest.base;

import androidx.fragment.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseFragment extends Fragment {
    protected final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
