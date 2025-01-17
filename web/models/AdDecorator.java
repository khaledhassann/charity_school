package com.rungroup.web.models;

public abstract class AdDecorator extends Advertisement {
    public abstract String getDescription();

    @Override
    public abstract String showAdString();



}
