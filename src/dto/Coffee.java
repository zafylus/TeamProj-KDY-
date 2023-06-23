package dto;



public class Coffee extends Product{
	
	

	public Coffee(String prodno, int price, String prodname, String category) {
		super(prodno, prodname, price, category);
	}
	

	@Override
	public int count() {
		return 0;
	}
}
