<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="model.Schedule" %>
<%@ page import="model.Trip" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đặt vé xe</title>
<!-- font awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="assets/user/css/index.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<!-- owlCousel -->
<link rel="stylesheet" href="assets/lib/owl.carousel.min.css">
<link rel="stylesheet" href="assets/lib/owl.theme.default.min.css">

<!-- slick -->

<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<!-- Add the slick-theme.css if you want default styling -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<!-- animated -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet" href="assets/user/css/ve16.css">
<link rel="stylesheet" href="assets/user/css/timve.css">
<link rel="stylesheet" href="assets/user/css/datvexe.css">
<link rel="stylesheet" href="assets/user/css/seatSelect.css">
<link rel="stylesheet" href="assets/user/css/listCoachSearch.css">
<link rel="stylesheet" href="assets/user/css/range_price.css">
<link rel="stylesheet" href="assets/user/css/filter.css">
<style>
.invalid {
	border-color: red !important;
	color: red;
}

#errorUserName,#errorNumberPhone,#errorUserEmail {
	color: red;
}


</style>


</head>

<body>
	<!-- Header -->
	<%@ include file="/layout/user/header.jsp"%>

	<!-- Content -->
	<section class="mid">
		<div class="container">
			<div class="row">
				<div class="col-4">
					<div
						class="boloc animate__animated animate__fadeInLeft animate__delay-1s">
						<p>Bộ lọc</p>
						<p><a href="#" onclick="filterTrip(1)">Lọc kết quả</a></p>
					</div>

					<div
						class="mid__left animate__animated animate__fadeInLeft animate__delay-1s">

						<div class="giodi">
							<div id="filter_time1" class="giodi_test filter_time">
								<p>Sáng sớm</p>
								<p>00:00-06:00</p>
							</div>
							<div id="filter_time2" class="giodi_test filter_time">
								<p>Buổi sáng</p>
                                <p>06:01-12:00</p>
							</div>
							<div id="filter_time3" class="giodi_test filter_time">
								<p>Buổi chiều</p>
                                <p>12:01-18:00</p>
							</div>
							<div id="filter_time4" class="giodi_test filter_time">
								<p>Buổi tối</p>
                                <p>18:01-23:59</p>
							</div>
						</div>


						<div class="giave">
							<form>
								<div class="form-group">
									<!-- <label for="formControlRange">Giá vé</label> <input
										type="range" class="form-control-range" id="formControlRange">
									<div class="info">
										<p>0</p>
										<p>200000</p>
									</div> -->
									<div class="wrapper">
									<p>Giá ghế</p>
									<p>Đơn vị: .000 VNĐ</p>
									<div class="price-input">
										<div class="field">
										<span>Min</span>
										<input type="number" class="input-min" value="0">
										</div>
										<div class="separator">-</div>
										<div class="field">
										<span>Max</span>
										<input type="number" class="input-max" value="1500">
										</div>
									</div>
									<div class="slider">
										<div class="progress"></div>
									</div>
									<div class="range-input">
										<input id="filterMin" type="range" class="range-min" min="0" max="1500" value="0" step="50">
										<input id="filterMax" type="range" class="range-max" min="0" max="1500" value="1500" step="50">
									</div>
									</div>
								</div>
							</form>
						</div>

						<div class="vitrighe">
							<p>Chọn Vị Trí Ghế</p>
							
							<div class="border"></div>
							<div class="hangghe">
								<span class="chair">Hàng ghế Đầu</span> <input type="checkbox"
									name="check" id="hangghe">
							</div>
							<div class="border"></div>
							<div class="hangghe">
								<span class="chair">Hàng ghế Giữa</span> <input type="checkbox"
									name="check" id="hangghe">
							</div>
							<div class="border"></div>
							<div class="hangghe">
								<span class="chair">Hàng ghế Cuối</span> <input type="checkbox"
									name="check" id="hangghe">
							</div>
							<div class="border"></div>
						</div>

						<div class="nhaxe">
							<p>Nhà xe</p>
							<input type="text" class="nhaxe__nav" placeholder="Tìm Nhà Xe">
							<div class="scroll">
								<div class="nhaxe_scroll" id="list1" type="checkbox">
									<input type="checkbox" name="check"> <span>Anh
										thư</span>
								</div>
								<div class="nhaxe_scroll" id="list2" type="checkbox">
									<input type="checkbox" name="check"> <span>Anh
										Đạt</span>
								</div>
								<div class="nhaxe_scroll" id="list3" type="checkbox">
									<input type="checkbox" name="check"> <span>Tân
										Phát</span>
								</div>
								<div class="nhaxe_scroll" id="list4" type="checkbox">
									<input type="checkbox" name="check"> <span>Anh
										ba</span>
								</div>
								<div class="nhaxe_scroll" id="list5" type="checkbox">
									<input type="checkbox" name="check"> <span>Chú
										Tư</span>
								</div>
								<div class="nhaxe_scroll" id="list6" type="checkbox">
									<input type="checkbox" name="check"> <span>Anh
										long</span>
								</div>
								<div class="nhaxe_scroll" id="list7" type="checkbox">
									<input type="checkbox" name="check"> <span>Anh
										bảnh</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Chú
										Dần</span>
								</div>

							</div>
						</div>

						<div class="nhaxe">
							<p>Điểm Đón</p>
							<input type="text" class="nhaxe__nav" placeholder="Tìm Nhà Xe">
							<div class="scroll">
								<div class="nhaxe_scroll" id="list1" type="checkbox">
									<input type="checkbox" name="check"> <span>Thủ
										Đức</span>
								</div>
								<div class="nhaxe_scroll" id="list2" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										12</span>
								</div>
								<div class="nhaxe_scroll" id="list3" type="checkbox">
									<input type="checkbox" name="check"> <span>Bình
										Thạnh</span>
								</div>
								<div class="nhaxe_scroll" id="list4" type="checkbox">
									<input type="checkbox" name="check"> <span>Gò
										Vấp</span>
								</div>
								<div class="nhaxe_scroll" id="list5" type="checkbox">
									<input type="checkbox" name="check"> <span>Tân
										Bình</span>
								</div>
								<div class="nhaxe_scroll" id="list6" type="checkbox">
									<input type="checkbox" name="check"> <span>Thuận
										An</span>
								</div>
								<div class="nhaxe_scroll" id="list7" type="checkbox">
									<input type="checkbox" name="check"> <span>Tân
										Phú</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>An
										Phú</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Phú
										Nhuận</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										9</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										10</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										3</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>QUận
										1</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Thủ
										Dầu 1</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										2 </span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										4</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										6</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Hóc
										Môn</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										7</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Quận
										8</span>
								</div>
							</div>
						</div>

						<div class="nhaxe">
							<p>Điểm Trả</p>
							<input type="text" class="nhaxe__nav" placeholder="Tìm Nhà Xe">
							<div class="scroll">
								<div class="nhaxe_scroll" id="list1" type="checkbox">
									<input type="checkbox" name="check"> <span>Buôn
										Mê Thuật</span>
								</div>
								<div class="nhaxe_scroll" id="list2" type="checkbox">
									<input type="checkbox" name="check"> <span>krong
										Pak</span>
								</div>
								<div class="nhaxe_scroll" id="list3" type="checkbox">
									<input type="checkbox" name="check"> <span>Buôn
										Hồ</span>
								</div>
								<div class="nhaxe_scroll" id="list4" type="checkbox">
									<input type="checkbox" name="check"> <span>Gia
										Nghĩa</span>
								</div>
								<div class="nhaxe_scroll" id="list5" type="checkbox">
									<input type="checkbox" name="check"> <span>Dak
										milk</span>
								</div>
								<div class="nhaxe_scroll" id="list6" type="checkbox">
									<input type="checkbox" name="check"> <span>Buôn
										Đôn</span>
								</div>
								<div class="nhaxe_scroll" id="list7" type="checkbox">
									<input type="checkbox" name="check"> <span>krong
										Ana</span>
								</div>
								<div class="nhaxe_scroll" id="list8" type="checkbox">
									<input type="checkbox" name="check"> <span>Cư
										M'gar</span>
								</div>

							</div>
						</div>

						<div class="giuong">
							<p>Loại ghế / giường</p>
							<div class="bed__chair">
								<div class="bed">
									<input type="checkbox" name="check" id="hangghe"> <span
										class="bed__">Ghế Ngồi</span>

								</div>

								<div class="bed">
									<input type="checkbox" name="check" id="hangghe"> <span
										class="chair">Giường Nằm Đôi</span>

								</div>
							</div>
						</div>

						<div class="cmt">
							<p>Đánh Giá</p>
							<div class="top">
								<div class="start">
									<i class="fa fa-star sta"></i> <i class="fa fa-star sta"></i> <i
										class="fa fa-star sta"></i> <i class="fa fa-star sta"></i> <i
										class="fa fa-star"></i>
								</div>
								<p>trở lên</p>
							</div>
							<div class="top">
								<div class="start">
									<i class="fa fa-star sta"></i> <i class="fa fa-star sta"></i> <i
										class="fa fa-star sta"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<p>trở lên</p>
							</div>
							<div class="top">
								<div class="start">
									<i class="fa fa-star sta"></i> <i class="fa fa-star sta"></i> <i
										class="fa fa-star "></i> <i class="fa fa-star "></i> <i
										class="fa fa-star"></i>
								</div>
								<p>trở lên</p>
							</div>
							<div class="top">
								<div class="start">
									<i class="fa fa-star sta"></i> <i class="fa fa-star "></i> <i
										class="fa fa-star "></i> <i class="fa fa-star "></i> <i
										class="fa fa-star"></i>
								</div>
								<p>trở lên</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-8">
					<div class="mid__right animate__animated animate__fadeInRight animate__delay-1s">
						<div class="project__content">
							<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist"
								style="font-size: 16px;">
								<span>Sắp xếp theo:</span>
								<li class="nav-item" role="presentation"><a
									class="nav-link active" id="pills-home-tab" data-toggle="pill"
									href="#all" role="tab" aria-controls="pills-home"
									aria-selected="true" onclick="SortTrip(1)">Giờ sớm nhất</a></li>
								<li class="nav-item" role="presentation"><a
									class="nav-link" id="pills-profile-tab" data-toggle="pill"
									href="#pills-profile" role="tab" aria-controls="pills-profile"
									aria-selected="false" onclick="SortTrip(2)">Giờ muộn nhất</a></li>
								<li class="nav-item" role="presentation"><a
									class="nav-link" id="pills-contact-tab" data-toggle="pill"
									href="#pills-contact" role="tab" aria-controls="pills-contact"
									aria-selected="false" onclick="SortTrip(3)">Giá thấp nhất</a></li>
								<li class="nav-item" role="presentation"><a
									class="nav-link" id="pills-website-tab" data-toggle="pill"
									href="#pills-website" role="tab" aria-controls="pills-website"
									aria-selected="false" onclick="SortTrip(4)">Giá cao nhất</a></li>
							</ul>
							<div id="RowTest">
								<c:forEach items="${ list_trip }" var="trip" varStatus="loop">
									<% Trip tr = (Trip) pageContext.getAttribute("trip"); %>  
									<form action="${pageContext.request.contextPath}/dat_ve" method="POST" style="margin-bottom: 32px;" id ="${ trip.id }">
										<div class="tab-pane fade show active" id="all${ trip.id }" role="tabpanel"
											aria-labelledby="pills-home-tab${ trip.id }"
											>
											<div class="vexe">
												<div class="card__top" style="font-size: small">
													<div class="card__right">
														<img src="assets/user/images/xe2.jpg" alt="">
	
														<div class="div">
															<div class="div__content" style="font-size: 16px">
																<h3 style="font-size: 20px">${ trip.garage.fullname }</h3>
																<!-- 	<i class="fa fa-star">3.9</i> -->
																<p class="content__1">${ trip.price } 000 VNĐ</p>
															</div>
															<p>Giường nằm ${ trip.num_seat } chỗ</p>
															<i class="fa fa-map-pin">${ trip.departure_time }</i><br> <i
																class="fa fa-map-marker-alt"></i>
														</div>
	
													</div>
													<div class="collasp">
														<div class="card__link">
															<a data-toggle="collapse" href="#collapseExample${ trip.id }"
																role="button" aria-expanded="false"
																aria-controls="collapseExample${ trip.id }"> Thông tin chi tiết <i
																class="fa fa-angle-down"></i>
															</a>
														</div>
														<div class="button">
															<button data-toggle="collapse"
																onclick="chonXe('#scroll1<%=1%>',800,'chuyendi','${ trip.id }','${ trip.id }')" aria-expanded="false"
																aria-controls="collapseChonChuyen${ trip.id }" name="idChuyenXe"
																value="${ trip.id }" type="button"  data-target="#collapseChonChuyen${ trip.id }">Chọn chuyến</button>
															<input class="form-check-input" type="hidden"
																value="${ trip.id }"
																name="inputIdChuyenXe" id="inputIdChuyenXe"> 
																<input class="form-check-input" type="hidden"
																value="${ trip.trip_board }"
																name="inputTripBoard" id="inputTripBoard"> 
														</div>
													</div>
	
												</div>
												</div>
										</div>
										
										<!-- cardbottom-chon chuyen -->
										<div class="card__bottom">
											<div class="collapse" id="collapseChonChuyen${ trip.id }">
												<div class="card card-body">
													<div class="project">
														<ul class="nav nav-pills mb-3 nav-tabs" id="pills-tab${ trip.id }"
															role="tablist">
	
															<li class="nav-item " role="presentation"><a
																class="nav-link active nav-link_1" id="pills-img-tab${ trip.id }"
																data-toggle="pill" href="#img${ trip.id }" role="tab"
																aria-controls="pills-img" aria-selected="true"><input
																	class="form-check-input" type="hidden"
																	name="inlineRadioOptions" id="inlineRadio${ trip.id }"
																	value="option${ trip.id }" checked> <label
																	class="form-check-label line-connect" for="inlineRadio${ trip.id }">1.Chỗ
																		mong muốn -></label></a></li>
	
															<li class="nav-item" role="presentation"><a
																class="nav-link nav-link_${ trip.id }" id="pills-cmt-tab${ trip.id }"
																data-toggle="pill" href="#pills-cmt${ trip.id }" role="tab"
																aria-controls="pills-cmt" aria-selected="false"><input
																	class="form-check-input" type="hidden"
																	name="inlineRadioOptions" id="inlineRadio${ trip.id }"
																	value="option${ trip.id }"> <label class="form-check-label"
																	for="inlineRadio${ trip.id }">2.Điểm đón trả -></label> </a></li>
															<li class="nav-item " role="presentation"><a
																class="nav-link nav-link_${ trip.id }" id="pills-travel-tab${ trip.id }"
																data-toggle="pill" href="#pills-travel${ trip.id }" role="tab"
																aria-controls="pills-travel" aria-selected="false"><input
																	class="form-check-input" type="hidden"
																	name="inlineRadioOptions" id="inlineRadio${ trip.id }"
																	value="option${ trip.id }"> <label class="form-check-label"
																	for="inlineRadio${ trip.id }">3.Nhập thông tin </label></a></li>
	
														</ul>
	
														<div class="tab-content" id="pills-tabContent">
															<div class="tab-pane fade show active" id="img${ trip.id }"
																role="tabpanel" aria-labelledby="pills-img-tab${ trip.id }">
																
																<div class="SeatSelectionOnline__SeatSelection-sc-167eirc-0 hqRXwu">
	                                                            	<div class="seat-groups">
	                                                                	<div class="note">Chú thích</div>
	                                                                	<div class="seat-info">
	                                                                        <div
	                                                                          class="SeatThumbnail__SeatContainer-sc-1ooosi9-0 oWlko seat-thumbnail"
	                                                                          color="#b8b8b8"
	                                                                        >
	                                                                          <svg
	                                                                            width="32"
	                                                                            height="40"
	                                                                            viewBox="0 0 28 40"
	                                                                            fill="none"
	                                                                            xmlns="http://www.w3.org/2000/svg"
	                                                                          >
	                                                                            <rect
	                                                                              x="2.75"
	                                                                              y="2.75"
	                                                                              width="22.5"
	                                                                              height="34.5"
	                                                                              rx="2.25"
	                                                                              fill="#FFF"
	                                                                              stroke="#B8B8B8"
	                                                                              stroke-width="1.5"
	                                                                              stroke-linejoin="round"
	                                                                            ></rect>
	                                                                            <rect
	                                                                              x="5.75"
	                                                                              y="27.75"
	                                                                              width="16.5"
	                                                                              height="6.5"
	                                                                              rx="2.25"
	                                                                              fill="#FFF"
	                                                                              stroke="#B8B8B8"
	                                                                              stroke-width="1.5"
	                                                                              stroke-linejoin="round"
	                                                                            ></rect>
	                                                                            <path
	                                                                              class="icon-selected"
	                                                                              d="M14 8.333A6.67 6.67 0 0 0 7.333 15 6.67 6.67 0 0 0 14 21.667 6.67 6.67 0 0 0 20.667 15 6.669 6.669 0 0 0 14 8.333zm-1.333 10L9.334 15l.94-.94 2.393 2.387 5.06-5.06.94.946-6 6z"
	                                                                              fill="transparent"
	                                                                            ></path>
	                                                                            <path
	                                                                              class="icon-disabled"
	                                                                              d="M18.96 11.46l-1.42-1.42L14 13.59l-3.54-3.55-1.42 1.42L12.59 15l-3.55 3.54 1.42 1.42L14 16.41l3.54 3.55 1.42-1.42L15.41 15l3.55-3.54z"
	                                                                              fill="transparent"
	                                                                            ></path>
	                                                                          </svg>
	                                                                        </div>
	                                                                        <span class="seat-name">Còn trống</span>
	                                                                      </div>
	                                                                      <div class="seat-info">
	                                                                        <div
	                                                                          class="SeatThumbnail__SeatContainer-sc-1ooosi9-0${ trip.id } daMVvn seat-thumbnail"
	                                                                          disabled=""
	                                                                        >
	                                                                          <svg
	                                                                            width="32"
	                                                                            height="40"
	                                                                            viewBox="0 0 28 40"
	                                                                            fill="none"
	                                                                            xmlns="http://www.w3.org/2000/svg"
	                                                                          >
	                                                                            <rect
	                                                                              x="2.75"
	                                                                              y="2.75"
	                                                                              width="22.5"
	                                                                              height="34.5"
	                                                                              rx="2.25"
	                                                                              fill="#FFF"
	                                                                              stroke="#B8B8B8"
	                                                                              stroke-width="1.5"
	                                                                              stroke-linejoin="round"
	                                                                            ></rect>
	                                                                            <rect
	                                                                              x="5.75"
	                                                                              y="27.75"
	                                                                              width="16.5"
	                                                                              height="6.5"
	                                                                              rx="2.25"
	                                                                              fill="#FFF"
	                                                                              stroke="#B8B8B8"
	                                                                              stroke-width="1.5"
	                                                                              stroke-linejoin="round"
	                                                                            ></rect>
	                                                                            <path
	                                                                              class="icon-selected"
	                                                                              d="M14 8.333A6.67 6.67 0 0 0 7.333 15 6.67 6.67 0 0 0 14 21.667 6.67 6.67 0 0 0 20.667 15 6.669 6.669 0 0 0 14 8.333zm-1.333 10L9.334 15l.94-.94 2.393 2.387 5.06-5.06.94.946-6 6z"
	                                                                              fill="transparent"
	                                                                            ></path>
	                                                                            <path
	                                                                              class="icon-disabled"
	                                                                              d="M18.96 11.46l-1.42-1.42L14 13.59l-3.54-3.55-1.42 1.42L12.59 15l-3.55 3.54 1.42 1.42L14 16.41l3.54 3.55 1.42-1.42L15.41 15l3.55-3.54z"
	                                                                              fill="transparent"
	                                                                            ></path>
	                                                                          </svg>
	                                                                        </div>
	                                                                        <span class="seat-name">Ghế đã bán</span>
	                                                                      </div>
	                                                                      <div class="seat-info">
	                                                                        <div
	                                                                          class="SeatThumbnail__SeatContainer-sc-1ooosi9-0 dLgsTe seat-thumbnail"
	                                                                        >
	                                                                          <svg
	                                                                            width="32"
	                                                                            height="40"
	                                                                            viewBox="0 0 28 40"
	                                                                            fill="none"
	                                                                            xmlns="http://www.w3.org/2000/svg"
	                                                                          >
	                                                                            <rect
	                                                                              x="2.75"
	                                                                              y="2.75"
	                                                                              width="22.5"
	                                                                              height="34.5"
	                                                                              rx="2.25"
	                                                                              fill="#FFF"
	                                                                              stroke="#B8B8B8"
	                                                                              stroke-width="1.5"
	                                                                              stroke-linejoin="round"
	                                                                            ></rect>
	                                                                            <rect
	                                                                              x="5.75"
	                                                                              y="27.75"
	                                                                              width="16.5"
	                                                                              height="6.5"
	                                                                              rx="2.25"
	                                                                              fill="#FFF"
	                                                                              stroke="#B8B8B8"
	                                                                              stroke-width="1.5"
	                                                                              stroke-linejoin="round"
	                                                                            ></rect>
	                                                                            <path
	                                                                              class="icon-selected"
	                                                                              d="M14 8.333A6.67 6.67 0 0 0 7.333 15 6.67 6.67 0 0 0 14 21.667 6.67 6.67 0 0 0 20.667 15 6.669 6.669 0 0 0 14 8.333zm-1.333 10L9.334 15l.94-.94 2.393 2.387 5.06-5.06.94.946-6 6z"
	                                                                              fill="transparent"
	                                                                            ></path>
	                                                                            <path
	                                                                              class="icon-disabled"
	                                                                              d="M18.96 11.46l-1.42-1.42L14 13.59l-3.54-3.55-1.42 1.42L12.59 15l-3.55 3.54 1.42 1.42L14 16.41l3.54 3.55 1.42-1.42L15.41 15l3.55-3.54z"
	                                                                              fill="transparent"
	                                                                            ></path>
	                                                                          </svg>
	                                                                        </div>
	                                                                        <span class="seat-name">Đang chọn</span>
	                                                                      </div>
	                                                                    </div>
	                                                                    <div class="SeatTemplate-sc-1ilqewh-0 llUipg seat-template">
	                                                                      <div class="coach-container">
	                                                                        <div class="coach">
	                                                                          <table>
	                                                                            <tbody>
	                                                                              	<tr class="coach-row">
	                                                                                <td class="seat">
	                                                                                  <div
	                                                                                    class="Seat__SeatContainer-sc-6hr0u8-0 buebkj seat-container"
	                                                                                    data-disabled="true"
	                                                                                    disabled=""
	                                                                                  >
	                                                                                    <svg
	                                                                                      width="24"
	                                                                                      height="24"
	                                                                                      viewBox="0 0 24 24"
	                                                                                      fill="none"
	                                                                                      xmlns="http://www.w3.org/2000/svg"
	                                                                                    >
	                                                                                      <path
	                                                                                        d="M12.305 24h-.61c-.035-.004-.07-.01-.105-.012a11.783 11.783 0 0 1-2.117-.261 12.027 12.027 0 0 1-6.958-4.394A11.933 11.933 0 0 1 .027 12.78L0 12.411v-.822c.005-.042.013-.084.014-.127a11.845 11.845 0 0 1 1.102-4.508 12.007 12.007 0 0 1 2.847-3.852A11.935 11.935 0 0 1 11.728.003c.947-.022 1.883.07 2.81.27 1.22.265 2.369.71 3.447 1.335a11.991 11.991 0 0 1 3.579 3.164 11.876 11.876 0 0 1 2.073 4.317c.178.712.292 1.434.334 2.168.008.146.02.292.029.439v.609c-.004.03-.011.06-.012.089a11.81 11.81 0 0 1-1.05 4.521 12.02 12.02 0 0 1-1.92 2.979 12.046 12.046 0 0 1-6.395 3.812c-.616.139-1.24.23-1.872.265-.149.008-.297.02-.446.03zm8.799-13.416c-.527-3.976-4.078-7.808-9.1-7.811-5.02-.003-8.583 3.823-9.11 7.809h.09c.64-.035 1.278-.092 1.912-.195.815-.131 1.614-.326 2.378-.639.625-.255 1.239-.54 1.855-.816.82-.368 1.673-.593 2.575-.62a7.123 7.123 0 0 1 1.947.187c.585.146 1.136.382 1.68.634.57.264 1.14.526 1.733.736 1.2.424 2.442.62 3.706.7.11.006.222.01.334.015zm-10.95 10.471v-.094c0-1.437 0-2.873-.002-4.31 0-.141-.011-.284-.035-.423a2.787 2.787 0 0 0-.775-1.495c-.564-.582-1.244-.896-2.067-.892-1.414.007-2.827.002-4.24.002h-.09a9.153 9.153 0 0 0 3.125 5.256 9.15 9.15 0 0 0 4.083 1.956zm3.689.001c1.738-.36 3.25-1.137 4.528-2.355 1.4-1.334 2.287-2.956 2.685-4.855l-.077-.003h-4.362c-.237 0-.47.038-.695.112-.667.22-1.188.635-1.588 1.206a2.673 2.673 0 0 0-.494 1.59c.008 1.4.003 2.801.003 4.202v.103zM12.05 14.22c1.215-.035 2.204-1.083 2.165-2.275-.039-1.223-1.095-2.215-2.29-2.166-1.211.05-2.2 1.108-2.15 2.302.051 1.191 1.108 2.186 2.275 2.139z"
	                                                                                        fill="#858585"
	                                                                                      ></path>
	                                                                                    </svg>
	                                                                                  </div>
	                                                                                </td>
	                                                                              	</tr>
																					<%! int indexSeat = 1; %>  
																					<c:forEach var="seat" items="${trip.list_seat}">
																					<% if (indexSeat % 4 == 1) { %>
																						<tr class="coach-row">
																					<% } %>
																						<td class="seat ${ seat.id } ${ seat.number_chair } ${ seat.status == 1 ? 'ArHJS' : 'K20TTDL'}" onclick="clickSeatFunction('${ seat.id }','${ trip.id }')">
																							<div
																							class="Seat__SeatContainer-sc-6hr0u8-0 iaQDbI seat-container ${ trip.id }"
																							data-disabled="true"
																							disabled=""
																							color="#b8b8b8"
																							>
																							<svg
																								width="32"
																								height="40"
																								viewBox="0 0 28 40"
																								fill="none"
																								xmlns="http://www.w3.org/2000/svg"
																								style="width: 27px; height: 40px"
																							>
																								<rect
																								x="2.75"
																								y="2.75"
																								width="22.5"
																								height="34.5"
																								rx="2.25"
																								fill="#FFF"
																								stroke="#B8B8B8"
																								stroke-width="1.5"
																								stroke-linejoin="round"
																								></rect>
																								<rect
																								x="5.75"
																								y="27.75"
																								width="16.5"
																								height="6.5"
																								rx="2.25"
																								fill="#FFF"
																								stroke="#B8B8B8"
																								stroke-width="1.5"
																								stroke-linejoin="round"
																								></rect>
																								<path
																								class="icon-selected"
																								d="M14 8.333A6.67 6.67 0 0 0 7.333 15 6.67 6.67 0 0 0 14 21.667 6.67 6.67 0 0 0 20.667 15 6.669 6.669 0 0 0 14 8.333zm-1.333 10L9.334 15l.94-.94 2.393 2.387 5.06-5.06.94.946-6 6z"
																								fill="transparent"
																								></path>
																								<path
																								class="icon-disabled"
																								d="M18.96 11.46l-1.42-1.42L14 13.59l-3.54-3.55-1.42 1.42L12.59 15l-3.55 3.54 1.42 1.42L14 16.41l3.54 3.55 1.42-1.42L15.41 15l3.55-3.54z"
																								fill="transparent"
																								></path>
																							</svg>
																							</div>
																						</td>
																					<% if (indexSeat % 4 == 2) { %>
																						<td class="">
																							<div
																							  class="Seat__SeatContainer-sc-6hr0u8-0 buebkj seat-container"
																							  data-disabled="true"
																							  disabled=""
																							></div>
																						</td>
																					<% } %>
																					<% if (indexSeat % 4 == 0) { %>
																						</tr>
																					<% } %>
																					<% indexSeat++; %>
																					</c:forEach>
	                                                                            </tbody>
	                                                                          </table>
	                                                                        </div>
	                                                                      </div>
	                                                                    </div>
	                                                                  </div>
	                                                            <div id="seat_result${trip.id}"></div>
																
																<div style="border-top: 1px solid;">
																	<div class="line"
																		style="display: block; border-bottom: 10px;"></div>
																	<div
																		style="display: flex; justify-content: flex-end; margin-top: 10px;">
																		<!-- <p
																			style="margin-right: 16px; margin-bottom: 0; margin-top: 5px;">Tổng
																			cộng: 0đ</p> -->
																		<button type="button" class="btn btn-primary btnNext"  onclick="btnNext('${ trip.id }',0)">Tiếp
																			tục</button>
																	</div>
																</div>
															</div>
	
															<div class="tab-pane fade" id="pills-cmt${ trip.id }" role="tabpanel"
																aria-labelledby="pills-cmt-tab${ trip.id }">
																<div class="row">
																	<div class="row">
																		<div class="col-12">
																			<div class="card animate__animated animate__zoomIn">
																				<div class="card-body">
																					<p class="card-text">Lưu ý Các mốc thời gian
																						đón, trả bên dưới là thời gian dự kiến. Lịch này có
																						thể thay đổi tùy tình hình thưc tế.</p>
																					<div class="card__2">
																						<div class="card__right1">
																							<h6>Điểm đón</h6>
																							<ul>
																								<% if (tr.getDeparture() == tr.garage.getAddress()) { %>
																									<c:forEach var="musty" items="${trip.list_musty}">
																										<% Schedule mt = (Schedule) pageContext.getAttribute("musty"); %>
																										<% if (mt.getStatus() == 1) { %>
																											<li class="form-check" style="display: flex">
																												<input class="form-check-input" type="radio"
																												name="checkbox_${ trip.id }" id="checkbox_${ trip.id }" value="${ musty.id }"> 
																												<label class="form-check-label" for="exampleRadios1" style="font-size: 16px">
																													${ musty.musty } 
																												</label>
																											</li>
																										<% } %>
																									</c:forEach>
																								<% } else { %>
																									<c:forEach var="musty" items="${trip.list_musty}">
																										<% Schedule mt = (Schedule) pageContext.getAttribute("musty"); %>
																										<% if (mt.getStatus() == 0) { %>
																											<li class="form-check" style="display: flex">
																												<input class="form-check-input" type="radio"
																												name="checkbox_${ trip.id }" id="checkbox_${ trip.id }" value="${ musty.id }"> 
																												<label class="form-check-label" for="exampleRadios1" style="font-size: 16px">
																													${ musty.musty } 
																												</label>
																											</li>
																										<% } %>
																									</c:forEach>
																								<% } %>
																							</ul>
																						</div>
	
																						<div class="card__left2">
																							<h6>Điểm trả</h6>
	
																							<ul>
																								<% if (tr.getDeparture() == tr.garage.getAddress()) { %>
																									<c:forEach var="musty" items="${trip.list_musty}">
																										<% Schedule mt = (Schedule) pageContext.getAttribute("musty"); %>
																										<% if (mt.getStatus() == 0) { %>
																											<li class="form-check" style="display: flex">
																												<input class="form-check-input" type="radio"
																												name="checkbox${ trip.id }" id="checkbox${ trip.id }" value="${ musty.id }"> 
																												<label class="form-check-label" for="exampleRadios1" style="font-size: 16px">
																													${ musty.musty } 
																												</label>
																											</li>
																										<% } %>
																									</c:forEach>
																								<% } else { %>
																									<c:forEach var="musty" items="${trip.list_musty}">
																										<% Schedule mt = (Schedule) pageContext.getAttribute("musty"); %>
																										<% if (mt.getStatus() == 1) { %>
																											<li class="form-check" style="display: flex">
																												<input class="form-check-input" type="radio"
																												name="checkbox${ trip.id }" id="checkbox${ trip.id }" value="${ musty.id }"> 
																												<label class="form-check-label" for="exampleRadios1" style="font-size: 16px">
																													${ musty.musty } 
																												</label>
																											</li>
																										<% } %>
																									</c:forEach>
																								<% } %>
																							</ul>
																						</div>
	
																					</div>
	
																				</div>
																			</div>
	
																			<div style="border-top: 1px solid;">
	
																				<div
																					style="display: flex; align-items: center; justify-content: space-between; margin-top: 20px;">
																					<button type="button"
																						class="btn btn-secondary btnPrevious" onclick="btnPrevious('${trip.id}',0)">Quay
																						lại</button>
																					<div style="display: flex;">
																						<!-- <p
																							style="margin-right: 16px; margin-bottom: 0; margin-top: 10px;">Tổng
																							cộng: 0đ</p> -->
																						<button type="button"
																							class="btn btn-primary btnNext" style="" onclick="btnNext('${ trip.id }',1)" >Tiếp
																							tục</button>
																					</div>
																				</div>
																			</div>
																		</div>
	
																	</div>
																</div>
															</div>
	
															<div class="tab-pane fade" id="pills-travel${trip.id}"
																role="tabpanel" aria-labelledby="pills-travel-tab${trip.id}">
																<div class="row">
																	<div class="col-12">
																		<div class="card animate__animated animate__zoomIn">
																			<div class="card-body">
																				<p>Chúng tôi chỉ dùng thông tin của bạn trong
																					việc ghi nhận vé.</p>
	
																				<div>
																					<div class="form-group ">
																						<input type="text" class="form-control top inputName"
																							id="inputName${trip.id}" placeholder="First and Last name "
																							name="nameUser${trip.id}" value="" required="required" onclick="onClickGetID('${ trip.id}')">
																						<div>
																							<p id="errorUserName${trip.id}" class="errorUserName"></p>
																						</div>
																					</div>
	
																					<div class="form-group ">
																						<input type="text"
																							class="form-control top inputPhone"
																							id="inputPhone${trip.id}" placeholder="Number phone "
																							name="phoneUser${trip.id}" value="" required="required" onclick="onClickGetID('${ trip.id}')">
	
																						<p id="errorNumberPhone"></p>
	
																					</div>
	
																					<div class="form-group ">
																						<input type="text" class="form-control top inputEmail"
																							id="inputEmail${trip.id}"
																							placeholder="Email (abc@gmail.com)"
																							name="emailUser${trip.id}" value="" required="required" onclick="onClickGetID('${ trip.id}')">
																						<div>
																							<p id="errorUserEmail"></p>
																						</div>
																					</div>
																					<div class="form-group ">
																						<input type="text" class="form-control top"
																							id="inputOther" aria-describedby="otherHelp"
																							placeholder="Note" name="noteUser" value="">
																						<!-- <div>
																						<p id="error4"></p>
																					</div> -->
																					</div>
																					<p>Bằng việc nhấn nút Tiếp Tục, bạn đồng ý với
																						Chính sách bảo mật thông tin và Quy chế</p>
																				</div>
																			</div>
																			<div style="border-top: 1px solid;">
	
																				<div class="line"
																					style="display: block; border-bottom: 10px;"></div>
																				<div
																					style="display: flex; align-items: center; justify-content: space-between;">
																					<button type="button"
																						class="btn btn-secondary btnPrevious"
																						style="margin-top: 20px" onclick="btnPrevious('${ trip.id }',1)">Quay lại</button>
																					<div style="display: flex; margin-top: 10px;">
																						<input id="price${trip.id}" name="priceTrip" value="${trip.price}" type="hidden">
																						<p
																							style="margin-right: 16px; margin-bottom: 0; margin-top: 5px;" id="sumPrice${trip.id}">
																							</p>
																						<button type="submit" class="btn btn-primary">Xác
																							nhận</button>
																					</div>
	
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</form>
								</c:forEach>
							</div>
						</div>
					</div>
			</div>
	</section>

	<!-- Footer -->
	<%@ include file="/layout/user/footer.jsp"%>
	
	
	 <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>

    <!-- owlCousel -->
    <script src="/lib/owl.carousel.min.js"></script>
        <script>
        var count = 0;
      
        function clickSeatFunction(seat_id,trip_id) {
          let seat = document.getElementsByClassName(seat_id);
          let seat_result = document.getElementById("seat_result"+trip_id);
          var price = document.getElementById("price"+trip_id);
          var sumPrice = document.getElementById("sumPrice"+trip_id);
          if (seat[0].classList[3] != "ArHJS")
          {
            if (seat[0].classList[4] == null) {
            count++;
            
              if (count < 4)
              {
                seat[0].classList.add("cUIhrn");
                let seatItem = document.createElement("input");
                let name = "seatID" + count.toString();
                seatItem.setAttribute("id", name);
                seatItem.setAttribute("name", name);
                seatItem.setAttribute("value", seat_id);
                seatItem.setAttribute('hidden', true);
                seat_result.appendChild(seatItem);
              } else {
                  alert(
                "Bạn được chọn tối đa 3 ghế! Xin thông cảm vì sự bất tiện này. Nếu bạn muốn đặt nhiều hơn, Vui lòng liên hệ trực tiếp với thu ngân qua số điện thoại của hãng."
              );
              count--;
              }
            
            } else {
              seat[0].classList.remove("cUIhrn");
              id = "seatID" + count.toString();
              let seatItem = document.getElementById(id);
              seatItem.parentNode.removeChild(seatItem);
              count--;
            }
          }
          
          var priceSeat = count*price?.value;
          sumPrice.innerHTML = priceSeat + ".000đ"; 
          
        }
      </script>
    
	 <script type="text/javascript">
		const nextBtn = document.querySelectorAll(".btnNext");
		const prevBtn = document.querySelectorAll(".btnPrevious");
				var btnNext = (n,index=0) => {
							 let id1 = index;
								let id2 = index + 1;
								let tabElement2 = document.querySelectorAll("#pills-tab" + n + " li a")[id2];
								var lastTab = new bootstrap.Tab(tabElement2);
								lastTab.show();

				}

		var btnPrevious = (n,index=0) => {
				let id = index;
				let id2 = index - 1;
				let tabElement = document.querySelectorAll("#pills-tab" + n +" li a")[id];
				var lastTab = new bootstrap.Tab(tabElement);
				lastTab.show();
		}

		var goBack2 = (n) => {
				var disabled2 = document.querySelector(`.nav-link_3`);
				if (disabled2.classList.contains('disabled')) {
						disabled2.classList.remove('disabled');
				}

		}
		/* nextTab */
 
		nextBtn.forEach(function (item, index) {

				item.addEventListener('click', function () {
						let id1 = index;
						let id2 = index + 1;
						let tabElement2 = document.querySelectorAll("#pills-tab2 li a")[id2];
						var lastTab = new bootstrap.Tab(tabElement2);
						lastTab.show();
				});
		});

		prevBtn.forEach(function (item, index) {
				item.addEventListener('click', function () {
						let id = index;
						let id2 = index - 1;
						let tabElement = document.querySelectorAll("#pills-tab2 li a")[id];
						var lastTab = new bootstrap.Tab(tabElement);
						lastTab.show();
				});
		});

		/* //check validatate */
		var inputName = document.getElementsByClassName("inputName"+idChuyen);
		var inputPhone = document.getElementById("inputPhone"+idChuyen);
		var inputEmail = document.getElementById("inputEmail"+idChuyen);
		var errorUserName = document.getElementById("errorUserName"+idChuyen);
		var errorUserName1 = document.getElementsByClassName("errorUserName"+idChuyen);
		var errorNumberPhone = document.getElementById("errorNumberPhone"+idChuyen);
		var errorUserEmail = document.getElementById("errorUserEmail"+idChuyen);
		var idChuyen = "";
    function onClickGetID(id){
			
      idChuyen = id;
			console.log("a"+inputName)
			console.log("b"+errorUserName)
			console.log("c"+errorUserName1)
        }

		
		inputName.onblur = function () {
				if (inputName.value.length == 0) {
						inputName.classList.add('invalid');
						errorUserName.innerHTML = 'Please enter a correct first name and last name.'
				}
		};

		inputName.onfocus = function () {
				inputName.classList.remove('invalid');
				errorUserName.innerHTML = "";
		};

		function validatePhoneNumber(input_str) {
				var re = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;

				return re.test(input_str);
		}


		inputPhone.onblur = function () {
				if (!validatePhoneNumber(inputPhone.value)) {
						inputPhone.classList.add('invalid');
						errorNumberPhone.innerHTML = 'Please enter a correct number phone.';
						/* 				errorNumberPhone.innerText = 'Please enter a correct number phone.'; */
						/* 				console.log(errorNumberPhone) */
				}
		};

		inputPhone.onfocus = function () {
				if (this.classList.contains('invalid')) {
						this.classList.remove('invalid');
						errorNumberPhone.innerHTML = "";
				}
		};


		inputEmail.onblur = function () {
				if (inputEmail.value.length === 0) {
						inputEmail.classList.add('invalid');
						errorUserEmail.innerHTML = 'Please enter a correct email.'
				}
		};

		inputEmail.onfocus = function () {
				if (this.classList.contains('invalid')) {
						this.classList.remove('invalid');
						errorUserEmail.innerHTML = "";
				}
		};

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="js/filter.js"></script>
<script>
	function SortTrip(sortIndex) {
		$.ajax({
			url: "/Web_Dat_Ve_Xe_Khach/sortTrip",
			type: "post", 
			data: { 
				sort: sortIndex,
				},
			success: function(data) {
				var rowTest = document.getElementById("RowTest");
				rowTest.replaceChildren();
				rowTest.innerHTML += data;
			},
			error: function() {
				alert("Có lỗi sảy ra khi lấy dữ liệu!");
			}
		});
	}
</script>
<script>
	//filter time
	var filter_time = Array.from (document.querySelectorAll('.filter_time'));
	let file_time1 = 0;
	let file_time2 = 0;
	let file_time3 = 0;
	let file_time4 = 0;
	
	filter_time.forEach(function (item, index) {
	    item.addEventListener('click', function () {
	        if (filter_time[index].classList[2] == null) {
	            filter_time[index].classList.add("filter_time_selected");
	            if (filter_time[index].id == 'filter_time1') {
	                file_time1 = 1;
	            }
	            if (filter_time[index].id == 'filter_time2') {
	                file_time2 = 1;
	            }
	            if (filter_time[index].id == 'filter_time3') {
	                file_time3 = 1;
	            }
	            if (filter_time[index].id == 'filter_time4') {
	                file_time4 = 1;
	            }
	        } else {
	            filter_time[index].classList.remove("filter_time_selected");
	            if (filter_time[index].id == 'filter_time1') {
	                file_time1 = 0;
	            }
	            if (filter_time[index].id == 'filter_time2') {
	                file_time2 = 0;
	            }
	            if (filter_time[index].id == 'filter_time3') {
	                file_time3 = 0;
	            }
	            if (filter_time[index].id == 'filter_time4') {
	                file_time4 = 0;
	            }
	        }
	    });
	});
	
	// end filter time
	
	// filterMin, filterMax
	

	function filterTrip(i) {
		let minValue = document.getElementById("filterMin").value;
		let maxValue = document.getElementById("filterMax").value;
		$.ajax({
			url: "/Web_Dat_Ve_Xe_Khach/filterTrip",
			type: "post", 
			data: { 
				filter_time1: file_time1,
				filter_time2: file_time2,
				filter_time3: file_time3,
				filter_time4: file_time4,
				min: minValue,
				max: maxValue,
				},
			success: function(data) {
				var rowTest = document.getElementById("RowTest");
				rowTest.replaceChildren();
				rowTest.innerHTML += data;
			},
			error: function() {
				alert("Có lỗi sảy ra khi lấy dữ liệu!");
			}
		});
	}
</script>
</body>

</html>