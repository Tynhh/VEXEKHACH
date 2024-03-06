<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<!----======== CSS ======== -->
<link rel="stylesheet" href="assets/admin/css/style.css">

<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

</head>
<body>

	<jsp:include page="/views/adminView/layout/sidebar.jsp" />  

	<section class="home">
		<div class="text">Sửa Thông Tin Khách Hàng</div>
		
		<div class="content">
			<p style="color: red;">${ errorString }</p>
			<form action="${ pageContext.request.contextPath }/editManager" method="POST">
			 <input type="hidden" name="id" value="${manager.id}" />
	            <div class="form-row">
	            	
	                <div class="form-group col-md-4">
	                    <label for="simpleinput">Tên quản lý</label>
	                     <td><input class="form-control" type="text" name="fullname" value="${manager.fullname}" /></td>
	                  
	                </div>
	            </div>
	            <br>
	            <div class="form-row">
	            	
	                <div class="form-group col-md-4">
	                    <label for="simpleinput">Số điện thoại</label>
	                     <td><input class="form-control" type="text" name="phone_number" value="${manager.phone_number}" /></td>
	                  
	                </div>
	            </div>
	            <br>
	            <div class="form-row">
	            	
	                <div class="form-group col-md-4">
	                    <label for="simpleinput">Email</label>
	                     <td> <input class="form-control" type="text" name="email" value="${manager.email}" /></td>
	                  
	                </div>
	            </div>
	            <br>
	            <div class="form-row">
	            	
	                <div class="form-group col-md-4">
	                    <label for="simpleinput">Password</label>
	                     <td><input class="form-control" type="text" name="password" value="${manager.password}" /></td>
	                  
	                </div>
	            </div>
	            <br>
	            <div class="form-row">
	            	
	                <div class="form-group col-md-4">
	                    <label for="simpleinput">Gara ID</label>
	                     <td><input class="form-control" type="text" name="garaid" value="${manager.garaid}" /></td>
	                  
	                </div>
	            </div>
	            <br>	            
	            <button class="btn btn-success">Cập nhật</button>
	            <a class="btn btn-primary" href="${ pageContext.request.contextPath }/managerList">Hủy</a>
        </form>
		</div> 
	</section>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
	<script>
        const body = document.querySelector('body'),
	    sidebar = body.querySelector('nav'),
	    toggle = body.querySelector(".toggle"),
	    searchBtn = body.querySelector(".search-box"),
	    modeSwitch = body.querySelector(".toggle-switch"),
	    modeText = body.querySelector(".mode-text");


		toggle.addEventListener("click" , () =>{
		    sidebar.classList.toggle("close");
		})
		
		searchBtn.addEventListener("click" , () =>{
		    sidebar.classList.remove("close");
		})
		
		modeSwitch.addEventListener("click" , () =>{
		    body.classList.toggle("dark");
		    
		    if(body.classList.contains("dark")){
		        modeText.innerText = "Light mode";
		    }else{
		        modeText.innerText = "Dark mode";
		        
		    }
		});
var str = ${ errorString };
		
		if (str == 'null')
			{
			alert("Cập Nhật Thành Công");
			window.location.href =  "managerList";
			}
    </script>
</body>
</html>