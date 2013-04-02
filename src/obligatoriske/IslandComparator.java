package obligatoriske;

import java.util.Comparator;

public class IslandComparator implements Comparator<DanishIsland> {

	// Modes to determine on which value to compare
	public static final int COMPARE_NAME = 0;
	public static final int COMPARE_CIRCUMFERENCE = 1;
	public static final int COMPARE_AREA = 2;
	public static final int COMPARE_ADDRESSTOTAL = 3;
	public static final int COMPARE_ADDRESSDENSITY = 4;
	
	private int mode;
	
	public IslandComparator(int mode) {
		this.setComparemode(mode);
	}
	
	public int compare(DanishIsland o1, DanishIsland o2) {
		int diff;
		
		switch (this.mode) {
		case COMPARE_NAME:
			break;
			
		case COMPARE_CIRCUMFERENCE:
			if (o1.getCircumference() > o2.getCircumference()) diff = 1;
			else if(o1.getCircumference() < o2.getCircumference()) diff = -1;
			else diff = 0;
			break;
			
		case COMPARE_AREA:
			break;
			
		case COMPARE_ADDRESSTOTAL:
			break;
			
		case COMPARE_ADDRESSDENSITY:
			break;

		default:
			System.err.println("Error: Unrecognized mode of comparason");
			break;
		}
		
		return 0;
	}

	public int getComparemode() {
		return mode;
	}

	public boolean setComparemode(int comparemode) {
		// Changes compare mode only if it's a recognized one
		// Returns true on success and false on failure
		// (Throwing Exceptions around would be a little overkill)
		
		if (comparemode >= 0 && comparemode <= 4) {
			this.mode = comparemode;
			return true;
		}
		else return false;
	}

}
