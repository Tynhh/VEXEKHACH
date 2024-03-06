<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Login</title>
<link rel="stylesheet" href="./assets/admin/css/login.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
</body>
</html>
<section>
	<!--Bắt Đầu Phần Hình Ảnh-->
	<div class="img-bg">
		<img
			src="https://nld.mediacdn.vn/2017/photo-1-1502239790931.jpg"
			alt="Hình Ảnh Minh Họa">
	</div>
	<!--Kết Thúc Phần Hình Ảnh-->
	<!--Bắt Đầu Phần Nội Dung-->
	<div class="noi-dung">
		<div class="form">
			<h2>LOGIN</h2>
			<form action="${pageContext.request.contextPath}/adminHome" method="POST">
				<div class="input-form">
					<span>Tên Người Dùng</span> <input type="text" name="username">
				</div>
				<div class="input-form">
					<span>Mật Khẩu</span> <input type="password" name="password">
				</div>
				<div class="nho-dang-nhap">
					<label><input type="checkbox" name=""> Nhớ Đăng
						Nhập</label>
				</div>
				<div class="input-form">
					<input type="submit" value="Đăng Nhập">
				</div>
				<div class="input-form">
					<p>
						Quay về trang chủ VEXERE ? <a href="${pageContext.request.contextPath}/">Quay lại</a>
					</p>
				</div>
			</form>
			<h3>Đăng Nhập Bằng Mạng Xã Hội</h3>
			<ul class="icon-dang-nhap">
				<li><i class="fa fa-facebook" aria-hidden="true"></i></li>
				<li><i class="fa fa-google" aria-hidden="true"></i></li>
				<li><i class="fa fa-twitter" aria-hidden="true"></i></li>
			</ul>
		</div>
	</div>
	<!--Kết Thúc Phần Nội Dung-->
</section>
<script type="text/javascript">
	function validatePhoneNumber(input_str) {
		var re = 'tuan123';

		return re.test(input_str);
	}

	var input = document.getElementById("input");
	var password = document.getElementById("password");
	input.onblur = function() {
		if (!validatePhoneNumber(input.value)) {
			input.classList.add('invalid');
			error.innerHTML = 'Please enter a correct number phone.'
		}
	};

	input.onfocus = function() {
		if (this.classList.contains('invalid')) {

			this.classList.remove('invalid');
			error.innerHTML = "";
		}
	};

	password.onblur = function() {
		if (password.value.length === 0) {
			password.classList.add('invalid');
			error2.innerHTML = 'Please enter a correct password.'

		}
	};

	password.onfocus = function() {
		if (this.classList.contains('invalid')) {

			this.classList.remove('invalid');
			error2.innerHTML = "";
		}
	};

	function sweetAlert() {
		Swal.fire({
			title : 'Error!',
			text : 'Do you want to continue',
			icon : 'error',
			confirmButtonText : 'Cool'
		})
	}
	sweetAlert();
</script>