
public class LineStepEngine implements ILineStep{
	
	public IProductPart buildProductPart() {
		System.out.println("—оставл€юща€ ƒвигатель готова.");
		return new Engine();
	}
	
}