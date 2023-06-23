package erp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MonthlyData;

@WebServlet("/erp")
public class erp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		PrintWriter out = response.getWriter();

		ArrayList<MonthlyData> mList;
		String select = request.getParameter("select");
		if (select.equals("month")) {
			mList = monthTableData();
			out.print("<tr><th>월</th><th>판매금액</th><th>마진</th><th>지출</th><th>순이익</th></tr>");
			for (MonthlyData m : mList) {
				out.print("<tr><td>" + m.getMonth() + "</td><td>" + m.getSales() + "</td><td>" + m.getMargin()
						+ "</td><td>" + m.getExpense() + "</td><td>" + m.getNetIncome() + "</td><td>");
			}

		} else if (select.equals("day")) {
			mList = dayTableData();
			out.print("<tr><th>월</th><th>판매금액</th><th>순이익</th></tr>");
			for (MonthlyData m : mList) {
				out.print("<tr><td>" + m.getDay() + "</td><td>" + m.getSales() + "</td><td>" + m.getNetIncome()
						+ "</td><td>");
			}
		} else if (select.equals("menu")) {
			mList = menuTableData();
			out.print("<tr><th>제품명</th><th>판매금액</th><th>수량</th><th>순이익</th></tr>");
			for (MonthlyData m : mList) {
				out.print("<tr><td>" + m.getName() + "</td><td>" + m.getSales() + "</td><td>" + m.getEa() + "</td><td>" + m.getNetIncome()
						+ "</td><td>");
			}
		}
	}

	private ArrayList<MonthlyData> monthTableData() {
		ArrayList<MonthlyData> tableData = new ArrayList<>();
		Random random = new Random();

		for (int i = 1; i <= 12; i++) {
			int sales = random.nextInt(10000) + 1000; // 랜덤한 판매금액 생성 (1000부터 11000 사이)
			int margin = random.nextInt(5000) + 500; // 랜덤한 마진 생성 (500부터 5500 사이)
			int expense = random.nextInt(3000) + 1000; // 랜덤한 지출(매입+고정비) 생성 (1000부터 4000 사이)
			int netIncome = margin - expense; // 순이익 계산

			MonthlyData data = new MonthlyData(i, sales, margin, expense, netIncome);
			tableData.add(data);
		}

		return tableData;
	}

	private ArrayList<MonthlyData> dayTableData() {
		ArrayList<MonthlyData> tableData = new ArrayList<>();
		Random random = new Random();

		for (int i = 1; i <= 30; i++) {
			int sales = random.nextInt(10000) + 1000; // 랜덤한 판매금액 생성 (1000부터 11000 사이)
			int margin = random.nextInt(5000) + 500; // 랜덤한 마진 생성 (500부터 5500 사이)
			int netIncome = sales - margin; // 순이익 계산

			MonthlyData data = new MonthlyData(i, sales, netIncome);
			tableData.add(data);
		}

		return tableData;
	}
	
	private ArrayList<MonthlyData> menuTableData() {
		ArrayList<MonthlyData> tableData = new ArrayList<>();
		String[] names = {"아메리카노", "바닐라라떼", "플라넬드립라떼","초코라떼","카페라떼","에스프레소"};
		Random random = new Random();
		for (int i = 1; i <= names.length; i++) {
			String name = names[i - 1];
			int sales = random.nextInt(10000) + 1000; // 랜덤한 판매금액 생성 (1000부터 11000 사이)
			int ea = random.nextInt(1) + 5;
			int margin = random.nextInt(5000) + 500; // 랜덤한 마진 생성 (500부터 5500 사이)
			int netIncome = sales - margin; // 순이익 계산

			MonthlyData data = new MonthlyData(name,sales, ea, netIncome);
			tableData.add(data);
		}

		return tableData;
	}

}

