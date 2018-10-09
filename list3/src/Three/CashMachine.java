package Three;

import java.util.ArrayList;

public class CashMachine {
	public int getCost(ArrayList<Flowers> bouquet) {
		int cost = 0;
	
		for(Flowers fl: bouquet) {
			cost += fl.getPrice();
		}
	
		return cost;
	}
}
