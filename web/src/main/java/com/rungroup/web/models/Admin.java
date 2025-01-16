package com.rungroup.web.models;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import lombok.Data;

import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@Table(name = "Admin")
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String name, String email, String password) {
       super(name, email, password);
    }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // @Override
    // public String toString() {
    //     return "Admin{" +
    //             "id=" + id +
    //             ", name='" + name + '\'' +
    //             ", email='" + email + '\'' +
    //             '}';
    // }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Admin admin = (Admin) o;
    //     return Objects.equals(id, admin.id);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id);
    // }
    @Override
    public String getRole() {
        return "Admin";
    }
}
