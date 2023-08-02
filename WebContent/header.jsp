<%@page import="util.OptionCheck"%>
<%@page import="service.Service_st"%>
<%@page import="vo.TotalStockVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery.js"></script>
</head>
<body>
<%
	Service_st st_serv = new Service_st();
	OptionCheck optCheck = new OptionCheck();
	ArrayList<TotalStockVO> alist = st_serv.getTotalList();
	boolean opt = optCheck.getAlramOpt();
	int alNum = optCheck.alramStockNum();
	
%>
	<header id="main-header" class="container-fluid border shadow p-3  bg-body rounded text-center">
	
		<h1>ERP System  [ver 1.0]</h1>
		<div id="liveAlertPlaceholder" class="row justify-content-end"></div>
<%
	if (opt) {
		for(TotalStockVO vo : alist ) {
			if(vo.getTotalEa() < alNum) {
		%>
			<script>
				$("#liveAlertPlaceholder").append(
						'<div class="col-sm-2 offset-sm-10 text-center alert alert-danger alert-dismissible fade show" role="alert">'
	 					+ '<strong><%= vo.getMa_name()%></strong> 의 재고량을 확인하세요.'
	 					+ '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>'
						+ '</div>')
			</script>
		<%
			}
		}
	}
%>
	</header>

<script src="js/bootstrap.bundle.js"></script>
</body>
</html>