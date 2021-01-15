package cse3040ex1904;

import java.util.HashSet;

class Person {
	String name;
	int age;
	Person(String name, int age) { this.name = name; this.age = age; }
	public String toString() { return name + ":" + age; }
}

public class Ex19_04 {
	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<>();
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));
		System.out.println(set);
	}
}
