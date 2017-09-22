package project_1.etc;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String userId;
  protected String name;
  protected int age;
  protected boolean working;
  
  public Student() {
  	this("무명");
  }
  public Student(String name) {
    this.name = name;
  }
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isWorking() {
		return working;
	}
	public void setWorking(boolean working) {
		this.working = working;
	}
}
