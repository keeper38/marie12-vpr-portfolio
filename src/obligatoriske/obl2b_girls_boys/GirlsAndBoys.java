// Opg i. Tilpas package til eget projekt
// Done. But might refactor later.
package obligatoriske.obl2b_girls_boys;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author erso
 */
public class GirlsAndBoys {
	public static final String girlFileName = "girlnames.txt";
	public static final String boyFileName = "boynames.txt";
	TextBox txtOutput;
	
	private Map<String, Integer> girlMap;
	
	public GirlsAndBoys(TextBox panelText) {
		this.txtOutput = panelText;
		// opg ii
		girlMap = new HashMap<String, Integer>(); // Hvilken implementation af Map? - HashMap - not sorted
		
		// opg iii
		// Abolished this barbaric use of stdout in a GUI-application
		readGirlFiles(girlFileName);
		this.txtOutput.addLine("Girls:\n" + girlMap);
		//System.out.println("Girls:\n" + girlMap);
		
		this.txtOutput.addLine("\n****************************************************\n");
		//System.out.println("\n****************************************************\n");
		
		// opg iv
		Map<Integer, String> commonMap = findCommonNames(boyFileName);
		this.txtOutput.addLine("Common:\n" + commonMap);
		//System.out.println("Common:\n" + commonMap);
		
		this.txtOutput.addLine("\n****************************************************\n");
		//System.out.println("\n****************************************************\n");
		
		// opg v
		this.txtOutput.addLine("Nice print:\n" + map2string(commonMap));
		//System.out.println("Nice print:\n" + map2string(commonMap));
	}
	
	public void readGirlFiles(String girlFName) {
		Scanner girlScanner = null;
		try {
			girlScanner = new Scanner(new File(girlFName));
			String currentGirlName[];
			while (girlScanner.hasNextLine()) {
				// Indsaet navn som key og antal som value (heltal) i mappen
				currentGirlName = girlScanner.nextLine().split(" ");
				girlMap.put(currentGirlName[0], Integer.decode(currentGirlName[1]));
			}
			// System.out.println(girlMap);
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		finally {
			girlScanner.close();
		}
	}
	
	public Map<Integer, String> findCommonNames(String boyFName) {
		Map<Integer, String> commonMap = new TreeMap<Integer, String>(); // Hvilken implementation af Map? - TreeMap - Sorted
		Scanner boyScanner = null;
		try {
			boyScanner = new Scanner(new File(boyFName));
			int boyNumber;
			String currentBoyName[];
			while (boyScanner.hasNextLine()) {
				currentBoyName = boyScanner.nextLine().split(" ");
				boyNumber = Integer.decode(currentBoyName[1]);
				Integer girlNumber = girlMap.get(currentBoyName[0]);
				if (girlNumber != null) {
					commonMap.put((girlNumber + boyNumber), currentBoyName[0]);
				}
				// Undersoeg om navnet findes i girlMap
				// Hvis det findes, adderes antallet af drenge med antallet af piger
				// resultatet indsaettes som key i commomMap med navn som vaerdi
			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		finally {
			boyScanner.close();
		}
		
		return commonMap;
	}
	
	private String map2string(Map<?, ?> map) {
		StringBuilder sb = new StringBuilder();
		for (Object bla:map.keySet()) {
			sb.append(bla.toString() + ":" + map.get(bla) + "\n");
		}
		// Benyt sb til at danne en String, hvor hvert (key, value)-par fra map
		// optraeder paa en linje for sig selv.
		// Se side 649 - 650 i BigJava for gennemloeb af mappen
		
		return sb.toString();
	}
}
