
public class LineStepCarcase implements ILineStep{
	
	public IProductPart buildProductPart() {
		System.out.println("������������ ����� ������.");
		return new Carcase();
	}
	
}