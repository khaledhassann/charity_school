package com.rungroup.models;

public class Active extends State {
    @Override
    public void changeState(Assessment assessment) {
        // You can define what happens when transitioning from Active state
        System.out.println("Changing state from Active to Draft");
        assessment.setState(new Draft()); // Transitioning back to Draft as an example
    }

    @Override
    public String toString() {
        return "Active";
    }
}

