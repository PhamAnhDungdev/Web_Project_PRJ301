# Dự án: Shop Bán Trống

## Giới thiệu
Dự án **Shop Bán Trống** được xây dựng nhằm cung cấp một nền tảng trực tuyến để bán các loại trống như trống jazz, trống điện tử, và các phụ kiện liên quan. Hệ thống được thiết kế đơn giản nhưng đầy đủ tính năng để đáp ứng nhu cầu của người dùng.

## Thông tin cá nhân
- **Họ và tên**: Phạm Anh Dũng  
- **Kỳ học**: 5  
- **Trường**: Đại Học FPT  

## Các tính năng chính
1. **Quản lý danh mục sản phẩm:**
   - Hiển thị danh sách các loại trống với mô tả chi tiết.
   - Hỗ trợ tìm kiếm và lọc sản phẩm theo loại, giá.

2. **Giao dịch trực tuyến:**
   - Quản lý giỏ hàng và đặt hàng.
   - Hỗ trợ thông báo trạng thái đơn hàng.

3. **Quản trị hệ thống:**
   - Quản lý sản phẩm, khách hàng, và đơn hàng.
   - Xem báo cáo doanh thu theo ngày, tháng.

4. **Giao diện người dùng:**
   - Thiết kế giao diện trực quan, thân thiện.
   - Responsive hỗ trợ cả trên máy tính và thiết bị di động.

## Công nghệ sử dụng
- **Backend**: Java (Servlet, JSP)
- **Frontend**: HTML, CSS, JavaScript
- **Cơ sở dữ liệu**: MySQL
- **IDE**: Eclipse, NetBeans
- **Triển khai**: Apache Tomcat

## Cấu trúc dự án
├── src/ │ ├── dao/ # Data Access Layer (Xử lý cơ sở dữ liệu) │ ├── model/ # Lớp đối tượng (Entity) │ ├── servlet/ # Controller (Servlet) │ └── utils/ # Tiện ích chung ├── web/ │ ├── css/ # Tệp CSS │ ├── js/ # Tệp JavaScript │ └── views/ # Giao diện JSP ├── resources/ │ └── db.sql # Câu lệnh tạo và khởi tạo cơ sở dữ liệu └── README.md # Tệp hướng dẫn dự án

## Hướng dẫn cài đặt
1. **Yêu cầu hệ thống**:
   - Java 8 hoặc mới hơn.
   - MySQL 5.7 hoặc mới hơn.
   - Apache Tomcat 9 hoặc mới hơn.

2. **Các bước cài đặt**:
   - Clone dự án từ GitHub:  
     ```bash
     git clone https://github.com/username/drum-shop.git
     ```
   - Cấu hình cơ sở dữ liệu:
     - Tạo một cơ sở dữ liệu mới trong MySQL.
     - Nhập tệp `db.sql` vào cơ sở dữ liệu.
   - Cập nhật thông tin kết nối cơ sở dữ liệu:
     ```java
     // Ví dụ trong utils/DatabaseUtils.java
     String DB_URL = "jdbc:mysql://localhost:3306/drum_shop";
     String USER = "root";
     String PASS = "password";
     ```
   - Triển khai dự án trên Apache Tomcat.
   - Truy cập ứng dụng tại `http://localhost:8080`.

## Tác giả
- **Họ và tên**: Phạm Anh Dũng  
- **Liên hệ**: phamdung2672004@gmail.com  
- **GitHub**: [github.com/PhamAnhDungdev](https://github.com/PhamAnhDungdev)

---

Cảm ơn bạn đã quan tâm đến dự án! Nếu bạn có câu hỏi hoặc góp ý, hãy liên hệ với tôi để được hỗ trợ.
