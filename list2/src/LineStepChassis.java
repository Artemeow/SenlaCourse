
public class LineStepChassis implements ILineStep{
	
	public IProductPart buildProductPart() {
		System.out.println("—оставл€юща€ Ўасси готова.");
		return new Chassis();
	}
	
}
