
// It's not necessary to modify this file for assignment 3

public class Student{
	private String name;
	private int age;
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	
	public String toString(){
		String s = name + ":" + Integer.toString(age);
		return s;
		
	}
}
