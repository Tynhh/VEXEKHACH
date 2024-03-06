<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">

<head>
<title>HomePage</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- font awesome -->
<link rel="stylesheet" href="assets/user/css/index.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- owlCousel -->
<link rel="stylesheet" href="../assets/lib/owl.carousel.min.css">
<link rel="stylesheet" href="../assets/lib/owl.theme.default.min.css">


<style>
.invalid {
	border-color: red !important;
}

#error,#error2, #error3, #errorNumberPhone {
	color: red;
}
</style>

</head>

<body>
	<%@ include file="header_manager_login.jsp"%>
	<!-- Cover -->
	<section class="myCover">
		<div class="cover__content">
			<div class="row tool-search">
				<div class="drop col-3">
					<div class="dropdown">
						<input placeholder="Nhập nơi đi ..." class="form-control"></input>
						<div class="dropdown__list">
							<a href="#" class="dropdown__item">Hà Nội</a> <a href="#"
								class="dropdown__item">Quảng Ning</a> <a href="#"
								class="dropdown__item">Sài Gòn</a> <a href="#"
								class="dropdown__item">Đà Nẵng></a>
						</div>
					</div>
				</div>

				<div class="drop col-3">
					<div class="dropdown">
						<input placeholder="Nhập nơi đến ..." class="form-control"></input>
						<div class="dropdown__list">
							<a href="#" class="dropdown__item">Hà Nội</a> <a href="#"
								class="dropdown__item">Quảng Ning</a> <a href="#"
								class="dropdown__item">Sài Gòn</a> <a href="#"
								class="dropdown__item">Đà Nẵng></a>
						</div>
					</div>
				</div>

				<div class=" drop col-3">
					<input class="form-control" type="date">
				</div>

				<div class="drop col-3">
					<button class="btn btn-danger">Tìm chuyến</button>
				</div>
			</div>
	</section>


	<jsp:include page="../../layout/user/footer.jsp" />
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<!-- owlCousel -->
	<script src="assets/lib/owl.carousel.min.js"></script>


	
	<!-- slick -->
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"
		integrity="sha512-HGOnQO9+SP1V92SrtZfjqxxtLmVzqZpjFFekvzZVWoiASSQgSr4cw9Kqd2+l8Llp4Gm0G8GIFJ4ddwZilcdb8A=="
		crossorigin="anonymous"></script>
	
</body>

</html>