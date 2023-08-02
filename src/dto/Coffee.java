package dto;

//커피 DTO
public class Coffee extends Product{

	public Coffee(String pr_code, String pr_name, int pr_price, String pr_ctgry) {
		super(pr_code, pr_name, pr_price, pr_ctgry);
	}

	@Override
	public int count() {
		return 0;
	}
}
