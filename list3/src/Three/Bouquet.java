package Three;

import java.util.ArrayList;

public class Bouquet {
	private ArrayList<Flowers> bouquet;
	
	public Bouquet() {
		bouquet = new ArrayList<Flowers>();
	}
	
	public void add(Flowers flower){
		if(flower!=null)
			this.bouquet.add(flower);
		else System.out.println("Нулевая ссылка");
	}

	public ArrayList<Flowers> getBouquet() {
		return bouquet;
	}
	
}
