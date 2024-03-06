<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="sidebar close">
	<header>
		<div class="image-text">
			<span class="image"> <img src="assets/admin/images/bus-car-icon.svg" style="margin-left:0; width:100px;" alt="">
			</span>

			<div class="text logo-text" style="text-align: center; margin-left: 10px;" >
				<span class="name" style="font-size: 30px;">Admin</span> <span class="profession">Vexere </span>
			</div>
		</div>

		<i class='bx bx-chevron-right toggle'></i>
	</header>

	<div class="menu-bar">
		<div class="menu">

			<li class="search-box"><i class='bx bx-search icon'></i> <input
				type="text" placeholder="Search..."></li>

			<ul class="menu-links">
				<li class="nav-link"><a href="#"> <i
						class='bx bx-home-alt icon'></i> <span class="text nav-text">Giới Thiệu</span>
				</a></li>

				<li class="nav-link"><a href="thongKe"> <i
						class='bx bx-bar-chart-alt-2 icon'></i> <span
						class="text nav-text">Thống Kê</span>
				</a></li>

				<li class="nav-link"><a href="garaList"> <i
						class='bx bx-bell icon'></i> <span class="text nav-text">Quản Lý Hãng Xe</span>
				</a></li>

				<li class="nav-link"><a href="customerList"> <i
						class='bx bx-pie-chart-alt icon'></i> <span class="text nav-text">Quản Lý ACCOUNT</span>
				</a></li>

<!-- 				<li class="nav-link"><a href="#"> <i
						class='bx bx-heart icon'></i> <span class="text nav-text">Liên Hệ</span>
				</a></li> -->

			
			</ul>
		</div>

		<div class="bottom-content">
			<li class=""><a href="#"> <i class='bx bx-log-out icon'></i>
					<span class="text nav-text">Logout</span>
			</a></li>

			<li class="mode">
				<div class="sun-moon">
					<i class='bx bx-moon icon moon'></i> <i class='bx bx-sun icon sun'></i>
				</div> <span class="mode-text text">Dark mode</span>

				<div class="toggle-switch">
					<span class="switch"></span>
				</div>
			</li>

		</div>
	</div>

</nav>