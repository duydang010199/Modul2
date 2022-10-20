package services;

import models.OrderItem;
import until.CSVUntil;
import java.util.ArrayList;
import java.util.List;

public class OrderItemServices implements ExtendOrderItemServices{
    private static final String fileName = "C:\\Users\\ADMIN\\OneDrive\\Máy tính\\Modul2\\CaseStudyMD2\\data\\items.csv";
    private static OrderItemServices instanceOrderItem;
    public OrderItemServices(){}
    public static OrderItemServices getInstanceOrderItem(){
        if (instanceOrderItem == null){
            instanceOrderItem = new OrderItemServices();
        }
        return instanceOrderItem;
    }
    @Override
    public List<OrderItem> findAllOrderItem(){
        List<OrderItem> orderItems = new ArrayList<>();
        try {
            List<String> records = CSVUntil.readFile(fileName);
            for (String record : records) {
                orderItems.add(OrderItem.parseItemOrder(record));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return orderItems;
    }
    @Override
    public void addOrderItem (OrderItem newOrderItem){
        List<OrderItem> items = findAllOrderItem();
        items.add(newOrderItem);
        CSVUntil.writeFile(fileName,items);
    }
    @Override
    public void update(Long idOrder, Double price, Double grandTotal){
        List<OrderItem> items = findAllOrderItem();
        for (OrderItem item : items){
            if (item.getIdOrderItem().equals(idOrder)){
                if (item.getPrice().equals(price)){
                    item.setGranTotal(grandTotal);
                    CSVUntil.writeFile(fileName,items);
                    break;
                }
            }
        }
    }

}
