package view;

import menu.Menu;
import models.Order;
import models.OrderItem;
import models.Product;
import services.OderServices;
import services.OrderItemServices;
import services.ProductServices;
import until.AppUtils;
import until.InstantUtils;
import until.ValidateUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    public List<Order> orders;
    private static OderServices oderServices = new OderServices();
    private static ProductServices productServices = new ProductServices();
    private static OrderItemServices orderItemServices = new OrderItemServices();
    private static ProductView productView = new ProductView();
    private static final Scanner scanner = new Scanner(System.in);

    public OrderView() {
        oderServices = OderServices.getInstanceOrder();
        productServices = ProductServices.getInstanceProduct();
        orderItemServices = OrderItemServices.getInstanceOrderItem();
    }

    public static void addOrder() {
        try {
            Long idOrder = System.currentTimeMillis() % 100000;
            System.out.println("Nhập tên người đặt hàng (VD: Duy Dang)");
            System.out.print("  ⭆ ");
            String fullName;
            while (!ValidateUtils.isNameValid(fullName = scanner.nextLine())) {
                System.out.println("Tên " + fullName + " không đúng định dạng! Vui lòng nhập lại (Tên phải viết hoa chữ cái đầu và không có dấu)");
                System.out.print("  ⭆ ");
            }
            System.out.println("Nhập số điện thoại");
            System.out.print("  ⭆ ");
            String phoneNumber = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phoneNumber) || phoneNumber.trim().isEmpty()) {
                System.out.println("Số điện thoại " + phoneNumber + " không đúng định dạng! Vui lòng nhập lại (VD: 0912345678)");
                System.out.print("  ⭆ ");
                phoneNumber = scanner.nextLine();
            }
            System.out.println("Nhập địa chỉ");
            System.out.print("  ⭆ ");
            String address = scanner.nextLine();
            while (address.trim().isEmpty()) {
                System.out.println("Không được để trống! Vui lòng nhập địa chỉ!");
                System.out.print("  ⭆ ");
                address = scanner.nextLine();
            }
            Order order = new Order(idOrder, fullName, phoneNumber, address, Instant.now());
            List<OrderItem> orderItems = addOrderItem(idOrder);
            for (OrderItem orderItem : orderItems) {
                orderItemServices.addOrderItem(orderItem);
            }
            oderServices.add(order);
            confirmOrder(order);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Vui lòng chọn lại!");
        }
    }

    public static List<OrderItem> addOrderItem(Long id) {
        List<OrderItem> orderItems = new ArrayList<>();
        productView.showProductList();
        System.out.println("Nhập số sản phẩm đơn hàng bạn muốn mua");
        System.out.print("  ⭆ ");
        int choose = Integer.parseInt(scanner.nextLine());
        while (choose < 0) {
            System.out.println("Số sản phẩm đơn hàng không hợp lệ (không được nhỏ hơn 0)");
            System.out.print("  ⭆ ");
            choose = Integer.parseInt(scanner.nextLine());
        }
        int count = 0;
        do {
            try {
                orderItems.add(addOrderItems(id));
                count++;
            } catch (Exception e) {
                System.out.println("Không đúng! Vui lòng nhập lại!");
            }
        } while (count < choose);
        return orderItems;
    }

    public static OrderItem addOrderItems(Long idOrder) {

//                orderItemServices.findAllOrderItem();
//                productView.showProductList();
        Long id = System.currentTimeMillis() % 100000;
        System.out.println("Nhập Id sản phẩm bạn muốn mua");
        System.out.print("  ⭆ ");
        Long idProduct = Long.parseLong(scanner.nextLine());
        while (!productServices.exitsById(idProduct)) {
            System.out.println("Id sản phẩm không tồn tại! Vui lòng nhập lại");
            System.out.print("  ⭆ ");
            idProduct = Long.parseLong(scanner.nextLine());
        }
        Product product = productServices.checkId(idProduct);
        Double price = product.getPrice();
        System.out.println("Nhập số lượng bạn muốn mua");
        System.out.print("  ⭆ ");
        Double quantity = Double.parseDouble(scanner.nextLine());
        while (!checkQuantityProduct(product, quantity)) {
            System.out.println("Số lượng sản phẩm không đủ! Vui lòng chọn lại");
            System.out.print("  ⭆ ");
            quantity = Double.parseDouble(scanner.nextLine());
            if (product.getQuantity() == 0) {
                System.out.println("Sản phẩm hết hàng");
                int choose;
                do {
                    System.out.println("Nhấn '0' để quay lại");
                    choose = AppUtils.retryParseInt();
                } while (choose != 0);
                Menu.orderMenu();
            }
        }
        String nameProduct = product.getName();
        Double total = quantity * price;
        Double grandTotal = 0.0;
        OrderItem orderItem = new OrderItem(id, price, quantity, idOrder, idProduct, nameProduct, total, grandTotal);
        productServices.updateQuantity(idProduct, quantity);
        return orderItem;
    }

    public static boolean checkQuantityProduct(Product product, Double quantity) {
        if (quantity <= product.getQuantity()) {
            return true;
        }
        return false;
    }

    public static void confirmOrder(Order order) {
        try {
            int choose;
            System.out.println("Đã tạo order thành công!");
            System.out.println();
            System.out.println("Nhấn '1' để in hóa đơn | Nhấn '2' để quay lại | Nhấn '0' thoát chương trình");
            System.out.print("  ⭆ ");
            do {
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        showPayInfoAdmin(order);
                        break;
                    case 2:
                        Menu.orderMenu();
                        break;
                    case 0:
                        AppUtils.endProgram();
                        break;
                    default:
                        System.out.println("Nhập sai! Vui lòng chọn lại");
                        System.out.print("  ⭆ ");
                }
            } while (choose != 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showPayInfo(Order order) {
        try {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                 HÓA ĐƠN                                   ║");
            System.out.println("╠═════════════════════╤═════════════════════════════════════════════════════╣");
            System.out.printf("║%-20s \t%-30s %16s ║\n", " Tên người đặt       │", order.getName(), "");
            System.out.printf("║%-20s \t%-30s %16s ║\n", " Số điện thoại       │", order.getNumberPhone(), "");
            System.out.printf("║%-20s \t%-30s %16s ║\n", " Địa chỉ             │", order.getAddress(), "");
            System.out.printf("║%-20s \t%-30s %16s ║\n", " Ngày tạo đơn        │", InstantUtils.instantToString(order.getTimeCreatOrder()), "");
            System.out.println("╠════╤════════════════╧═════════════╤══════════════════╤════════════════════╣");
            System.out.printf("║%-3s │\t%-27s │\t%-14s │\t%-15s ║\n", "STT", "Tên sản phẩm", "Số lượng", "Giá");
            System.out.println("╟────┼──────────────────────────────┼──────────────────┼────────────────────╢");
            List<OrderItem> items = orderItemServices.findAllOrderItem();
            double sum = 0;
            int count = 0;
            for (OrderItem orderItem : items) {
                if (orderItem.getIdOrder().equals(order.getIdOder())) {
                    sum += orderItem.getTotal();
                    count++;
                    orderItem.setGranTotal(sum);
                    orderItemServices.update(orderItem.getIdOrder(), orderItem.getPrice(), sum);
                    System.out.printf("║ %-2s │\t%-27s │\t%-14s │\t%-15s ║\n",
                            count,
                            orderItem.getNameProduct(),
                            InstantUtils.quantityProducts(orderItem.getQuantity()),
                            InstantUtils.doubleToVND(orderItem.getPrice()));
                    System.out.println("╟────┼──────────────────────────────┼──────────────────┼────────────────────╢");
                }
            }
            System.out.println("╟────┴──────────────────────────────┴──────────────────┴────────────────────╢");
            System.out.printf("║                                             Tổng tiền: %17s  ║\n", InstantUtils.doubleToVND(sum));
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        } catch (Exception e) {
            System.out.println("Nhập không đúng! Vui lòng nhập lại");
        }
    }

    public static void showPayInfoAdmin(Order order) {
        showPayInfo(order);
        int choose;
        do {
            System.out.println("Nhấn '0' để quay lại");
            choose = AppUtils.retryParseInt();
        } while (choose != 0);
        Menu.orderMenu();
    }

    public static void showListOrder() {
        List<Order> orders = oderServices.findAllOrder();
        List<OrderItem> orderItems = orderItemServices.findAllOrderItem();
        int count = 0;
        double printTotal = 0;
        double total = 0;
        double grandTotal = 0;
        System.out.println();
        System.out.println("═══════════════════════════════════════════════════════════════════════ Danh Sách Hóa Đơn ══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        for (Order order : orders) {
            System.out.println("\t╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.printf("\t║\t%-20s %-50s %-20s %-47s║\n", "Id            : ", order.getIdOder(), "Tên khách hàng :", order.getName());
            System.out.printf("\t║\t%-20s %-50s %-20s %-47s║\n", "Số điện thoại : ", order.getNumberPhone(), "Địa chỉ        : ", order.getAddress());
            System.out.println("\t╠═══════╤═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("\t║\t%-2s │%-10s %-25s %-10s %-20s %-10s %-20s %-10s %-23s║\n", "STT", "", "Tên Sản Phẩm", "", "Số Lượng", "", "Giá", "", "Tổng Tiền Sản Phẩm");
            System.out.println("\t╟───────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╢");
            for (OrderItem itemOrder : orderItems) {
                if (itemOrder.getIdOrder().equals(order.getIdOder())) {
                    count++;
                    total = itemOrder.getPrice() * itemOrder.getQuantity();
                    System.out.printf("\t║\t%-3s │%-10s %-25s %-10s %-20s %-10s %-20s %-10s %-23s║\n",
                            count, "",
                            itemOrder.getNameProduct(), "",
                            InstantUtils.quantityProducts(itemOrder.getQuantity()), "",
                            InstantUtils.doubleToVND(itemOrder.getPrice()), "",
                            InstantUtils.doubleToVND(total));
                    grandTotal += total;
                }
            }
            printTotal += grandTotal;
            System.out.printf("\t╚═══════╧════════════════════════════════════════════════════════════════════════════════════════════════ Tổng Hóa Đơn:  %15s ═══════╝\n\n\n", InstantUtils.doubleToVND(grandTotal));
            grandTotal = 0;
            count = 0;
        }
        System.out.println("\t\t\t\t\t\t\t╔════════════════════════════════════════════════════════════════╗");
        System.out.printf("\t\t\t\t\t\t\t╟───────────── Tổng Doanh Thu: %20s ─────────────╢\n", InstantUtils.doubleToVND(printTotal));
        System.out.println("\t\t\t\t\t\t\t╚════════════════════════════════════════════════════════════════╝\n");
        int choice;
        do {
            System.out.println("Nhấn 0 để quay lại quản lý sản phẩm.");
            System.out.print("=> ");
            choice = AppUtils.retryParseInt();
        } while (choice != 0);
        Menu.orderMenu();
    }
}

//        List<Order> orders = oderServices.findAllOrder();
//        List<OrderItem> orderItems = orderItemServices.findAllOrderItem();
//        OrderItem newOrderItem = new OrderItem();
//        List<OrderItem> orderItemList = new ArrayList<>();
//        try {
//            int count = 0;
//            double printTotal = 0;
//            double total = 0;
//            double sum = 0;
//            double grandTotal = 0;
//            System.out.println();
//            System.out.println("═══════════════════════════════════════════════════════════════════════ Danh Sách Hóa Đơn ══════════════════════════════════════════════════════════════════════════════════════════════════════════");
//            for (Order order : orders) {
//                for (OrderItem orderItem : orderItems) {
//                    if (orderItem.getIdOrder() == order.getIdOder()) {
//                        newOrderItem = orderItem;
//                        orderItemList.add(newOrderItem);
//                        double price = orderItem.getPrice();
//                        double quantity = orderItem.getQuantity();
//                        sum = price * quantity;
//                        grandTotal += sum;
//                    }
//                }
//                newOrderItem.setGranTotal(grandTotal);
//                orderItemServices.update(newOrderItem.getIdOrder(), newOrderItem.getPrice(), grandTotal);
//                System.out.println("\t╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
//                System.out.printf("\t║\t%-20s %-50s %-20s %-47s║\n", "Id            : ", order.getIdOder(), "Tên khách hàng :", order.getName());
//                System.out.printf("\t║\t%-20s %-50s %-20s %-47s║\n", "Số điện thoại : ", order.getNumberPhone(), "Địa chỉ        : ", order.getAddress());
//                System.out.println("\t╠═══════╤═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
//                System.out.printf("\t║\t%-2s │%-10s %-25s %-10s %-20s %-10s %-20s %-10s %-23s║\n", "STT", "", "Tên Sản Phẩm", "", "Số Lượng", "", "Giá", "", "Tổng Tiền Sản Phẩm");
//                System.out.println("\t╟───────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╢");
//                for (OrderItem orderItem : orderItemList) {
//                    count++;
//                    total = orderItem.getPrice() * orderItem.getQuantity();
//                    System.out.printf("\t│\t%-3d │%-1s%-20s%-20s%-10s%-15s%-15d%-10s%-18s%-11s%14s\t│\n", count, "", "", orderItem.getNameProduct(), " ", "", orderItem.getQuantity()
//                            , "", InstantUtils.doubleToVND(orderItem.getPrice())
//                            , "", InstantUtils.doubleToVND(total));
//                }
//                orderItemList.clear();
//                printTotal += grandTotal;
//                System.out.printf("\t╚═══════╧════════════════════════════════════════════════════════════════════════════════════════════════ Tổng Hóa Đơn:  %15s ═══════╝\n\n\n", InstantUtils.doubleToVND(grandTotal));
//                sum = 0;
//                grandTotal = 0;
//                count = 0;
//
//            }
//            System.out.println("\t\t\t\t\t\t\t╔════════════════════════════════════════════════════════════════╗");
//            System.out.printf("\t\t\t\t\t\t\t╟───────────── Tổng Doanh Thu: %20s ─────────────╢\n", InstantUtils.doubleToVND(printTotal));
//            System.out.println("\t\t\t\t\t\t\t╚════════════════════════════════════════════════════════════════╝\n");
//            int choose;
//            do {
//                System.out.println("Nhấn '0' để quay lại");
//                System.out.print("  ⭆ ");
//                choose = AppUtils.retryParseInt();
//            } while (choose != 0);
//            Menu.orderMenu();
//        } catch (Exception e) {
//            System.out.println("Không đúng! Vui lòng nhập lại!");
//        }
//    }


