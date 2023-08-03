<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row justify-content-center mt-5 pt-5">
            <div class="col-sm-6 mb-5" >
                <h1>상품 수정</h1>
                <hr>
            <form action="product-modify" method="post">
                <input type="text" name="pr_code" value="${code}" style="display:none">
                <div class="input-group mb-3">
                    <span class="input-group-text">상품명</span>
                    <input type="text" class="form-control" value="${prod.pr_name}" name="pr_name" placeholder="Name" aria-label="product-name" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">가 격</span>
                    <input type="text" class="form-control" value="${prod.pr_price}" name="pr_price" placeholder="Price" aria-label="product-price" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">
                        카테고리 
                    </span>
                    <div class="form-check form-check-inline ms-2">
                        <input class="form-check-input" type="radio" name="pr_ctgry" id="inlineRadio1" value="커피" checked>
                        <label class="form-check-label" for="inlineRadio1">커피</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="pr_ctgry" id="inlineRadio2" value="디저트">
                        <label class="form-check-label" for="inlineRadio2">디저트</label>
                    </div>
                </div>
                <div class="input-group">
                    <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload" disabled>
                    <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">업로드</button>
                </div>
                <!--레시피-->
                <hr>
                <h3>레시피</h3><br>
                <div class="input-group mb-3">
                    <span class="input-group-text">원두</span>
                    <input type="text" class="form-control" name="ma001" placeholder="200" value="${rec.ma001 * 1000}" aria-label="Amount (to the nearest dollar)">
                    <span class="input-group-text">g</span>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">우유</span>
                    <input type="text" class="form-control" name="ma002" placeholder="200" value="${rec.ma002 * 1000}" aria-label="Amount (to the nearest dollar)">
                    <span class="input-group-text">ml</span>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">시럽</span>
                    <input type="text" class="form-control" name="ma003" placeholder="200" value="${rec.ma003 * 1000}" aria-label="Amount (to the nearest dollar)">
                    <span class="input-group-text">ml</span>
                </div>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button class="btn btn-secondary me-md-2" type="submit">상품수정</button>
                </div>
            </form>
            </div>
        </div>
    </div>
    <script>
        const radioDessert = document.getElementById('inlineRadio2');
        const pr_ctgry = `${prod.pr_ctgry}`;
        console.log(pr_ctgry);
        if (pr_ctgry == '디저트') {
            radioDessert.checked = true;
        }
    </script>
</body>
</html>