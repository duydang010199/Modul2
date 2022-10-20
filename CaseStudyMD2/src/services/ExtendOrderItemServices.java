package services;

import models.OrderItem;

import java.util.List;

public interface ExtendOrderItemServices {
    List<OrderItem> findAllOrderItem();
    void addOrderItem (OrderItem newOrderItem);
    void update(Long idOrder, Double price, Double grandTotal);

}
