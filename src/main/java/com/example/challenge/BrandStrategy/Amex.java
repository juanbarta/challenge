package com.example.challenge.BrandStrategy;

import java.util.Calendar;
import java.util.Date;

public class Amex extends Brand {
    private static final Amex INSTANCE = new Amex();
    private static final double NUMBER = 0.1;

    private Amex() {
        setName("AMEX");
    }

    public static Amex getInstance() {
        return INSTANCE;
    }


    @Override
    public double getServiceRate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        final int month = calendar.get(Calendar.MONTH);
        return month * NUMBER;
    }
}
