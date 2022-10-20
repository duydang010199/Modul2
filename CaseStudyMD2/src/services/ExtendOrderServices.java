package services;

import models.Order;

import java.util.List;

public interface ExtendOrderServices {
    List<Order> findAllOrder();
    void add(Order newOrder);

}
