package obligatoriske.obl3a_streams_polymorphism;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileIO implements FileIOInterface {

	public void addPerson(Person person) {
		FileWriter fw;
		try {
			fw = new FileWriter(TEXT_FILE_NAME, true);
			fw.write(person.getId() + ";" + person.getSalary() + ";" + person.getName() + "\n");
			fw.close();
		}
		catch (IOException ex) {
			// TODO: Better error text
			System.err.println("Error");
			System.err.println(ex.toString());
		}
	}

	public List<Person> getPersonList() {
		ArrayList<Person> perslist = new ArrayList<Person>();
		String[] curLine;
		Scanner sc;
		try {
			sc = new Scanner(new File(TEXT_FILE_NAME));
			
			while (sc.hasNextLine()) {
				curLine = sc.nextLine().split(";");
				perslist.add(new Person(Integer.parseInt(curLine[0]), Double.parseDouble(curLine[1]), curLine[2]));
			}
			sc.close();
		}
		catch (FileNotFoundException ex) {
			// TODO: Better error text
			System.err.println("404");
		}
		return perslist;
	}

}
