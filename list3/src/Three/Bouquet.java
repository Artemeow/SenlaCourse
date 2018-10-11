package Three;

import java.util.ArrayList;

public class Bouquet {
	private ArrayList<Flower> bouquet;
	
	public Bouquet() {
		bouquet = new ArrayList<Flower>();
	}
	
	public void add(Flower flower) {
		if(flower != null) {
			this.bouquet.add(flower);
		}
		else System.out.println("Нулевая ссылка");
	}

	public ArrayList<Flower> getBouquet() {
		return bouquet;
	}
	
}
