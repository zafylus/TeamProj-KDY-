package tests;


import dao.ReceiptDAO;
import services.ReceiptService;
import vos.SelectQueryVO;

public class Test {
	public static void main(String[] args) {
		ReceiptService rs = new ReceiptService();
		SelectQueryVO sq = new SelectQueryVO("2023-06-01", "2026-08-16", "all", "0", "80000", "or001");
		System.out.println(rs.createSelectQuery(sq));
//		ProductService ps = new ProductService();
//		System.out.println(ps.parseProductInfo());
//		
//		ReceiptDAO rd = new ReceiptDAO();
//		
//		System.out.println(rd.getMaxOdrNo());
//		
//		ProductMDAO pDao = new ProductMDAO();
//		ArrayList<RecipeOrderbyNameDTO> rlist = pDao.recipeListByName();
//		for (RecipeOrderbyNameDTO recipeOrderbyNameDTO : rlist) {
//			System.out.println(recipeOrderbyNameDTO);
//		}
		
//		ArrayList<Product> plist = pDao.productList_imgX();
//		JSONArray jlist = new JSONArray(plist);
//		System.out.println(jlist);

		/*ArrayList<ProductInfoDTO> plist = pDao.selectAll();
		for (ProductInfoDTO productInfoDTO : plist) {
			System.out.println(productInfoDTO);
		}
		*/
//		PosService pss = new PosService();
//		System.out.println(pss.productList());
		
		/*OrderDAO oDao = new OrderDAO();
//		oDao.regist();
		/*Map<String, Timestamp> olist = oDao.selectAll();
		olist.forEach((String code, Timestamp date) -> {
			System.out.println(code + " : " + date);
		});
		OrderListVO olVo = new OrderListVO("OR6", "PR001", 5);
//		oDao.registOrderList(olVo);
		ArrayList<OrderListVO> ordrlist = oDao.selectAllOrderList();
		for (OrderListVO orderListVO : ordrlist) {
			System.out.println(orderListVO);
		}*/
	}
}
