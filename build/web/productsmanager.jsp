<%-- 
    Document   : adminhome
    Created on : Mar 7, 2024, 2:45:57 PM
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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản lí cửa hàng</title>
        <link rel="stylesheet" href="styles.css">

        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            header {
                background-color: #333;
                color: #fff;
                padding: 10px;
                text-align: center;
                /*margin-bottom: 10px;*/
            }

            .container {
                display: flex;
            }

            .sidebar {
                background-color: #ffd700; /* Màu nền vàng */
                width: 250px;
                height: 90vh; /* Kéo dài thanh sidebar hết màn hình */
                overflow-y: auto; /* Thêm thanh cuộn nếu nội dung quá dài */
            }

            .sidebar ul {
                list-style-type: none;
                padding: 0;
            }

            .sidebar li {
                margin-bottom: 10px;
            }

            .sidebar a {
                display: block;
                padding: 10px;
                text-decoration: none;
                color: #333;
                border-radius: 5px;
            }

            .sidebar a:hover {
                background-color: #f0e68c; /* Màu nền khi hover */
            }

            /*            .main-content {
                            display: flex;
                            flex-wrap: wrap;
                            justify-content: flex-start;
                            witdh: 100%;
                        }*/

            .table-container {
                /*flex: 1;*/
                witdh: 100%;
                padding: 20px;
                background-color: #fff;
                margin: 10px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }


            table th, table td {
                witdh: 10px;
                padding: 15px 15px;
                border: 1px solid #ddd;
            }

            table th {
                background-color: #f2f2f2;
            }
            .header {
                background-color: #2E2E2E;
                color: #fff; /* Màu chữ trắng */
                padding: 20px 0px;
                display: flex;
                justify-content: space-around;
                align-items: center;
            }

            .store-name {
                font-size: 20px;
            }

            .admin-actions {
                display: flex;
                gap: 10px;
                margin-left: 30px;
            }

            .login-btn, .logout-btn {
                padding: 8px 16px;
                border: none;
                border-radius: 4px;
                background-color: #ffd700; /* Màu nền button */
                color: #fff; /* Màu chữ button */
                cursor: pointer;
            }

            .login-btn:hover, .logout-btn:hover {
                background-color: #f0e68c; /* Màu nền button khi hover */
            }
            /*footer*/
            .footer {
                background-color: #2E2E2E; /* Màu nền đen */
                color: #fff; /* Màu nâu đen */
                text-align: center;
                padding: 10px;
            }

        </style>
    </head>
    <%
        ProductsDAO u = new ProductsDAO();
        List<Products> listp = (List<Products>) u.getAllProducts();
        
        CategoriesDAO c = new CategoriesDAO();
        List<Categories> listc = (List<Categories>) c.getListCategories();
    %>
    <body>

        <div class="header">
            <div class="store-name">Trống Đọi Tam - Trang quản lí cửa hàng</div>
            <c:choose>
                <c:when test="${empty sessionScope.admin}">
                    <div class="admin-actions">
                        <button class="login-btn"><a href="login.jsp" style="text-decoration: none">Đăng Nhập</a></button>
                        <button class="logout-btn"><a href="" style="text-decoration: none">Đăng Xuất</a></button>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="admin-actions">
                        <button class="login-btn"><a href="login.jsp" style="text-decoration: none">Hello admin, ${sessionScope.admin.getLastname()} ${sessionScope.admin.getFirstname()}</a></button>
                        <button class="logout-btn"><a href="logoutadmin" style="text-decoration: none">Đăng Xuất</a></button>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="container">
            <nav class="sidebar">
                <ul>
                    <li><a href="adminhome.jsp">Trang chủ</a></li>
                    <li><a href="categoriesmanager.jsp">Quản lý thể loại sản phẩm</a></li>
                    <li><a href="productsmanager.jsp">Quản lý sản phẩm</a></li>
                    <li><a href="ordermanager.jsp">Quản lý đơn hàng</a></li>
                    <li><a href="contactmanager.jsp">Liên hệ từ khách hàng</a></li>
                    <li><a href="feedbackmanager.jsp">Feedback của khách hàng</a></li>
                    <!--<li><a href="infousermanager.jsp">Thông tin khách hàng</a></li>-->
                </ul>
            </nav>

            <div class="main-content">
                <div class="table-container">
                    <h2>Thêm mới sản phẩm</h2>
                    <form action="insertproduct" method="GET">
                        Tên: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="text" value="" name="name"/> </br> </br>

                        Giá: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="text" value="" name="price"/> </br> </br>

                        Tiêu đề:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="text" value="" name="title"/> </br> </br>

                        <label for="fileInput">
                            Hình ảnh: &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                            <input style="width: 200px; height: 25px" type="file" id="fileInput" value="" name="image"/>
                        </label></br> </br>

                        Mô tả: &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="text" value="" name="describe"/> </br> </br>

                        Thể loại: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select style="width: 170px; height: 25px;" name="cid"> 
                            <% for(Categories x: listc) { %>
                            <option checked value="<%=x.getId()%>"><%=x.getName()%></option>
                            <% } %>
                        </select></br> </br>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input style="witdh: 200px; height: 30px; font-size: 20px" type="submit" value="Thêm mới"/>
                    </form>
                </div>

                <c:choose>
                    <c:when test="${empty requestScope.thongbao}">
                    </c:when>
                    <c:otherwise>
                        <div class="table-container">
                            <h3>${requestScope.thongbao}</h3>
                        </div> 
                    </c:otherwise>
                </c:choose>
                <div class="table-container">
                    <h2>Bảng Quản Lý Sản Phẩm</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tiêu đề - Tên</th>
                                <th>Giá</th>
                                <th>Hình ảnh </th>
                                <th>Ngày phát hành</th>
                                <!--<th>Mô tả</th>-->
                                <th>Thể loại</th>
                                <th>Lựa chọn</th>
                            </tr>
                        </thead>
                        <%for (int i = 0; i < listp.size(); i++) {%>
                        <tbody>
                            <tr>
                                <td><%=listp.get(i).getId()%></td>
                                <td><%=listp.get(i).getTitle()%></td>
                                <td><%=listp.get(i).getPrice()%></td> 
                                <td><img style="width: 90px; height: 90px" src="image/<%=listp.get(i).getImage()%>"></td>
                                <!--<td><%=listp.get(i).getDescribe()%></td>-->
                                <td><%=listp.get(i).getDate()%></td>
                                <td><%=listp.get(i).getCategory().getName()%></td>
                                <td>
                                    <button><a style="text-decoration: none" href="updateproducts?id=<%=listp.get(i).getId()%>">Cập nhật</a></button>
                                    <button><a style="text-decoration: none" href="deleteproducts?id=<%=listp.get(i).getId()%>">Xóa </a></button>
                                </td>
                            </tr>
                        </tbody>
                        <%}%>
                    </table>
                    <p><button onclick='window.history.go(-1);'>Quay về trang trước</button>
                    <p><button><a style="text-decoration: none" href="adminhome.jsp">Quay về trang chủ</a></button>
                </div>
            </div>
        </div>



        <footer class="footer">
            <p>@Sản phẩm thực hành của sinh viên trường Đại Học FPT Hà Nội. Không mang tính chất thương mại.</p>
        </footer>
    </body>
</html>




