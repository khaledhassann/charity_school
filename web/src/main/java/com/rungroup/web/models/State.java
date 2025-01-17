package com.rungroup.web.models;

public abstract class State {
    public abstract void changeState(Assessment assessment);
    public abstract String toString();
}
