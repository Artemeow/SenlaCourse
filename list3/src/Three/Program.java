package Three;

public class Program {

	public static void main(String[] args) {
		Flower rose = new Roses(11, "����������");
		Flower tul = new Tulips(8, "�������"); 
		
		Bouquet bouq = new Bouquet();
		bouq.add(tul);
		bouq.add(rose);
		
		CashMachine cm = new CashMachine();
		int cost = cm.getCost(bouq.getBouquet());
		
		System.out.println(cost);

	}

}
