
public class Car implements IProduct{
	private IProductPart chassis;
	private IProductPart carcase;
	private IProductPart engine;
	
	
	public void installFirstPart(IProductPart productPart) {
		chassis = productPart;
		System.out.println(productPart.toString() + " �����������");
	}

	public void installSecondPart(IProductPart productPart) {
		carcase =  productPart;
		System.out.println(productPart.toString() + " �����������");
	}

	public void installThirdPart(IProductPart productPart) {
		engine = productPart;
		System.out.println(productPart.toString() + " �����������");
	}

}
