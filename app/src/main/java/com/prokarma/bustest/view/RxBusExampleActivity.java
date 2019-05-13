package com.prokarma.bustest.view;

import android.os.Bundle;
import android.view.View;

import com.prokarma.bustest.App;
import com.prokarma.bustest.R;
import com.prokarma.bustest.base.BaseActivity;
import com.prokarma.bustest.bus.RxBus;
import com.prokarma.bustest.bus.RxBusChum;
import com.prokarma.bustest.event.CHUM;

import javax.inject.Inject;

public class RxBusExampleActivity extends BaseActivity implements View.OnClickListener {

    @Inject
    RxBus rxBus;
    @Inject
    RxBusChum rxBusCHUM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus_example);
        ((App) getApplicationContext()).getmAppComponent().inject(this);
        initViews();

    }

    private void initViews() {
        findViewById(R.id.btn_intent).setOnClickListener(this);
        findViewById(R.id.btn_configuration).setOnClickListener(this);
        findViewById(R.id.btn_report).setOnClickListener(this);
        findViewById(R.id.btn_analytics).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_intent:
                rxBusCHUM.send(CHUM.INTENT);
                break;
            case R.id.btn_configuration:
                rxBusCHUM.send(CHUM.CONFIGURATIONS);
                break;
            case R.id.btn_report:
                rxBusCHUM.send(CHUM.REPORT);
                break;
            case R.id.btn_analytics:
                rxBusCHUM.send(CHUM.ANALYTICS);
                break;
        }
    }
}
