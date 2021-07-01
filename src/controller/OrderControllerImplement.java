package controller;

import Util.Util;
import entity.Order;
import model.OrderModel;
import model.OrderModelImplement;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class OrderControllerImplement implements OrderController {

    private  OrderModel orderModel;
    private  Scanner scanner;

    public OrderControllerImplement() {
        this.orderModel = new OrderModelImplement();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void creatNewOrder() {

        while (true) {
            try {
                System.out.println("Please enter ID Oder(Require):");
                String id = scanner.nextLine();

                System.out.println("Please enter user Name(Require):");
                String userName = scanner.nextLine();

                System.out.println("Please enter products(Require):");
                String products = scanner.nextLine();

                System.out.println("Please enter total price(Require):");
                int totalPrice = scanner.nextInt();

                System.out.println("Please enter status Oder 0-2 (Require):");
                System.out.println("0.Deleted");
                System.out.println("1.Unpaid");
                System.out.println("2.Paid");
                int status = scanner.nextInt();

                Order newOrder = new Order(id, userName, products, totalPrice, status);
                if (newOrder.getUserName() != null && newOrder.getOrderId() != null && newOrder.getProducts() != null
                        && newOrder.getStatus() >= 0 && newOrder.getStatus() <= 2) {
                    if (orderModel.save(newOrder)) {
                        System.out.println("Success");
                        break;
                    }
                } else {
                    System.out.println("Please enter the correct information!!");
                    scanner.nextLine();
                    continue;
                }

            } catch (Exception ex) {
                System.out.println("Please enter the correct information!!");
                scanner.nextLine();
            }
        }


    }

    @Override
    public void showList() {
        System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%25s%20s | %5s%10s%10s | %5s%15s%10s | %5s%10s%5s |\n",
                "", "ID", "",
                "", "Name", "",
                "", "Products", "",
                "", "CreatAt", "",
                "", "Status", "",
                "", "Total", ""
        );
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Order> list = orderModel.findAll();
        for (Order o : list
        ) {
            System.out.println(o.toString());
        }

    }

    @Override
    public void searchOrderById() {
        System.out.println("Please enter ID Order:");
        String id = scanner.nextLine();
        Order result = orderModel.findById(id);
        if (result == null) {
            System.out.println("Not found!! Please check the information you just entered!!");
        } else {
            System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%20s%25s | %5s%10s%10s | %5s%15s%10s | %5s%10s%5s |\n",
                    "", "ID", "",
                    "", "Name", "",
                    "", "Products", "",
                    "", "CreatAt", "",
                    "", "Status", "",
                    "", "Total", ""
            );
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(result.toString());
        }


    }

    @Override
    public void RevenueByTime() {
        while (true) {
            try {
                System.out.println("Please enter start time follow (yyyy-mm-dd)-(ex: 2021-06-30):");
                String date1 = scanner.nextLine();
                LocalDate dateStart = LocalDate.parse(date1);
                System.out.println("Please enter end time follow (yyyy-mm-dd)-(ex: 2021-06-30):");
                String date2 = scanner.nextLine();
                LocalDate dateEnd = LocalDate.parse(date2);
                List<Order> list = orderModel.findByTime(dateStart, dateEnd);
//
                if (list == null) {
                    System.out.printf("Have no finished order from time %s  to %s\n", dateStart.toString(), dateEnd.toString());
                    break;
                } else {
                    System.out.printf("%5s%10s%10s | %5s%15s%15s | %5s%20s%25s | %5s%10s%10s | %5s%15s%10s | %5s%10s%5s |\n",
                            "", "ID", "",
                            "", "Name", "",
                            "", "Products", "",
                            "", "CreatAt", "",
                            "", "Status", "",
                            "", "Total", ""
                    );
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    int sum = 0;
                    for (Order order : list
                    ) {
                        sum += order.getTotalPrice();
                        System.out.println(order.toString());
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%150s%15s%s%s\n", "", "Total money: ", Util.moneyVND(sum), " (VNĐ)");
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Please check the information you just entered!!");


            }
        }


    }
}