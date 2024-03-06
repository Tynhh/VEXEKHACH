<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- header -->
	<header class="container-fluid myNavBar">
		<nav class="navbar navbar-expand-md navbar-light">
			<div class="col-md-8 col-xl-7 col-lg-9 col-sm-6 d-flex">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">
					<img src="assets/user/images/logo1.png" alt="logo">
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
						<li class="nav-item item4 ">
							<div class="d-flex">

								<button type="button" class="btn btn--white mr-2"
									data-toggle="modal" data-target="#exampleModalll">Quản lý chuyến xe</button>
							</div>
						</li>
						</li>
						<li class="nav-item item4 ">
							<div class="d-flex">

								<button type="button" class="btn btn--white mr-2"
									data-toggle="modal" data-target="#exampleModal">Login</button>
							</div>
						</li>
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
	<!-- <div class="modal-backdrop show"></div> -->
	<!-- đăng nhập -->
	<%@ include file="/views/Login/login_view.jsp"%>
	 <%@ include file="/views/Login/login_manager.jsp"%>
	


