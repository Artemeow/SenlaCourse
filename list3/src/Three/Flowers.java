package Three;

public abstract class Flowers {
	
	private String name;
	private int price;
	
	public Flowers(int price, String name) {
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
