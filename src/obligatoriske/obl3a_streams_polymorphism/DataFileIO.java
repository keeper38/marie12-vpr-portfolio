package obligatoriske.obl3a_streams_polymorphism;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileIO implements FileIOInterface {

	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(FileIOInterface.DATA_FILE_NAME, true);
			dos = new DataOutputStream(fos);
			dos.writeInt(person.getId());
			dos.writeDouble(person.getSalary());
			dos.writeUTF(person.getName());
			dos.flush();
		}
		catch (FileNotFoundException ex) {
			// TODO: Better error text
			System.err.println("404");
		}
		catch (IOException ex2) {
			// TODO: Better error text
			System.err.println("Error text here");
		}
		finally {
			try {
				dos.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Person> getPersonList() {
		ArrayList<Person> perslist = new ArrayList<Person>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream(DATA_FILE_NAME);
			dis = new DataInputStream(fis);
			
			while (true) {
				perslist.add(new Person(dis.readInt(), dis.readDouble(), dis.readUTF()));
			}
		}
		catch (FileNotFoundException ex) {
			// TODO: Better error text
			System.err.println("404");
		}
		catch (EOFException ex3) {
			// EOF
			// We are actually supposed to end up here
		}
		catch (IOException ex2) {
			// TODO: Better error text
			System.err.println("Somethine went wrong");
		}
		finally {
			try {
				// Try Hard.
				dis.close();
			}
			catch (IOException exx) {
				
			}
		}
		return perslist;
	}

}
