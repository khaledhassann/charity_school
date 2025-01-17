package com.rungroup.web.models;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class AdDecorator extends Advertisement {
    public abstract String getDescription();

    @Override
    public abstract String showAdString();

}