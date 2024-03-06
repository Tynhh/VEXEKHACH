<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
 <link rel="stylesheet" href="././assets/admin/css/login.css">
</head>
<body>
	<section class="section-enroll">
            <div class="row">
                <div class="enroll">
                    <div class="enroll_form">
                        <form class="form"  action="${pageContext.request.contextPath}/managerHome" method="POST">
                            <div>
                                <h2 class="heading-secondary">
                                    Login
                                </h2>
                            </div>
                            <div class="form__group">
                               <input type="text" class="form__input" name="username" id="username"
						placeholder="Tên đăng nhập" autofocus="1"
						aria-label="Tên đăng nhập">
                                <label for="username" class="form__label">Username</label>
                            </div>
                            <div class="form__group">
                            <input type="password" class="form__input" name="password" id="password"
						placeholder="Mật khẩu" aria-label="Mật khẩu">
                               
                                <label for="password" class="form__label">Password</label>
                            </div>
                            
                            <div class="form-group">
                                <button value="login" style="height:50px;box-shadow: 0 1.5rem 4rem rgba(0, 0, 0, 0.2);
  border-radius: 5rem; width:130px" class="btn btn--blue" name="login" type="submit">Đăng nhập</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
</body>
</html>
