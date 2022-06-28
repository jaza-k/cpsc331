// JAZA KHAN UCID 30119100
// CPSC 331 S22 Assignment 3
// Tutorial 03
 
import java.util.LinkedList;

/**
 * HashTable class that includes methods to manipulate and work with a hash table
 * @author Jaza K.
 */
public class HashTable {
	private LinkedList<Student> arr[];
	public static final int LEN = 8;

	/**
	 * Constructor method initializes array of type LinkedList with length LEN
	 * Each element of the array is initialized to a LinkedList of type Student
	 */
	public HashTable(){
		arr = new LinkedList[LEN];
		for (int i = 0; i < LEN; i++){
			arr[i] = new LinkedList<Student>();
		}
	}
	
	/**
	 * hashValue() method
	 * 
	 * Precondition:  s is a string composed only of alpanumeric characters
	 * Postcondition: The sum of the ASCII values of s modulo LEN is returned
	 * 
	 * @param s String to be hashed
	 * @return sum of ASCII values of s modulo LEN
	 */
	public int hashValue(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++){
			sum += s.charAt(i);
		}
		return sum % LEN;
	}

	/** 
	 * search() method
	 * 
	 * Precondition:  name is a string composed only of alpanumeric characters
	 * Postcondition: If the hash table contains a Student with the given name, return true. Otherwise, return false
	 * 
	 * @param name The Student name to be searched for
	 * @return True if the Student is found, false otherwise
	 */
	public boolean search(String name) {
		int i = hashValue(name);
		for (Student student : arr[i]){
			if (student.getName().equals(name)){
				return true;
			}
		}
		return false;
	}

	/**
	 * insert() method
	 * 
	 * Precondition:  name is a string composed of alphanumeric characters and age is a positive integer
	 * Postcondition: If the hash table does not contain a Student of this name, then a Student with attributes 
	 * name and age is added to the appropriate linked list in the hash table. If a Student of this name is already 
	 * in the hash table, then this Student has their age updated to the inputted age. Additionally, a message is 
	 * printed indicating that a student is being inserted and their name and age.
	 * 
	 * @param name The Student name to be inserted
	 * @param age The Student age to be inserted
	 */
	public void insert(String name, int age) {
		int i = hashValue(name);
		for (Student student : arr[i]){
			if (student.getName().equals(name)){
				student.setAge(age);
				System.out.println("Student " + name + "'s age was updated to: " + age);
				return;
			}
		}
		arr[i].add(new Student(name, age));
		System.out.println("Student " + name + " was inserted with age: " + age);
	}

	/**
	 * delete() method
	 * 
	 * Precondition:  name is a string composed of alphanumeric characters
	 * Postcondition: If the hash table contains a student with the given name, then the Student is removed from the
	 * hash table. Otherwise, a message is printed indicating that the Student was not found.
	 * 
	 * @param name The name of Student to be removed
	 */
	public void delete(String name) {
		int i = hashValue(name);
		for (Student student : arr[i]) {
			if (student.getName().equals(name)){
				arr[i].remove(student);
				System.out.println("Student " + name + " was removed");
				return;
			}
		}
		System.out.println("Student " + name + " does not exist in hash table");
	}

	/**
	 * getAge() method
	 * 
	 * Precondition:  name is a string composed of alphanumeric characters
	 * Postcondition: If the hash table contains a Student with this name, then this student’s age is returned. Otherwise, 
	 * a message is printed indicating that no student of this name was found in the hash table and the value -1 is returned
	 * 
	 * @param name The Student name to be searched for
	 * @return The age of the student if found, -1 otherwise
	 */
	public int getAge(String name) {
		int i = hashValue(name);
		for (Student student : arr[i]){
			if (student.getName().equals(name)){
				return student.getAge();
			}
		}
		System.out.println("Student " + name + " does not exist in hash table");
		return -1;
	}

	/**
	 * increment() method
	 * 
	 * Precondition:  name is a string composed of alphanumeric characters
	 * Postcondition: If the hash table contains a Student with this name, then this student’s age is incremented 
	 * by 1 and a message is printed to indicate this. Otherwise, a message is printed indicating that no student 
	 * of this name was found in the hash table
	 * 
	 * @param name the name of the Student
	 */
	public void increment(String name) {
		int i = hashValue(name);
		for (Student student : arr[i]){
			if (student.getName().equals(name)){
				student.setAge(student.getAge() + 1);
				System.out.println("Student " + name + "'s age was incremented by 1");
				return;
			}
		}
		System.out.println("Student " + name + " does not exist in hash table");
	}

	/**
	 * toString() method
	 * 
	 * Precondition:  arr is an array of LinkedList of Student
	 * Postcondition: A string representation of the array is returned with the specified format
	 * 
	 * @return A string representation of the array
	 */
	public String toString() {
		// Hint: It’s intended that you use the built-in toString()
		// for LinkedList, which will implicitly call the toString()
		// for Student, which has already been implemented.
	
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arr.length; i++){
			result.append(i + ": " + arr[i].toString());
			result.append("\n");
		}
		return result.toString();

	}
}
