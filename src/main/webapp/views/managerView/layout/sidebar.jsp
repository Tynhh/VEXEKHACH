<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="utils.Router"%>
<nav class="sidebar close">
	<header>
		<div class="image-text">
			<span class="image"> <img src="assets/admin/images/bus-car-icon.svg"
				alt="">
			</span>

			<div class="text logo-text">
				<span class="name">VEXERE</span> <span class="profession">Manager </span>
			</div>
		</div>

		<i class='bx bx-chevron-right toggle'></i>
	</header>

	<div class="menu-bar">
		<div class="menu">

			<li class="search-box"><i class='bx bx-search icon'></i> <input
				type="text" placeholder="Search..."></li>

			<ul class="menu-links">
				<li class="nav-link"><a href="managerHomePage"> <i
						class='bx bx-home-alt icon'></i> <span class="text nav-text">Trang
							Chủ</span>
				</a></li>

				<li class="nav-link"><a
					href="tripManagement">
						<i class='bx bx-bar-chart-alt-2 icon'></i> <span
						class="text nav-text">Quản lý chuyến xe</span>
				</a></li>

				<li class="nav-link"><a href="quanlyve"> <i
						class='bx bx-bell icon'></i> <span class="text nav-text">Quản
							lý vé</span>
				</a></li>
<!-- 
				<li class="nav-link"><a href="#"> <i
						class='bx bx-pie-chart-alt icon'></i> <span class="text nav-text">Analytics</span>
				</a></li>

				<li class="nav-link"><a href="#"> <i
						class='bx bx-heart icon'></i> <span class="text nav-text">Likes</span>
				</a></li>

				<li class="nav-link"><a href="#"> <i
						class='bx bx-wallet icon'></i> <span class="text nav-text">Wallets</span>
				</a></li> -->

			</ul>
		</div>

		<div class="bottom-content">
			<li class=""><a href="managerHome"> <i class='bx bx-log-out icon'></i>
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