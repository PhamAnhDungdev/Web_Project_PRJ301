<%-- 
    Document   : register
    Created on : Feb 27, 2024, 2:32:04 PM
    Author     : Bravo 15
--%>

<%-- 
    Document   : login
    Created on : Feb 26, 2024, 11:58:53 PM
    Author     : Bravo 15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <link href="css/style.css" rel="stylesheet">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/login.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
        <section class="vh-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-6 text-black">

                        <div class="px-5 ms-xl-4">
                            <i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4" style="color: #709085;"></i>
                            <span class="h1 fw-bold mb-0">Trống Đọi Tam Shop</span>
                        </div>
                        </br>
                        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

                            <form action="register" method="POST" style="width: 23rem;">

                                <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Đăng kí</h3>

                                <div class="form-outline mb-4">
                                    <input type="text" id="form2Example18" class="form-control form-control-lg" name="first" placeholder="Họ" />
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="form2Example28" class="form-control form-control-lg" name="last" placeholder="Tên" />
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="text" id="form2Example28" class="form-control form-control-lg" name="phone" placeholder="Số điện thoại"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="email" id="form2Example18" class="form-control form-control-lg" name="email" placeholder="Email"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="form2Example18" class="form-control form-control-lg" name="address" placeholder="Địa chỉ"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" id="form2Example18" class="form-control form-control-lg" name="username" placeholder="Tên đăng nhập"/>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="form2Example18" class="form-control form-control-lg" name="password" placeholder="Mật khẩu"/>
                                </div>
                                
                                <div class="form-outline mb-4">
                                    <input type="password" id="form2Example18" class="form-control form-control-lg" name="repass" placeholder="Nhập lại mật khẩu"/>
                                </div>
                                <div class="pt-1 mb-4">
                                    <button type="submit" class="btn btn-info btn-lg btn-block" type="button">Đăng kí</button>
                                </div>

                                <p class="small mb-5 pb-lg-2"><a class="text-muted" href="home.jsp">Trang chủ</a></p>
                                <p>Bạn đã có tài khoản <a href="login.jsp" class="link-info">Quay lại trang đăng nhập</a></p>
                            </form>
                        </div>

                    </div>
                    <div class="col-sm-6 px-0 d-none d-sm-block">
                        <img src="image/trong90.jpg"
                             alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
