package com.rungroup.web.models;

public class Donor extends User {
    private String preferredType;
    

public Donor(){}

public Donor(Long id, String name, String email, String password, String preferredType) {
    super(id, name, email, password);
    this.preferredType = preferredType;
}

public String getPreferredType() {
    return preferredType;
}

public void setPreferredType(String preferredType) {
    this.preferredType = preferredType;
}

    @Override
    public String getRole() {
        return "Donor";
    }

}
