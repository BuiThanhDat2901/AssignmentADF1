package model;

import entity.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public interface OrderModel {
    boolean save(Order obj);
    List<Order> findAll();
    Order findById(String id);
    List<Order> findByTime(LocalDate startTime, LocalDate endTime);
}
