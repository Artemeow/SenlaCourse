
public class TestClass {
	public static void main(String[] args)
	{
		
		LineStepChassis lineChassis = new LineStepChassis();
		LineStepCarcase lineCarcase = new LineStepCarcase();
		LineStepEngine lineEngine = new LineStepEngine();
		
		IProductPart chassis = lineChassis.buildProductPart();
		IProductPart carcase = lineCarcase.buildProductPart();
		IProductPart engine = lineEngine.buildProductPart();
		
		AssemblyLine assemblyLine = new AssemblyLine(chassis, carcase, engine);
		IProduct car = new Car();
		
		car = assemblyLine.assembleProduct(car);
	}
}
