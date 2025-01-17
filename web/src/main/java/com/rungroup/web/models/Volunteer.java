package com.rungroup.web.models;

import java.util.List;

import com.rungroup.web.repositories.Implementations.VolunteerRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Volunteer")
public class Volunteer extends User {

  // private List<String> skills;
  private String skills;
  private Boolean availability;

  // public Volunteer(){
  //   super();
  // }   

  public Volunteer(String name, String email, String password,List<String> skills,boolean availability) {
      super(name, email, password);
      setSkills(skills);
      this.availability=availability;
  
  }

  // Getters and setters
  public List<String> getSkills() {
    if (skills != null && skills != "" ){
      return List.of(skills.split(","));
    }
    return null;
  }

  public void setSkills(List<String> skills) {
      this.skills = String.join(",", skills);
  }


  // // Getters and setters
  // public String getName() {
  //     return name;
  // }
  // public void setId(Long id){
  //     this.id=id;
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
  @Override
  public String getRole() {
      return "Volunteer";
  }
  @Override
  public boolean delete(){
    return new VolunteerRepository().deleteById(this.id);
  }

}

