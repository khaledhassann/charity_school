package com.rungroup.models;




public abstract class VerbDetails {
    private User user;
    private Object target;
    private Verb verb;
    //private LocalDateTime interactionDate;

    // Constructor
    public VerbDetails(User user, Object target, Verb verb) {
        this.user = user;
        this.target = target;
        this.verb = verb;
        
    }

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Verb getVerb() {
        return verb;
    }

    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    
}
