
public class LineStepChassis implements ILineStep{
	
	public IProductPart buildProductPart() {
		System.out.println("������������ ����� ������.");
		return new Chassis();
	}
	
}
