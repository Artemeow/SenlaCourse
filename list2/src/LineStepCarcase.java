
public class LineStepCarcase implements ILineStep{
	
	public IProductPart buildProductPart() {
		System.out.println("—оставл€юща€  узов готова.");
		return new Carcase();
	}
	
}