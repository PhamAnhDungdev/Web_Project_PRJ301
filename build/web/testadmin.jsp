<%-- 
    Document   : login
    Created on : Feb 26, 2024, 11:58:53 PM
    Author     : Bravo 15
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                witdh: 40px;
                padding: 20px 50px;
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
    <body>

        <div class="header">
            <div class="store-name">Trống Đọi Tam - Trang quản lí cửa hàng</div>
            <div class="admin-actions">
                <button class="login-btn">Đăng Nhập</button>
                <button class="logout-btn">Đăng Xuất</button>
            </div>
        </div>

        <div class="container">
            <nav class="sidebar">
                <ul>
                    <li><a href="">Trang chủ</a></li>
                    <li><a href="">Quản lý thể loại sản phẩm</a></li>
                    <li><a href="">Quản lý sản phẩm</a></li>
                    <li><a href="">Quản lý order</a></li>
                    <li><a href="">Liên hệ từ khách hàng</a></li>
                    <li><a href="">Feedback của khách hàng</a></li>
                    <li><a href="">Thông tin khách hàng</a></li>
                </ul>
            </nav>

            <div class="main-content">
                <div class="table-container">
                    <h2>Bảng Quản Lý 1</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Column 1</th>
                                <th>Column 2</th>
                                <th>Column 3</th>
                                <th>Column 1</th>
                                <th>Column 2</th>
                                <th>Column 3</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Data 1</td>
                                <td>Data 2</td>
                                <td>Data 3</td>
                                <td>Data 1</td>
                                <td>Data 2</td>
                                <td>Data 3</td>
                            </tr>
                            
                        </tbody>
                    </table>
                </div>
                <div class="table-container">
                    <h2>Bảng Quản Lý 1</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Column 1</th>
                                <th>Column 2</th>
                                <th>Column 3</th>
                                <th>Column 1</th>
                                <th>Column 2</th>
                                <th>Column 3</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Data 1</td>
                                <td>Data 2</td>
                                <td>Data 3</td>
                                <td>Data 1</td>
                                <td>Data 2</td>
                                <td>Data 3</td>
                            </tr>
                            
                        </tbody>
                    </table>
                </div>
                
            </div>
        </div>
        
        
        
        <footer class="footer">
            <p>@Sản phẩm thực hành của sinh viên trường Đại Học FPT Hà Nội. Không mang tính chất thương mại.</p>
        </footer>
    </body>
</html>


