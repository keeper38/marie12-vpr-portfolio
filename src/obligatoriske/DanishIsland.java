package obligatoriske;

public class DanishIsland implements Comparable<DanishIsland> {

	private String name;
	private double circumference, area;
	private int addresstotal, addressdensity;
	
	public DanishIsland(String name, double circ, double area, int addrtotal, int addrdens) {
		
		// Initialize data
		this.setName(name);
		this.setCircumference(circ);
		this.setArea(area);
		this.setAddresstotal(addrtotal);
		this.setAddressdensity(addrdens);
	}
	
	public String toString() {
		return (getName() + "\t" + getCircumference()  + "\t" + getArea() + "\t" + getAddresstotal() + "\t" + getAddressdensity() + "\n");
	}
	
	public int compareTo(DanishIsland o) {
		
		return 0;
	}
	
	// Accessors and mutators. (Mutators private)
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public double getCircumference() {
		return circumference;
	}

	private void setCircumference(double circumference) {
		this.circumference = circumference;
	}

	public double getArea() {
		return area;
	}

	private void setArea(double area) {
		this.area = area;
	}

	public int getAddresstotal() {
		return addresstotal;
	}

	private void setAddresstotal(int addresstotal) {
		this.addresstotal = addresstotal;
	}

	public int getAddressdensity() {
		return addressdensity;
	}

	private void setAddressdensity(int addressdensity) {
		this.addressdensity = addressdensity;
	}

}
