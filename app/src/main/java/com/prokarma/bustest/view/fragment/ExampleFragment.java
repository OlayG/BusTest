package com.prokarma.bustest.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.prokarma.bustest.App;
import com.prokarma.bustest.R;
import com.prokarma.bustest.base.BaseFragment;
import com.prokarma.bustest.bus.RxBusChum;
import com.prokarma.bustest.event.CHUM;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleFragment extends BaseFragment {

    @Inject
    RxBusChum rxBusCHUM;

    private TextView tvDisplay;

    public ExampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((App) context.getApplicationContext()).getmAppComponent().inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        tvDisplay = view.findViewById(R.id.tv_display);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        disposable.add(
                rxBusCHUM
                        .toObservable()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<CHUM>() {
                            @Override
                            public void accept(CHUM chum) throws Exception {
                                if (chum.getValue() == 1) {
                                    Toast.makeText(getContext(), "" + chum, Toast.LENGTH_SHORT).show();
                                    tvDisplay.setText(String.format("%s", chum));
                                }
                                if (CHUM.INTENT.equals(chum)) {
                                    Toast.makeText(getContext(), "" + chum, Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
        );
    }
}
