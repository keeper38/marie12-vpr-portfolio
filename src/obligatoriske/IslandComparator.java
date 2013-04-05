package obligatoriske;

import java.util.Comparator;

public class IslandComparator implements Comparator<DanishIsland> {

	// Modes to determine on which value to compare
	public static final int COMPARE_NAME			= 0;
	public static final int COMPARE_CIRCUMFERENCE	= 1;
	public static final int COMPARE_AREA 			= 2;
	public static final int COMPARE_ADDRESSTOTAL	= 3;
	public static final int COMPARE_ADDRESSDENSITY	= 4;
	
	private int mode;
	
	public IslandComparator(int mode) {
		this.setComparemode(mode);
	}
	
	public int compare(DanishIsland o1, DanishIsland o2) {
		/*
		 * Using integer to determine which parameters to compare. This is
		 * done with each comparison. For large data sets, this could be
		 * split up into several different routines, saving this
		 * switch statement, saving operations.
		 */
		
		int diff = 0;
		
		switch (this.mode) {
		case COMPARE_NAME:
			diff = o1.getName().compareToIgnoreCase(o2.getName());
			break;
			
		case COMPARE_CIRCUMFERENCE:
			if (o1.getCircumference() > o2.getCircumference()) diff = 1;
			else if (o1.getCircumference() < o2.getCircumference()) diff = -1;
			else diff = 0;
			break;
			
		case COMPARE_AREA:
			if (o1.getArea() > o2.getArea()) diff = 1;
			else if (o1.getArea() < o2.getArea()) diff = -1;
			else diff = 0;
			break;
			
		case COMPARE_ADDRESSTOTAL:
			diff = (o1.getAddresstotal() - o2.getAddresstotal());
			break;
			
		case COMPARE_ADDRESSDENSITY:
			diff = o1.getAddressdensity() - o2.getAddressdensity();
			break;

		default:
			System.err.println("Error: Unrecognized mode of comparason");
			break;
		}
		
		// If diff is zero, we will instead sort on the name.
		// For efficiency, this could be moved to the relevant comparison modes
		if (diff == 0) diff = o1.getName().compareToIgnoreCase(o2.getName());
		return diff;
	}

	public int getComparemode() {
		return this.mode;
	}

	public boolean setComparemode(int comparemode) {
		// Changes compare mode only if it's a recognised one
		// Returns true on success and false on failure
		// (Throwing Exceptions around would be a little overkill)
		
		if (comparemode >= 0 && comparemode <= 4) {
			this.mode = comparemode;
			return true;
		}
		else return false;
	}

}
