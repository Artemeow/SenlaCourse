
public class LineStepEngine implements ILineStep{
	
	public IProductPart buildProductPart() {
		System.out.println("������������ ��������� ������.");
		return new Engine();
	}
	
}