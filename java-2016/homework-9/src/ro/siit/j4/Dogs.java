package ro.siit.j4;

public class Dogs implements Comparable{
	
	private String breed;
	private String name;
	private double weight;

	public Dogs(String breed, String name, double weight) {
		this.breed = breed;
		this.name = name;
		this.weight = weight;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Object o) {
		if(this.weight > ((Dogs)o).weight)
			return 1;
		else if(this.weight == ((Dogs)o).weight)
			return 0;
		else
			return -1;
	}


	@Override
	public String toString() {
		return breed;
	}


}
