package dto;

public class Coffee extends Product{
	
	

	public Coffee(String prod_no, String prodname, int price, String category) {
		super(prod_no, prodname, price, category);
	}

	@Override
	public int count() {
		return 0;
	}
}
