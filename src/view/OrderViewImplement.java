package view;

import controller.OrderController;
import controller.OrderControllerImplement;

import java.util.Scanner;

public class OrderViewImplement implements OrderView {
    private final OrderControllerImplement orderController;
    private final Scanner scanner;

    public OrderViewImplement() {
        this.orderController = new OrderControllerImplement();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void Menu() {
        Boolean isMenu = true;
        while (isMenu){
            System.out.println("Order Manager");
            System.out.println("-------------------------");
            System.out.println("1.Add new order");
            System.out.println("2.Show.");
            System.out.println("3.Search order by id.");
            System.out.println("4.Revenue by time.");
            System.out.println("0.Exist.");
            System.out.println("-------------------------");
            System.out.println("Please choice 0-4");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    orderController.creatNewOrder();
                    break;
                case 2:
                    orderController.showList();
                    break;
                case 3:
                    orderController.searchOrderById();
                    break;
                case 4:
                    orderController.RevenueByTime();
                    break;
                case 0:
                    System.out.println("Bye bye!");
                    isMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please choose 1-4");
                    break;
            }
            if (isMenu){
                System.out.println("Please enter to continue!!");
                scanner.nextLine();
            }

        }

    }
}
