//Driver to test functionality of HashTable
//See comment at the end for expected results
public class Driver{

	public static void main(String[] args){
		HashTable h = new HashTable();

		//hashValue()
		System.out.println("Hash value of 'cat' is " + h.hashValue("cat"));	
		System.out.println("Hash value of 'dog' is " + h.hashValue("dog"));	
		
		//Insert names
		h.insert("Ahmad", 25);
		h.insert("Bob", 20);
		h.insert("Cathy", 15);
		h.insert("Desmond", 20);
		h.insert("Desmond", 15);
		h.insert("Emily", 10);
		
		//Search for names
		System.out.println(h.search("Ahmad"));
		System.out.println(h.search("Ali"));
		System.out.println(h.search("Bob"));
		System.out.println(h.search("Cathy"));
		System.out.println(h.search("Catherine"));
		System.out.println(h.search("Desmond"));
		System.out.println(h.search("Emily"));

		
		//Remove names
		h.delete("Emily");
		h.delete("Cathy");
		System.out.println(h.search("Ahmad"));
		System.out.println(h.search("Ali"));
		System.out.println(h.search("Bob"));
		System.out.println(h.search("Cathy"));
		System.out.println(h.search("Catherine"));
		System.out.println(h.search("Desmond"));
		System.out.println(h.search("Emily"));


		//getAge()
		System.out.println("Ahmad's age: " + h.getAge("Ahmad"));
		System.out.println("Bob's age: " + h.getAge("Bob"));
		System.out.println("Desmond's age: " + h.getAge("Desmond"));

		//increment()
		h.increment("Desmond");
		System.out.println("Desmond's age: " + h.getAge("Desmond"));

		//toString()
		System.out.println(h);


	}
}
/*
Below is an example output. Your output may have different 
wording, but most of the information should be similar.

Hash value of 'cat' is 0
Hash value of 'dog' is 2
Inserting student Ahmad, age 25      
Inserting student Bob, age 20        
Inserting student Cathy, age 15      
Inserting student Desmond, age 20    
Changing age of Desmond from 20 to 15
Inserting student Emily, age 10      
true
false
true
true
false
true
true
Removing student Emily, age 10       
Removing student Cathy, age 15       
true
false
true
false
false
true
false
Ahmad's age: 25
Bob's age: 20
Desmond's age: 15
Changing age of Desmond from 15 to 16
Desmond's age: 16
0: []
1: []
2: [Desmond:16]
3: [Bob:20, Ahmad:25]
4: []
5: []
6: []
7: []

*/