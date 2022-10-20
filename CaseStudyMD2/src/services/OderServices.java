package services;
import models.Order;
import until.CSVUntil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OderServices implements ExtendOrderServices {
    public static final String fileName = "C:\\Users\\ADMIN\\OneDrive\\Máy tính\\Modul2\\CaseStudyMD2\\data\\order.csv";
    private static OderServices instanceOrder;
    public OderServices(){}
    public static OderServices getInstanceOrder(){
        if (instanceOrder == null){
            instanceOrder = new OderServices();
        }
        return instanceOrder;
    }
    @Override
    public List<Order> findAllOrder(){
        List<Order> orders = new ArrayList<>();
        List<String> document = CSVUntil.readFile(fileName);
        for (String record : document){
            orders.add(Order.parseOrder(record));
        }
        return orders;
    }
    @Override
    public void add(Order newOrder){
        List<Order> orders = findAllOrder();
        newOrder.setTimeCreatOrder(Instant.now());
        orders.add(newOrder);
        CSVUntil.writeFile(fileName,orders);
    }




}
