<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERP Project</title>
    <style>
        #wrapper{
            display: grid;
            grid-template-rows: repeat(3, 1fr);
            grid-template-columns: 3, 7;
        }
        #header, #nav{
       
        }
    </style>
</head>
<body>
    <div id = "wrapper">
        <header id="header"><h1>ERP</h1> </header>
        <nav id="nav"> <a href="salesdate">매출</a> 지출 재고 직원 <a href="index.html">홈으로</a></nav>
        <sidebar id="sidebar">상세메뉴</sidebar>
        <section id="section">내용</section>
    </div>
</body>
</html>