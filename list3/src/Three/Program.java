package Three;

import java.util.List;

public class Program {

	public static void main(String[] args) {
		Flowers rose = new Roses(10, "����������");
		Flowers tul = new Tulips(8, "�������"); 
		
		Bouquet bouq = new Bouquet();
		bouq.add(tul);
		bouq.add(rose);
		
		CashMachine cm = new CashMachine();
		int cost = cm.getCost(bouq.getBouquet());
		
		System.out.println(cost);

	}

}
