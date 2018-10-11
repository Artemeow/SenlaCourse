package Three;

public abstract class Flower {
	
	private String name;
	private int price;
	
	public Flower(int price, String name) {
		this.price = price;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}
