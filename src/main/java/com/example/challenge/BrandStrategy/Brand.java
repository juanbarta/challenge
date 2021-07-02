package com.example.challenge.BrandStrategy;

public abstract class Brand {
    private String name = null;

    public abstract double getServiceRate();

    public String getName() {
        return name;
    }

    protected void setName(String _nombre) {
        name = _nombre;
    }
}
