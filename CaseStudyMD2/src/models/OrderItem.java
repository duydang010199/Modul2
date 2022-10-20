package models;

public class OrderItem {
    private Long idOrderItem;
    private Double price;
    private Double quantity;
    private Long idOrder;
    private Long idProduct;
    private String nameProduct;
    private Double total;
    private Double grandTotal;
    public OrderItem(){}

    public OrderItem(Long id, Double price, Double quantity, Long idOrder, Long idProduct, String nameProduct, Double total, Double grandTotal) {
        this.idOrderItem = id;
        this.price = price;
        this.quantity = quantity;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.total = total;
        this.grandTotal = grandTotal;
    }
    public static OrderItem parseItemOrder(String document){
        OrderItem orderItem = new OrderItem();
        String[] array = document.split(",");
        orderItem.idOrderItem = Long.parseLong(array[0]);
        orderItem.price = Double.parseDouble(array[1]);
        orderItem.quantity = Double.parseDouble(array[2]);
        orderItem.idOrder = Long.parseLong(array[3]);
        orderItem.idProduct = Long.parseLong(array[4]);
        orderItem.nameProduct = array[5];
        orderItem.total = Double.parseDouble(array[6]);
        orderItem.grandTotal = Double.parseDouble(array[7]);
        return orderItem;
    }

    public Long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Long idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGranTotal(Double granTotal) {
        this.grandTotal = granTotal;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                idOrderItem,
                price,
                quantity,
                idOrder,
                idProduct,
                nameProduct,
                total,
                grandTotal);
    }
}
