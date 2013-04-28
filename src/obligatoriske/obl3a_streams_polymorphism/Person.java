package obligatoriske.obl3a_streams_polymorphism;

import java.io.Serializable;

public class Person implements Serializable {
	// Computed by Eclipse
	private static final long serialVersionUID = 1496596682686812814L;
	
	private int id;
	private double salary;
	private String name;

	public Person(int id, double salery, String name) {

		this.name = name;
		this.id = id;
		this.salary = salery;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", salery=" + salary + ", name=" + name + "]";
	}
}
