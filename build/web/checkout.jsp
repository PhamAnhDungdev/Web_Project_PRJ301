<%-- 
    Document   : checkout
    Created on : Feb 24, 2024, 5:30:35 PM
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
        CategoriesDAO c = new CategoriesDAO();//get list cate
        List<Categories> listc = (List<Categories>) c.getListCategories();
        
        ProductsDAO u = new ProductsDAO();
        CartItemDAO cartitem = new CartItemDAO();
        CartDAO cart = new CartDAO();
        
        HttpSession sess = request.getSession();//get info user bằng session
        User x = (User) sess.getAttribute("account");
        
        Cart o = cart.getCartByUid(x.getId());//get list cart
        
        List<Products> listp = null; // là list tất cả sản phẩm được thêm vào giỏ hàng của user session
        List<CartItem> listcart = null; //list giỏ hàng cùng sản phẩm của user để lấy số lượng của từng sản phẩm
        if(x != null){
            listp = (List<Products>) u.getListByUserId(x.getId());
            if(o != null){
            listcart = (List<CartItem>) cartitem.getListCartItem(o.getCartId());
            }else{
            listcart = null;
            }
        }else{
            listp = null;
            listcart = null;
        }
        int sumprice = 0;
        int ttt = 0;
        if(listp != null){
            for(int k = 0; k < listp.size(); k++){
                sumprice += listp.get(k).getPrice()*listcart.get(k).getQuantity();
            }
        }
        ttt = sumprice + 200000;
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
                        <input type="text" class="form-control" name="pname" placeholder="Tìm kiếm">    
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
        <!--</div>-->
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
                            <span class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
                        </a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                <a href="home.jsp" class="nav-item nav-link">Trang chủ</a>
                                <a href="shop.jsp" class="nav-item nav-link">Cửa hàng</a>
                                <!--<a href="detail.jsp" class="nav-item nav-link">Chi tiết</a>-->
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Lựa chọn<i class="fa fa-angle-down mt-1"></i></a>
                                    <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                        <a href="cart.jsp" class="dropdown-item">Giỏ hàng</a>
                                        <a href="checkout.jsp" class="dropdown-item active">Thủ tục thanh toán</a>
                                    </div>
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


        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="home.jsp">Trang chủ</a>
                        <a class="breadcrumb-item text-dark" href="checkout.jsp">Thanh toán</a>
                        <span class="breadcrumb-item active">Thủ tục thanh toán</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Checkout Start -->
        <div class="container-fluid">
            <form action="insertorder" method="GET">
                <div class="row px-xl-5">
                    <div class="col-lg-8">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Thông tin người đặt</span></h5>
                        <div class="bg-light p-30 mb-5">
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label>Họ</label>
                                    <input class="form-control" type="text" name="first" value="<%=x.getFirstname()%>"/>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Tên</label>
                                    <input class="form-control" type="text" name="last" value="<%=x.getLastname()%>"/>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Email</label>
                                    <input class="form-control" type="text" name="email" value="<%=x.getEmail()%>"/>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Số điện thoại</label>
                                    <input class="form-control" type="text" name="phone" value="<%=x.getPhone()%>"/>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Địa chỉ nhận hàng</label>
                                    <input class="form-control" type="text" name="address" value="<%=x.getAddress()%>"/>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Đất nước</label>
                                    <select class="custom-select" name="country">
                                        <option value="Việt Nam" selected>Việt Nam</option>
                                        <option value="Trung Quốc" >Trung Quốc</option>
                                        <option value="Nhật Bản" >Nhật Bản</option>
                                    </select>
                                </div>
                            </div> 
                        </div>
                        <div class="bg-light p-30 mb-5">
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <labe>${requestScope.thongbao}</label>     
                                </div>
                            </div> 
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Tổng đơn hàng</span></h5>
                        <div class="bg-light p-30 mb-5">
                            <div class="border-bottom">
                                <h6 class="mb-3">Sản phẩm </h6>
                                <%for(int i = 0; i < listp.size(); i++){%>
                                <div class="d-flex justify-content-between">
                                    <p><%=listp.get(i).getName()%></p>
                                    <p><%=listp.get(i).getPrice()%> VNĐ / <%=listcart.get(i).getQuantity()%> </p>
                                </div>
                                <%}%>
                            </div>
                            <div class="border-bottom pt-3 pb-2"> 
                                <%for(int i = 0; i < listp.size(); i++){%>
                                <div class="d-flex justify-content-between mb-3">
                                    <h6>Thành tiền</h6>
                                    <h6><%=listp.get(i).getPrice()*listcart.get(i).getQuantity()%> VNĐ</h6>
                                </div>
                                <%}%>
                                <div class="d-flex justify-content-between">
                                    <h6 class="font-weight-medium">Phí giao hàng</h6>
                                    <h6 class="font-weight-medium">200000 VNĐ</h6>
                                </div>
                            </div>
                            <div class="pt-2">
                                <%if(sumprice !=0){%>
                                <div class="d-flex justify-content-between mt-2">
                                    <h5>Tổng thanh toán:</h5>
                                    <h5><%=ttt%> VNĐ</h5>
                                </div>
                                <%}else{%>
                                <div class="d-flex justify-content-between mt-2">
                                    <h5>Tổng thanh toán:</h5>
                                    <h5>0 VNĐ</h5>
                                </div>
                                <%}%>
                            </div>
                        </div>
                        <div class="mb-5">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Phương thức nhận hàng</span></h5>
                            <div class="bg-light p-30">
                                <div class="form-group">
                                    <div class="custom-control custom-radio">
                                        <input checked type="radio" class="custom-control-input" name="payment" id="paypal">
                                        <label class="custom-control-label" for="paypal">Giao hàng tận nơi</label>
                                    </div>
                                </div> 
<!--                                <div class="form-group mb-4">
                                    <div class="custom-control custom-radio">
                                        <input type="radio" class="custom-control-input" name="payment" id="banktransfer">
                                        <label class="custom-control-label" for="banktransfer">Nhận tại cửa hàng</label>
                                    </div>
                                </div>-->
                                <%if(sumprice != 0){%>
                                    <form action="insertorder" method="GET">
                                    <button type="submit" class="btn btn-block btn-primary font-weight-bold py-3">Đặt hàng</button>
                                    </form>    
                                <%}else{%>
                                    <!--<button type="text" class="btn btn-block btn-primary font-weight-bold py-3">Đặt hàng</button>-->
                                <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!-- Checkout End -->


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
                                <a class="text-secondary" href="#"><i class="fa fa-angle-right mr-2"></i>Liên hệ</a>
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
