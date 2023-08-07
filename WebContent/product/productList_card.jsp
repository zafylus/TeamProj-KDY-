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
        <section id="section">
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-secondary me-md-1" type="button" id="card">
                    <i class="bi bi-grid"></i>
                </button>
                <button class="btn btn-secondary" type="button" id="list">
                    <i class="bi bi-list-check"></i>
                </button>
            </div>
            <div class="d-grid gap-3 mt-3">
                <div class="row">
                    <div class="col-sm-4">
                            <div class="border rounded">
                                <img src="img/Americano-Thumbnail.png">
                            </div>
                            <div class="border rounded">
                                <h3>아메리카노</h3>
                            </div>
                    </div>
                    <div class="col-sm-4">
                            <div class="border rounded">
                                <img src="img/CafeLatte-Thumbnail.png">
                            </div>
                            <div class="border rounded">
                                <h3>카페라떼</h3>
                            </div>
                    </div>
                    <div class="col-sm-4">
                            <div class="border rounded">
                                <img src="img/VanillaLatte-Thumbnail.png">
                            </div>
                            <div class="border rounded">
                                <h3>바닐라라떼</h3>
                            </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                            <div class="border rounded">
                                <img src="img/bread-Thumbnail.png">
                            </div>
                            <div class="border rounded">
                                <h3>빵</h3>
                            </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
<script src="js/product/link.js"></script>
<script src="js/bootstrap.bundle.js" ></script>
</body>
</html>