package com.prokarma.bustest.event;

public enum CHUM {
    INTENT(1),
    CONFIGURATIONS(2),
    REPORT(3),
    ANALYTICS(4);

    private final int value;

    CHUM(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
