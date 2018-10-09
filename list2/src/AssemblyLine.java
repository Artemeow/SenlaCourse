
public class AssemblyLine implements IAssemblyLine{
	
	private IProductPart _firstPart;
	private IProductPart _secondPart;
	private IProductPart _thirdPart;
	
	public AssemblyLine(IProductPart firstPart, IProductPart secondPart, IProductPart thirdPart)
	{
		_firstPart = firstPart;
		_secondPart = secondPart;
		_thirdPart = thirdPart;
		System.out.println("—оставл€ющие готовы к сборке!");
	}
	
	public IProduct assembleProduct(IProduct product) {
		product.installFirstPart(_firstPart);
		product.installSecondPart(_secondPart);
		product.installThirdPart(_thirdPart);
		System.out.println("—борка автомобил€ завершена!");
		return product;
	}

}
