package view;

import menu.Menu;
import models.Product;
import services.ProductServices;
import until.AppUtils;
import until.InstantUtils;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static Scanner scanner = new Scanner(System.in);
    public static ProductServices productServices = new ProductServices();

    public void addProduct() {
            System.out.println("═══════════════»» THÊM SẢN PHẨM ««═══════════════");
            Long productId = System.currentTimeMillis() % 100000;
            String nameProduct = inputName(ChoiceStatus.ADD);
            String colorProduct = inputColor(ChoiceStatus.ADD);
            Double priceProduct = inputPrice(ChoiceStatus.ADD);
            Double quantity = Double.valueOf(inputQuantity(ChoiceStatus.ADD));
            Product product = new Product(productId, nameProduct, colorProduct, priceProduct, quantity);
            productServices.add(product);
            System.out.println("Đã thêm sản phẩm thành công!");
            Menu.menuProductManager();
    }

    private static Integer inputQuantity(ChoiceStatus add) {
        Integer quantity;
        switch (add) {
            case ADD:
                System.out.println("Nhập số lượng sản phẩm");
                break;
            case EDIT:
                System.out.println("Số lượng mới");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = true;
        do {
            quantity = AppUtils.retryParseInt();
            boolean exits = (quantity > 0);
            switch (add) {
                case ADD:
                case EDIT:
                case REMOVE:
                    if (!exits) {
                        System.out.println("Bạn nhập sai định dạng (Số lượng phải lớn hơn 0)");
                        System.out.println(" ⭆ ");
                    }
                    flag = !exits;
                    break;
            }
        } while (flag);
        return quantity;
    }

    private static Double inputPrice(ChoiceStatus add) {
        Double price;
        switch (add) {
            case ADD:
                System.out.println("Nhập giá sản phẩm ");
                break;
            case EDIT:
                System.out.println("Nhập giá mới");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = true;
        do {
            price = AppUtils.retryParseDoble();
            boolean exits = (price > 1000);
            switch (add) {
                case ADD:
                case EDIT:
                case REMOVE:
                    if (!exits) {
                        System.out.println("Bạn nhập sai định dạng (giá tiền lớn hơn 1000 đồng)! Vui lòng nhập lại!");
                        System.out.print(" ⭆ ");
                    }
                    flag = !exits;
                    break;
            }
        } while (flag);
        return price;
    }

    private static String inputColor(ChoiceStatus add) {
        String color;
        switch (add) {
            case ADD:
                System.out.println("Nhập màu sắc sản phẩm ");
                break;
            case EDIT:
                System.out.println("Nhập màu mới");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = true;
        do {
            color = scanner.nextLine().trim();
            boolean exits = (!color.isEmpty());
            switch (add) {
                case ADD:
                case EDIT:
                    if (!exits) {
                        System.out.println("Bạn nhập sai định dạng! Vui lòng nhập lại!");
                        System.out.print(" ⭆ ");
                    }
                    flag = !exits;
                    break;
            }
        } while (flag);
        return color;
    }

    private static String inputName(ChoiceStatus add) {
        String name;
        switch (add) {
            case ADD:
                System.out.println("Nhập tên sản phẩm");
                break;
            case EDIT:
                System.out.println("Nhập tên sản phẩm mới");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = false;
        do {
            name = scanner.nextLine().trim();
            boolean exits = (name.isEmpty());
            switch (add) {
                case ADD:
                case EDIT:
                    if (exits) {
                        System.out.println("Bạn nhập sai định dạng! Vui lòng nhập lại!");
                        System.out.print(" ⭆ ");
                    }
                    flag = exits;
                    break;
            }
        } while (flag);
        return name;
    }

    public static void menuEditInfomation() {
        System.out.println();
        System.out.println("    ╔═════════»» EDIT PRODUCT INFORMATION ««══════════╗");
        System.out.println("    ║                                                 ║");
        System.out.println("    ║          1. Sửa tên sản phẩm                    ║");
        System.out.println("    ║          2. Sửa màu sản phẩm                    ║");
        System.out.println("    ║          3. Sửa giá sản phẩm                    ║");
        System.out.println("    ║          4. Sửa số lượng sản phẩm               ║");
        System.out.println("    ║                                                 ║");
        System.out.println("    ║    Nhấn '8' trở lại    |    Nhấn '0' để thoát   ║");
        System.out.println("    ╚═════════════════════════════════════════════════╝");
        System.out.println("  Chọn chức năng ");
        System.out.print("  ⭆ ");
    }

    public void editProductInformation() {
        try {
            showProductList();
            System.out.println("Nhập ID sản phẩm cần sửa");
            System.out.print("  ⭆ ");
            Long id = AppUtils.retryParseLong();
            if (productServices.exitsById(id)) {
                menuEditInfomation();
                Product newProduct = new Product();
                newProduct.setId(id);
                String choose;
                do {
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            editNameProduct(newProduct);
                            menuEditInfomation();
                            break;
                        case "2":
                            editColorProduct(newProduct);
                            menuEditInfomation();
                            break;
                        case "3":
                            editPriceProduct(newProduct);
                            menuEditInfomation();
                            break;
                        case "4":
                            editQuantityProduct(newProduct);
                            menuEditInfomation();
                            break;
                        case "8":
                            Menu.menuProductManager();
                            break;
                        case "0":
                            AppUtils.endProgram();
                            break;
                        default:
                            System.out.println("Không hợp lệ! Vui lòng nhập lại!");
                            System.out.print("  ⭆ ");
                    }
                } while (choose != "8");
            } else {
                System.out.println("Không tìm thấy Id sản phẩm!");
                ContinueOrBack();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void editQuantityProduct(Product newProduct) {
        Double quantity = Double.valueOf(inputQuantity(ChoiceStatus.EDIT));
        newProduct.setQuantity(quantity);
        productServices.editQuantityProduct(newProduct);
        System.out.println("Số lượng đã được cập nhật");
        showProductList();
    }

    private void editPriceProduct(Product newProduct) {
        Double price = inputPrice(ChoiceStatus.EDIT);
        newProduct.setPrice(price);
        productServices.editPriceProduct(newProduct);
        System.out.println("Giá đã được cập nhật!");
        showProductList();
    }

    private void editColorProduct(Product newProduct) {
        String color = inputColor(ChoiceStatus.EDIT);
        newProduct.setColor(color);
        productServices.editColorProduct(newProduct);
        System.out.println("Màu đã được cập nhật!");
        showProductList();
    }


    private void editNameProduct(Product newName) {
        String name = inputName(ChoiceStatus.EDIT);
        newName.setName(name);
        productServices.editNameProduct(newName);
        System.out.println("Tên sản phẩm đã được cập nhật!");
        showProductList();
    }

    public static Long inputIdProduct(ChoiceStatus status) {
        Long idProduct;
        switch (status) {
            case EDIT:
            case REMOVE:
                System.out.println("Nhập ID sản phẩm cần xóa:");
                break;
        }
        System.out.print("  ⭆ ");
        boolean flagInputID = true;
        do {
            idProduct = AppUtils.retryParseLong();
            boolean exits = productServices.exitsById(idProduct);
            switch (status) {
                case EDIT:
                case REMOVE:
                    if (!exits) {
                        System.out.println("Không tìm thấy ID, vui lòng nhập lại:");
                        System.out.print("  ⭆ ");
                    }
                    flagInputID = !exits;
                    break;
            }
        } while (flagInputID);
        return idProduct;
    }

    public void removeProduct() {
        try {
            showProductList();
            Long id = inputIdProduct(ChoiceStatus.REMOVE);
            System.out.println();
            System.out.println(" Nhấn 'y' để đồng ý   |   Nhấn 'b' để quay lại ");
            System.out.print("  ⭆ ");
            String choose;
            do {
                choose = scanner.nextLine();
                switch (choose) {
                    case "y":
                        productServices.removeProduct(id);
                        System.out.println("Sản phẩm đã được xóa!");
                        showProductList();
                        System.out.println("Nhấn 'b' để quay lại");
                        System.out.print("  ⭆ ");
                        break;
                    case "b":
                        Menu.menuProductManager();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
                        System.out.print("  ⭆ ");
                }
            } while (choose != "b");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void findProduct() {
        showProductList();
        System.out.println("Nhập tên sản phẩm bạn muốn tìm");
        System.out.print("  ⭆ ");
        String name = scanner.nextLine().trim().toLowerCase();
        List<Product> products = productServices.findProductByName(name);
        if (products.size() != 0){
            System.out.println();
            System.out.println("══════════════════════════════════ Sản phẩm bạn cần tìm là ═══════════════════════════════════════");
            System.out.printf("%-25s %-20s %-20s %-20s %-20s\n", "ID", "Tên Sản Phẩm","Màu sắc", "Số lượng", "Giá");
            System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────");
            for (Product product : products){
                System.out.printf("%-25s %-20s %-20s %-20s %-20s\n",
                        product.getId(),
                        product.getName(),
                        product.getColor(),
                        InstantUtils.quantityProducts(product.getQuantity()),
                        InstantUtils.doubleToVND(product.getPrice()));
            }
            System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════");
            String choose;
            do {
                System.out.println("Nhấn '0' để quay lại");
                System.out.print("  ⭆ ");
                choose = scanner.nextLine();
                switch (choose){
                    case "0":
                        Menu.menuProductManager();
                        break;
                    default:
                        System.out.println("Nhập sai! Vui lòng nhập lại!");
                }

            } while (choose != "0");
        } else {
            System.out.println("Không tìm thấy tên " + name + " trong danh sách!");
            String choose;
            do {
                System.out.println("Nhấn '0' để quay lại");
                System.out.print("  ⭆ ");
                choose = scanner.nextLine();
                switch (choose){
                    case "0":
                        Menu.menuProductManager();
                        break;
                    default:
                        System.out.println("Nhập sai! Vui lòng nhập lại!");
                }

            } while (choose != "0");
        }

    }

    public void showProductList() {
        System.out.println();
        System.out.println("  ══════════════════════════════════════ Danh Sách Sản Phẩm ═════════════════════════════════════════");
        System.out.printf("  %-25s %-20s %-20s %-20s %-20s\n", "ID", "Tên Sản Phẩm", "Màu sắc", "Số lượng", "Giá");
        System.out.println("  ───────────────────────────────────────────────────────────────────────────────────────────────────");
        for (Product product : productServices.findAllProduct()) {
            System.out.printf("%-25s %-20s %-20s %-20s %-20s\n",
                    product.getId(),
                    product.getName(),
                    product.getColor(),
                    InstantUtils.quantityProducts(product.getQuantity()),
                    InstantUtils.doubleToVND(product.getPrice()));
        }
        System.out.println("  ═══════════════════════════════════════════════════════════════════════════════════════════════════");
    }
    public void showProductOnTheScreen(){
        showProductList();
        String choose;
        do {
            System.out.println("Nhấn '0' để quay lại");
            System.out.print("  ⭆ ");
            choose = scanner.nextLine();
            switch (choose) {
                case "0":
                    Menu.menuProductManager();
                    break;
                default:
                    System.out.println("Nhập sai! Vui lòng nhập lại!");
            }
        } while (choose != "0");
    }

    public void ContinueOrBack() {
        boolean flag = true;
        do {
            System.out.println("  Nhấn 'c' để tiếp tục  |  Nhấn 'b' để quay lại");
            System.out.print("  ⭆ ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "c":
                    editProductInformation();
                    break;
                case "b":
                    Menu.menuProductManager();
                    break;
                default:
                    System.out.println("Lựa chọn sai! Vui lòng chọn lại!");
                    System.out.print("  ⭆ ");
                    flag = false;
                    break;
            }
        } while (!flag);
    }

}
