package project_1;

import java.io.Serializable;

public class Student implements Serializable {
  private static final long serialVersionUID = 1L;
  
  String userId;
  String password;
  String name;
  String email;
  String tel;
  boolean working;
  int birthYear;
  String school;
  
  public Student() {};
  
  public Student(String userId, String password, String name, String tel) {
    this.userId = userId;
    this.password = password;
    this.name = name;
    this.tel = tel;
  }
  
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
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
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public boolean isWorking() {
    return working;
  }
  public void setWorking(boolean working) {
    this.working = working;
  }
  public int getBirthYear() {
    return birthYear;
  }
  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }
  public String getSchool() {
    return school;
  }
  public void setSchool(String school) {
    this.school = school;
  }
  
  
}
