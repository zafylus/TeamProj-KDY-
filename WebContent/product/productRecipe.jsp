<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe</title>
<link href="css/bootstrap.css" rel="stylesheet" >
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="js/jquery.js"></script>
</head>
<body>
    <div class="container-fluid text-center">
        <header>
            <h1>레시피 조회</h1>
            <hr>
        </header>
        <section id="section">
            <table class="table table-striped">
                <thead>
                	<tr>
	                    <th>상품명</th>
	                    <th>원두(g)</th>
	                    <th>우유(ml)</th>
	                    <th>시럽(ml)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="rl" items="${rlist }">
                        <tr>
                            <th>${rl.pr_name }</th>
                            <td>${rl.ma001 * 1000 }</td>
                            <td>${rl.ma002 * 1000 }</td>
                            <td>${rl.ma003 * 1000 }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>
<!--<script src="js/product/productDel.js"></script>-->
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>