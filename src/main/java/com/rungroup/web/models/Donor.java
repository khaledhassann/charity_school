package com.rungroup.web.models;

public class Donor extends User {
    private String preferred_type;
    

public Donor(){}

public Donor(Long id, String name, String email, String password, String preferred_type) {
    super(id, name, email, password);
    this.preferred_type = preferred_type;
}

public String getPreferredType() {
    return preferred_type;
}

public void setPreferredType(String preferred_type) {
    this.preferred_type = preferred_type;
}

    @Override
    public String getRole() {
        return "Donor";
    }

}
