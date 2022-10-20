package models;
import java.time.Instant;

public class Order {
    private Long idOder;
    private String name;
    private String numberPhone;
    private String address;
    private Instant timeCreatOrder;

    public Order(){}

    public Order(Long idOder, String name, String numberPhone, String address, Instant timeCreatOrder) {
        this.idOder = idOder;
        this.name = name;
        this.numberPhone = numberPhone;
        this.address = address;
        this.timeCreatOrder = timeCreatOrder;
    }


    public static Order parseOrder(String document){
        Order order = new Order();
        String[] array = document.split(",");
        order.setIdOder(Long.parseLong(array[0]));
        order.setName(array[1]);
        order.setNumberPhone(array[2]);
        order.setAddress(array[3]);
        order.setTimeCreatOrder(Instant.parse(array[4]));
        return order;
    }
    public Long getIdOder() {
        return idOder;
    }

    public void setIdOder(Long idOder) {
        this.idOder = idOder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Instant getTimeCreatOrder() {
        return timeCreatOrder;
    }

    public void setTimeCreatOrder(Instant timeCreatOrder) {
        this.timeCreatOrder = timeCreatOrder;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",
                idOder,
                name,
                numberPhone,
                address,
                timeCreatOrder);
    }
}
