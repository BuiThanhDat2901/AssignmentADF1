package model;

import entity.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderModelImplement implements OrderModel {
    private List<Order> list;

    public OrderModelImplement() {
    }

    {
        list = new ArrayList<>();
        list.add(new Order("001", "Dat A", "thịt lợn,", LocalDate.of(2021, 01, 1), 100000, 0));
        list.add(new Order("002", "Dat B", "thịt bò,", LocalDate.of(2021, 02, 2), 200000, 1));
        list.add(new Order("003", "Dat C", "thịt gà,", LocalDate.of(2021, 03, 3), 300000, 2));
        list.add(new Order("004", "Dat D", "thịt chó,", LocalDate.of(2021, 04, 4), 400000, 0));
        list.add(new Order("005", "Dat E", "thịt mèo,", LocalDate.of(2021, 05, 5), 500000, 1));
        list.add(new Order("006", "Dat F", "thịt dê,", LocalDate.of(2021, 06, 6), 600000, 2));
        list.add(new Order("007", "Dat G", "thịt vịt,", LocalDate.of(2021, 07, 7), 700000, 2));
        list.add(new Order("008", "Dat H", "thịt ngan,", LocalDate.of(2021, 05, 8), 800000, 1));
        list.add(new Order("009", "Dat I", "thịt ngỗng,", LocalDate.of(2021, 05, 9), 900000, 2));
        list.add(new Order("010", "Dat J", "thịt cá,", LocalDate.of(2021, 10, 10), 1000000, 1));
    }

    @Override
    public boolean save(Order obj) {
        list.add(obj);
        return true;
    }

    @Override
    public List<Order> findAll() {
        return list;
    }

    @Override
    public Order findById(String id) {
        for (Order order : list) {
            if (order.getOrderId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findByTime(LocalDate startTime, LocalDate endTime) {

        List<Order> newList = new ArrayList<>();
        for (Order order : list) {
            if (startTime.compareTo(order.getCreatAt()) <= 0
                    && endTime.compareTo(order.getCreatAt()) >= 0 && order.getStatus() == 2) {
                newList.add(order);
            }
        }
        if (newList.size() > 0) {
            return newList;
        }
        return null;
    }
}
