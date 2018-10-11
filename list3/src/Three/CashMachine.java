package Three;

import java.util.ArrayList;

public class CashMachine {
	public int getCost(ArrayList<Flower> bouquet) {
		int cost = 0;
		for(Flower fl: bouquet) {
			cost += fl.getPrice();
		}
		return cost;
	}
}
