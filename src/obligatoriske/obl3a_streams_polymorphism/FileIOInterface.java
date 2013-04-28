package obligatoriske.obl3a_streams_polymorphism;

import java.util.List;

public interface FileIOInterface {
	public static final String TEXT_FILE_NAME = "Persons.txt";
	public static final String DATA_FILE_NAME = "Persons.dat";
	public static final String OBJECT_FILE_NAME = "Persons.obj";
	
	void addPerson(Person person);
	List<Person> getPersonList();

}
