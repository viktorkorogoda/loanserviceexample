package com.vk.loanserviceexample.domain.entity;

public enum LoanStatus {
    DEBT(0),
    SEGMENT_1(100),
    SEGMENT_2(300),
    SEGMENT_3(1000);

    LoanStatus(Integer creditModifier) {
        this.creditModifier = creditModifier;
    }

    private final Integer creditModifier;

    public Integer getCreditModifier() {
        return creditModifier;
    }
}
