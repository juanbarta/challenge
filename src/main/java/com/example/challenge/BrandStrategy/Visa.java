package com.example.challenge.BrandStrategy;

import java.util.Calendar;
import java.util.Date;

public class Visa extends Brand {
    private static final Visa INSTANCE = new Visa();

    private Visa() {
        setName("VISA");
    }

    public static Visa getInstance() {
        return INSTANCE;
    }

    @Override
    public double getServiceRate() {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        final double year = calendar.get(Calendar.YEAR) % 100;
        final double month = calendar.get(Calendar.MONTH);
        return year / month;
    }
}
