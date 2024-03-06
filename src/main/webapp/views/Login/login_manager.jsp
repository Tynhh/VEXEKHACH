<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Customer"%>
<!DOCTYPE html>
<html>
<style>
.invalid {
	border-color: red !important;
}

#error, #error2, #error3, #errorNumberPhone {
	color: red;
}
</style>
<head>
<link rel="stylesheet" href="../assets/user/css/index.css">
<script src="/assets/lib/dist/sweetalert2.min.js"></script>
<link rel="stylesheet" href="/assets/lib/dist/sweetalert2.min.css">
<link rel="stylesheet" href="/assets/lib/dist/sweetalert2.css">

<!-- font awesome -->
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
</head>

<body>


	<section class="dangnhap">
		<div class="modal" id="exampleModalll" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-xl">
				<div class="modal-content  login">
					<div class="modal-bodys">
						<div class="container ">
							<div class="log__content">
								<div class="left">
									<div class="logo">
										<img src="assets/user/images/logo1.png" alt="">

									</div>

									<div class="log">
										<img alt="" src="assets/user/images/buy_ticket_login.jpg"
											style="width: 300px; height: 300px;">
									</div>
								</div>

								<div class="right">
									<div class=""
										style="display: flex; justify-content: flex-end; margin: -25px 15px 0 0; height: auto">

										<a class="" href="${pageContext.request.contextPath}/">
											<button type="button"
												class="btn btn-outline-danger btn-sm btn-close"
												data-bs-dismiss="modal" aria-label="Close">X</button>
										</a>
									</div>
									<H2>Login to your account</H2>
									<!--  <p class="right__title">Don't have an account? <a href="">Sign up free</a></p> -->
									<div class="alert  d-flex align-items-center" role="alert">
										<!-- <svg class="bi flex-shrink-0 me-2" role="img"
											aria-label="Danger:">
											<use xlink:href="#exclamation-triangle-fill" /></svg> -->
										<div>${errorString}</div>
									</div>

									<form action="${pageContext.request.contextPath}/managerHome"
										method="POST">
										<div class="form-group ">
											<input type="tel" class="form-control top" id="input11"
												aria-describedby="phoneHelp" placeholder="Phone number"
												name="username" value="${user.phone_number}"
												pattern="[0-9]{10}" required>
											  <div>
												<p id="error11"></p>
											</div>  
										</div>


										<div class="form-group ">
											<input type="password" class="form-control top" id="password22"
												placeholder="Password" required name="password"
												value="${user.password}">
											  <div>
												<p id="error22"></p>
											</div>  
										</div>

										<div class="form-group content">
											<button type="button" class="btn  btn--white "
												data-toggle="modal" data-target="#modalForgot1">
												Forgot password</button>
										</div>
										<button class="button3" type="submit">Login</button>
									</form>


								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>


	<section class="forgotPassword">
		<div class="modal fade" id="modalForgot1" tabindex="-1"
			aria-labelledby="modalForgot" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-xl">
				<div class="modal-content  forgot">
					<div class="modal-bodys">
						<div class="container ">
							<div class="log__content">
								<div class="left" style="margin-right: 35px;">
									<div class="logo">
										<img src="assets/user/images/logo1.png" alt="">
									</div>
									<
									<div class="log">
										<img alt="" src="assets/user/images/buy_ticket_login.jpg"
											style="width: 300px; height: 300px;">
									</div>
								</div>
								<div class="right">
									<div class=""
										style="display: flex; justify-content: flex-end; margin: -25px 15px 0 0; height: auto">
										<a class="" href="${pageContext.request.contextPath}/">
											<button type="button"
												class="btn btn-outline-danger btn-sm btn-close"
												data-bs-dismiss="modal" aria-label="Close">X</button>
										</a>
									</div>
									<H2>Forgot password</H2>
									<form
										action="${pageContext.request.contextPath}/forgotPassManager"
										method="POST">
										<div class="alert  d-flex align-items-center" role="alert">

											<div>${errorString}</div>
										</div>
										<div class="form-group">
											<input type="tel" class="form-control top" id="_phoneNumber11"
												aria-describedby="phoneHelp" placeholder="Phone number"
												name="numberPhoneForgotPassword" value=""
												pattern="[0-9]{10}" required />
											 <p id="errorNumberPhone11" style="display: flex;"></p>  
										</div>
										<p style="color: red;">${ notifi }</p>
										<div class=""
											style="display: flex; justify-content: space-between;">
											<button class="button3"
												style="margin: 0; margin-right: auto; width: 23%; margin-left: 0px;"
												type="submit">Submit</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript">
		function validatePhoneNumber(input_str) {
			var re = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;

			return re.test(input_str);
		}

		var input11 = document.getElementById("input11");
		var password22 = document.getElementById("password22");
		input11.onblur = function() {
			if (!validatePhoneNumber(input11.value)) {
				input11.classList.add('invalid');
				error11.innerHTML = 'Please enter a correct number phone.'
			}
		};

		input11.onfocus = function() {
			if (this.classList.contains('invalid')) {

				this.classList.remove('invalid');
				error11.innerHTML = "";
			}
		};

		password22.onblur = function() {
			if (password22.value.length === 0) {
				password22.classList.add('invalid');
				error22.innerHTML = 'Please enter a correct password.'

			}
		};

		password22.onfocus = function() {
			if (this.classList.contains('invalid')) {

				this.classList.remove('invalid');
				error22.innerHTML = "";
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

	<script type="text/javascript">
		function validatePhoneNumber(input_str) {
			var re = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;

			return re.test(input_str);
		}

		var _phoneNumber11 = document.getElementById("_phoneNumber11");
		_phoneNumber11.onblur = function() {
			if (!validatePhoneNumber(_phoneNumber11.value)) {
				_phoneNumber11.classList.add("invalid");
				errorNumberPhone11.innerHTML = "Please enter a correct number phone.";
			}
		};

		_phoneNumber11.onfocus = function() {
			if (this.classList.contains("invalid")) {
				this.classList.remove("invalid");
				errorNumberPhone11.innerHTML = "";
			}
		};
	</script>
</body>
</html>