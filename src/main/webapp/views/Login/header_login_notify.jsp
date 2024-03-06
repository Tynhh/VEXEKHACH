<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- header -->
<header class="container-fluid myNavBar">
	<nav class="navbar navbar-expand-md navbar-light">
		<div class="col-md-8 col-xl-7 col-lg-9 col-sm-6 d-flex">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">
				<img src="assets/user/images/logo4.png" alt="logo">
			</a>

			<div class="input-search">
				<form action="abc.com">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for anything">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-4 col-xl-5 col-lg-3 col-sm-4">
			<div class="collapse navbar-collapse" id="collapsibleNavId">
				<ul class="navbar-nav">
					<li class="nav-item business"><a class="nav-link" href="#">Thuê
							xe</a></li>
					<li class="nav-item teach"><a class="nav-link" href="#">Quản
							lý Chuyến đi</a></li>
					<li class="nav-item"></li>
				</ul>
			</div>
		</div>

		<button class="navbar-toggler d-lg-none col-sm-2" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation ">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
</header>
<!-- đăng nhập -->
<section class="dangnhap">
	<div class="modal" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel"
		style="display: block !important; overflow-x: hidden; overflow-y: auto;">
		<div class="modal-dialog modal-dialog-centered modal-xl">
			<div class="modal-content  login">
				<div class="modal-bodys">
					<div class="container ">
						<div class="log__content">
							<div class="left">
								<div class="logo">
									<img src="assets/user/images/logo4.png" alt="">

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
								<div class="mb-2" role="alert">
									<!-- <svg class="bi flex-shrink-0 me-2" role="img"
											aria-label="Danger:">
											<use xlink:href="#exclamation-triangle-fill" /></svg> -->
									<div style="color: red">${errorString}</div>
								</div>

								<form action="${pageContext.request.contextPath}/login"
									method="POST">
									<div class="form-group ">
										<input type="tel" class="form-control top" id="input"
											aria-describedby="phoneHelp" placeholder="Phone number"
											name="numberPhone" value="${user.phone_number}"
											pattern="[0-9]{10}" required>
										<div>
											<p id="error"></p>
										</div>
									</div>


									<div class="form-group ">
										<input type="password" class="form-control top" id="password"
											placeholder="Password" required name="password"
											value="${user.password}">
										<div>
											<p id="error2"></p>
										</div>
									</div>

									<div class="form-group content">
										<button type="button" class="btn  btn--white "
											data-toggle="modal" data-target="#modalForgot">
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
	<div class="modal-backdrop show"></div>
</section>
<!-- ForgotPassword -->
<section class="forgotPassword">
		<div class="modal fade" id="modalForgot" tabindex="-1"
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
									<form action="${pageContext.request.contextPath}/forgotPassword" method="POST">
										<div class="form-group">
											<input type="tel" class="form-control top" id="_phoneNumber"
												aria-describedby="phoneHelp" placeholder="Phone number"
												name="numberPhoneForgotPassword" value=""
												pattern="[0-9]{10}" required />

											<p id="errorNumberPhone" style="display: flex;"></p>
										</div>
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
	
	  var _phoneNumber = document.getElementById("_phoneNumber");
	  _phoneNumber.onblur = function () {
	    if (!validatePhoneNumber(_phoneNumber.value)) {
	      _phoneNumber.classList.add("invalid");
	      errorNumberPhone.innerHTML = "Please enter a correct number phone.";
	    }
	  };

	  _phoneNumber.onfocus = function () {
	    if (this.classList.contains("invalid")) {
	      this.classList.remove("invalid");
	      errorNumberPhone.innerHTML = "";
	    }
	  };
</script>