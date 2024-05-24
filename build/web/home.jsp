<%-- 
    Document   : home
    Created on : Feb 24, 2024, 5:23:48 PM
    Author     : Bravo 15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "Model.*" %>
<%@page import = "DAL.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Trống Đọi Tam Shop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
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
        <link href="css/style.css" rel="stylesheet">
    </head>
    <%
        ProductsDAO u = new ProductsDAO(); //get list products từ database
        List<Products> list = (List<Products>) u.getAllProducts();
        
        CategoriesDAO c = new CategoriesDAO(); //get list categori
        List<Categories> listc = (List<Categories>) c.getListCategories();

    %>

    <body>
        <!-- Topbar Start -->
        <div class="container-fluid">
            <div class="row bg-secondary py-1 px-xl-5"> 
                <div class="d-inline-flex align-items-center d-block d-lg-none">
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-heart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-shopping-cart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
            <div class="col-lg-4">
                <a href="" class="text-decoration-none">
                    <span class="h1 text-uppercase text-primary bg-dark px-2">Dung Pham</span>
                    <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Shop</span>
                </a>
            </div>
            <div class="col-lg-4 col-6 text-left">
                <form action="searchbyname" method="GET">
                    <div class="input-group">
                        <!--<form action="search" method="GET">-->
                        <input type="text" class="form-control" name="pname" placeholder="Tìm kiếm ">    
                        <div class="input-group-append">
                            <!--<form action="search" method="GET">-->
                            <!--<input type="text" class="form-control" name="search" placeholder="Tìm kiếm . . . ">-->
                            <input style="font-weight: normal;" onmouseover="this.style.fontWeight = 'bold'" onmouseout="this.style.fontWeight = 'normal'" type="submit" value="Tìm kiếm" class="input-group-text bg-transparent text-primary" >
                            </input>
                            <!--</form>-->
                        </div>
                    </div>    
                </form>
            </div>
            <div class="col-lg-2 col-6 text-right btn-group">
                <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Tài khoản</button>
                <c:choose>
                    <c:when test="${empty sessionScope.account}">
                        <div class="dropdown-menu dropdown-menu-right">
                            <button class="dropdown-item" type="button"><a href="login.jsp" class="dropdown-item">Đăng nhập</a></button>
                            <button class="dropdown-item" type="button"><a href="register.jsp" class="dropdown-item">Đăng kí</a></button>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="dropdown-menu dropdown-menu-right">
                            <button class="dropdown-item" type="button"><a href="#" readonly class="dropdown-item">hello, ${sessionScope.account.getUsername()}</a></button>
                            <button class="dropdown-item" type="button"><a href="profile.jsp" class="dropdown-item">Xem tài khoản</a></button>
                            <button class="dropdown-item" type="button"><a href="logout" class="dropdown-item">Đăng xuất</a></button>
                        </div>
                    </c:otherwise>
                </c:choose>  
            </div>
        </div>

        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid bg-dark mb-30">
            <div class="row px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a class="btn d-flex align-items-center justify-content-between bg-primary w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;">
                        <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>THỂ LOẠI</h6>
                        <i class="fa fa-angle-down text-dark"></i>
                    </a>
                    <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
                        <%for(int i = 0; i < listc.size(); i++){%>
                        <div class="navbar-nav w-100">
                            <a href="getbycate?id=<%=listc.get(i).getId()%>" class="nav-item nav-link"><%=listc.get(i).getName()%></a>
                        </div>
                        <%}%>
                    </nav>
                </div>
                <div class="col-lg-9">
                    <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
                        <a href="" class="text-decoration-none d-block d-lg-none">
                            <span class="h1 text-uppercase text-dark bg-light px-2">ANH DUNG</span>
                            <span class="h1 text-uppercase text-light bg-primary px-2 ml-n1">SHOP</span>
                        </a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                <a href="home.jsp" class="nav-item nav-link active">Trang chủ</a>
                                <a href="shop.jsp" class="nav-item nav-link">Cửa hàng</a>
                                <!--<a href="detail.jsp" class="nav-item nav-link">Chi tiết</a>-->
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Lựa chọn<i class="fa fa-angle-down mt-1"></i></a>

                                    <c:choose>
                                        <c:when test="${empty sessionScope.account}">
                                            <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                                <a href="login.jsp" class="dropdown-item">Giỏ hàng</a>
                                                <a href="login.jsp" class="dropdown-item">Thủ tục thanh toán</a>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                                <a href="cart.jsp" class="dropdown-item">Giỏ hàng</a>
                                                <a href="checkout.jsp" class="dropdown-item">Thủ tục thanh toán</a>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>  


                                </div>
                                <a href="contact.jsp" class="nav-item nav-link">Liên hệ</a>
                            </div>
                            <div class="navbar-nav ml-auto py-0 d-none d-lg-block">
                                <c:choose>
                                    <c:when test="${empty sessionScope.account}">
                                        <a href="login.jsp" class="btn px-0">
                                            <i class="fas fa-heart text-primary"></i>
                                            <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;"></span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="listfavourite?id=${sessionScope.account.getId()}" class="btn px-0">
                                            <i class="fas fa-heart text-primary"></i>
                                            <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;"></span>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${empty sessionScope.account}">
                                        <a href="login.jsp" class="btn px-0 ml-3">
                                            <i class="fas fa-shopping-cart text-primary"></i>
                                            <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;"></span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="cart.jsp" class="btn px-0 ml-3">
                                            <i class="fas fa-shopping-cart text-primary"></i>
                                            <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;"></span>
                                        </a>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Navbar End -->


        <!-- Carousel Start -->
        <div class="container-fluid mb-3">
            <div class="row px-xl-5">
                <div class="col-lg-8">
                    <div id="header-carousel" class="carousel slide carousel-fade mb-30 mb-lg-0" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#header-carousel" data-slide-to="1"></li>
                            <li data-target="#header-carousel" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item position-relative active" style="height: 430px;">
                                <img class="position-absolute w-100 h-100" src="image/trong5.jpg" style="object-fit: cover;">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Trống Đọi Tam</h1>
                                        <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Sản phẩm truyền thống & nổi tiếng ngàn năm tuổi</p>
                                        <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp" href="shop.jsp">Mua ngay</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item position-relative" style="height: 430px;">
                                <img class="position-absolute w-100 h-100" src="image/thung3.jpg" style="object-fit: cover;">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Thùng Rượu Gỗ Sồi</h1>
                                        <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Thùng ngâm rượu xu hướng thượng lưu</p>
                                        <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp" href="shop.jsp">Mua ngay</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item position-relative" style="height: 430px;">
                                <img class="position-absolute w-100 h-100" src="image/ngua1.jpg" style="object-fit: cover;">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Xe Ngựa Kéo Pháo</h1>
                                        <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Đựng rượu & trang trí đẳng cấp</p>
                                        <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp" href="shop.jsp">Mua ngay</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="product-offer mb-30" style="height: 200px;">
                        <img class="img-fluid" src="image/ngua2.jpg" alt="">
                        <div class="offer-text">
                            <h6 class="text-white text-uppercase">Giảm giá 20%</h6>
                            <h3 class="text-white mb-3">Ưu đãi đặc biệt</h3>
                            <a href="shop.jsp" class="btn btn-primary">Mua ngay</a>
                        </div>
                    </div>
                    <div class="product-offer mb-30" style="height: 200px;">
                        <img class="img-fluid" src="image/thung2.jpg" alt="">
                        <div class="offer-text">
                            <h6 class="text-white text-uppercase">Giảm giá 20%</h6>
                            <h3 class="text-white mb-3">Ưu đãi hot</h3>
                            <a href="shop.jsp" class="btn btn-primary">Mua ngay</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Carousel End -->


        <!-- Featured Start -->
        <div class="container-fluid pt-5">
            <div class="row px-xl-5 pb-3">
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">Sản phẩm chất lượng</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                        <h5 class="font-weight-semi-bold m-0">Miễn phí giao hàng</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">Hoàn trả - 14 ngày</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">Hỗ trợ 24/7</h5>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featured End -->

        <!-- Products Start -->
        <div class="container-fluid pt-5 pb-3">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">Sản phẩm tiêu biểu</span></h2>
            <div class="row px-xl-5">
                <%for(int i = 0; i<8; i++){%>
                <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                    <div class="product-item bg-light mb-4">
                        <div class="product-img position-relative overflow-hidden">
                            <img class="img-fluid w-100" src="image/<%=list.get(i).getImage()%>" alt="">
                            <div class="product-action">
                                <a class="btn btn-outline-dark btn-square" href="addtocart?id=<%=list.get(i).getId()%>"><i class="fa fa-shopping-cart"></i></a>
                                <a class="btn btn-outline-dark btn-square" href="favouriteinsert?id=<%=list.get(i).getId()%>"><i class="far fa-heart"></i></a>
                                <a class="btn btn-outline-dark btn-square" href="productdetail?id=<%=list.get(i).getId()%>"><i class="fa fa-search"></i></a>
                            </div>
                        </div>
                        <div class="text-center py-4">
                            <a class="h6 text-decoration-none text-truncate" href=""><%=list.get(i).getTitle()%></a>
                            <div class="d-flex align-items-center justify-content-center mt-2">
                                <h5><%=list.get(i).getPrice()%></h5><h6 class="text-muted ml-2"><del><%=list.get(i).getPrice()+500000%></del></h6>
                            </div>
                            <div class="d-flex align-items-center justify-content-center mb-1">
                                <small class="fa fa-star text-primary mr-1"></small>
                                <small class="fa fa-star text-primary mr-1"></small>
                                <small class="fa fa-star text-primary mr-1"></small>
                                <small class="fa fa-star text-primary mr-1"></small>
                                <small class="fa fa-star text-primary mr-1"></small>
                                <small>(99)</small>
                            </div>
                        </div>
                    </div>
                </div>
                <%}%>

                <!-- Products End -->

                <!-- Vendor Start -->
                <div class="container-fluid py-5">
                    <div class="row px-xl-5">
                        <div class="col">
                            <div class="owl-carousel vendor-carousel">
                                <div class="bg-light p-1">
                                    <img src="image/trong90.jpg" alt="">
                                </div>
                                <div class="bg-light p-1">
                                    <img src="image/nguadoi.jpg" alt="">
                                </div>
                                <div class="bg-light p-1">
                                    <img src="image/thung100lit.jpg" alt="">
                                </div>
                                <div class="bg-light p-1">
                                    <img src="image/trong55.jpg" alt="">
                                </div>
                                <div class="bg-light p-1">
                                    <img src="image/nguadoi.jpg" alt="">
                                </div>
                                <div class="bg-light p-1">
                                    <img src="image/thung100lit.jpg" alt="">
                                </div>
                                <div class="bg-light p-1">
                                    <img src="image/trong90.jpg" alt="">
                                </div>
                                <div class="bg-light p-1">
                                    <img src="image/nguadoi.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Vendor End -->


                <!-- Footer Start -->
                <div class="container-fluid bg-dark text-secondary mt-5 pt-5">
                    <div class="row px-xl-5 pt-5">
                        <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                            <h5 class="text-secondary text-uppercase mb-4">Liên lạc</h5>
                            <p class="mb-4">Cơ sở sản xuất Trống & Thùng Rượu Gỗ Sồi & Bồn tắm & Chậu ngâm chân Phạm Dũng</p>
                            <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Xóm 6, Đọi Tam, Tiên Sơn, Hà Nam</p>
                            <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>dungpham2672004@gmail.com</p>
                            <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+098 1153 101</p>
                        </div>
                        <div class="col-lg-8 col-md-12">
                            <div class="row">
                                <div class="col-md-6 mb-5">
                                    <h5 class="text-secondary text-uppercase mb-4">Mua nhanh</h5>
                                    <div class="d-flex flex-column justify-content-start">
                                        <a class="text-secondary mb-2" href="home.jsp"><i class="fa fa-angle-right mr-2"></i>Trang chủ</a>
                                        <a class="text-secondary mb-2" href="shop.jsp"><i class="fa fa-angle-right mr-2"></i>Cửa hàng</a>
                                        <a class="text-secondary" href="https://www.facebook.com/dungphamhn88888/"><i class="fa fa-angle-right mr-2"></i>Liên hệ</a>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-5">
                                    <h5 class="text-secondary text-uppercase mb-4">Nhận thông báo</h5>
                                    <p>Thông báo sẽ được gửi tới email của bạn mỗi khi chúng tôi có sản phẩm mới</p>
                                    <form action="">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Địa chỉ email của bạn">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary">Đăng kí</button>
                                            </div>
                                        </div>
                                    </form>
                                    <h6 class="text-secondary text-uppercase mt-4 mb-3">Theo dõi chúng tôi</h6>
                                    <div class="d-flex">
                                        <a class="btn btn-primary btn-square mr-2" href="https://twitter.com/AnhDun32209" target="_blank"><i class="fab fa-twitter" target="_blank"></i></a>
                                        <a class="btn btn-primary btn-square mr-2" href="https://www.facebook.com/dungphamhn88888/" target="_blank"><i class="fab fa-facebook-f"></i></a>
                                        <a class="btn btn-primary btn-square mr-2" href="https://www.tiktok.com/@dunghn888888" target="_blank"><i class="fab fa-youtube" target="_blank"></i></a>
                                        <a class="btn btn-primary btn-square" href="https://www.instagram.com/phamhdung222/" target="_blank"><i class="fab fa-instagram"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border-top mx-xl-5 py-4" style="border-color: rgba(256, 256, 256, .1) !important;">
                        <div class="col-md-6 px-xl-0">
                            <p class="mb-md-0 text-center text-md-left text-secondary">
                                &copy; <a class="text-primary" href="#">PRJ301</a>. Sản phẩm thực hành của sinh viên Đại Học FPT </br>
                                Được thực hiện bởi <a class="text-primary" href="https://htmlcodex.com">DungPAHE173131@fpt.edu.vn</a>
                            </p>
                        </div>
                        <div class="col-md-6 px-xl-0 text-center text-md-right">
                            <img class="img-fluid" src="img/payments.png" alt="">
                        </div>
                    </div>
                </div>
                <!-- Footer End -->


                <!-- Back to Top -->
                <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


                <!-- JavaScript Libraries -->
                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
                <script src="lib/easing/easing.min.js"></script>
                <script src="lib/owlcarousel/owl.carousel.min.js"></script>

                <!-- Contact Javascript File -->
                <script src="mail/jqBootstrapValidation.min.js"></script>
                <script src="mail/contact.js"></script>

                <!-- Template Javascript -->
                <script src="js/main.js"></script>
                </body>

                </html>

