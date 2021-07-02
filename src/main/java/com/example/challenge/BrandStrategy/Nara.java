package com.example.challenge.BrandStrategy;

import java.util.Calendar;
import java.util.Date;

public class Nara extends Brand {
    private static final Nara INSTANCE = new Nara();
    private static final double NUMBER = 0.5;

    private Nara() {
        setName("NARA");
    }

    public static Nara getInstance() {
        return INSTANCE;
    }

    @Override
    public double getServiceRate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth * NUMBER;
    }
}
