<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	nav {
		grid-area : nav;
	}
	
	
	
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="main.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">매출</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="expense.jsp">매입</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="totalstock">재고</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            	재고
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="totalstock">총 재고량</a></li>
            <li><a class="dropdown-item" href="stockList">재고 입/출 리스트</a></li>
            <li><a class="dropdown-item" href="registStock">재고 등록</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>