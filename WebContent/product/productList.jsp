<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link href="css/bootstrap.css" rel="stylesheet" >
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="js/jquery.js"></script>
</head>
<body>
    <div class="container-fluid text-center">
        <header>
            <h1>상품 조회</h1>
            <hr>
        </header>
        <section>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-secondary me-md-1" type="button">
                    <i class="bi bi-grid"></i>
                </button>
                <button class="btn btn-secondary" type="button">
                    <i class="bi bi-list-check"></i>
                </button>
              </div>
            <table class="table table-striped">
                <form>
                <thead>
                	<tr>
                        <th>
                            <input type="checkbox" name="all" id="checkall">
                        </th>
	                    <th>상품코드</th>
	                    <th>상품명</th>
	                    <th>카테고리</th>
	                    <th>가격</th>
	                    <th>원가</th>
	                    <th>마진</th>
	                    <th>마진율</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pl" items="${plist }">
                        <tr>
                            <td><input type="checkbox" class="check"></td>
                            <td><a href="product-modify?pr-code=${pl.pr_code}">${pl.pr_code}</a></td>
                            <td>${pl.pr_name}</td>
                            <td>${pl.pr_ctgry}</td>
                            <td>${pl.pr_price}</td>
                            <td>${pl.total_cost}</td>
                            <td>${pl.margin}</td>
                            <td>${pl.margin_per}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </form>
            </table>
                <hr>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-secondary me-md-2" type="button" id="delbtn">삭 제</button>
            </div>
        </section>
    </div>
<script src="js/product/productDel.js"></script>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>