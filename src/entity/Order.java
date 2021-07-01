package entity;

import Util.Util;

import java.time.LocalDate;

public class Order {
    //    Mã đơn hàng (ví dụ: “Order001”, “Order002”)
    //    Tên người mua (lưu dạng chuỗi, không có lớp User ở đây, ví dụ: “Xuân Hùng” )
    //    Tên các sản phẩm (đơn giản lưu tên các sản phẩm có trong đơn hàng, không có lớp Product ở đây, ví dụ: 2 mớ rau, 1kg thịt, 2kg táo….)
    //    Tổng số tiền (dạng số, đơn vị vnd).
    //    Ngày tạo đơn hàng (định dạng ngày tháng theo format yyyy-MM-DD).
    //    Trạng thái đơn hàng (1. Chưa thanh toán. 2. Đã thanh toán. 0. Đã xoá)
    private String orderId;
    private String userName;
    private String products;
    private LocalDate creatAt;
    private int totalPrice;
    private int status;
    private Util util;

    public Order() {

    }

    @Override
    public String toString() {

        return String.format("%5s%10s%10s | %5s%15s%15s | %5s%20s%20s | %5s%10s%10s | %5s%15s%10s | %5s%10s%5s |\n",
                "", orderId, "",
                "", userName, "",
                "", products, "",
                "", this.getCreatAt(), "",
                "", this.handleStatus(), "",
                "", this.handleMoney(), ""
        );
    }

    public Order(String orderId, String userName, String products, LocalDate creatAt, int totalPrice, int status) {
        this.orderId = orderId;
        this.userName = userName;
        this.products = products;
        this.creatAt = creatAt;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Order(String orderId, String userName, String products, int totalPrice, int status) {
        if (orderId.length() > 0 && userName.length() > 0 && products.length() > 0 && status >= 0 && status <= 2) {
            this.orderId = orderId;
            this.userName = userName;
            this.products = products;
            this.totalPrice = totalPrice;
            this.status = status;
            this.creatAt = LocalDate.now();
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if (orderId.length() > 0) {
            this.orderId = orderId;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName.length() > 0) {
            this.userName = userName;
        }
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        if (products.length() > 0) {
            this.products = products;
        }

    }

    public LocalDate getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDate creatAt) {
        try {
            this.creatAt = creatAt;
        } catch (Exception ex) {
            System.out.println("Fails");
        }

    }

    public String handleMoney() {
        this.util = new Util();
        return util.moneyVND(this.totalPrice) + " VNĐ";
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status >= 0 && status <= 2) {
            this.status = status;
        }
    }

    public String handleStatus() {
        int number = this.status;
        if (number == 1) return "Chưa thanh toán";
        if (number == 2) return "Thanh toán";
        if (number == 0) return "Đã xóa";
        return null;
    }
}
