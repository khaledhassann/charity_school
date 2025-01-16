package com.rungroup.models;

public abstract class User {
    protected Long id;
    protected String name;
    protected String email;
    protected String password;
    // protected String preferred_type;

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        // this.preferred_type=preferred_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public void setPreferredType(String preferred_type){
    //     this.preferred_type=preferred_type;
    // }

    public abstract String getRole();
}
