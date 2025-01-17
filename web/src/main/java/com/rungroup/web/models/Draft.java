package com.rungroup.web.models;

public class Draft extends State {
    @Override
    public void changeState(Assessment assessment) {
        // Transitioning to Active state
        System.out.println("Changing state from Draft to Active");
        assessment.setState(new Active());
    }

    @Override
    public String toString() {
        return "Draft";
    }
}
