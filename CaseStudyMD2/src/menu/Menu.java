package menu;


import models.OrderItem;
import until.AppUtils;
import view.OrderView;
import view.ProductView;
import view.UserView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static ProductView productView = new ProductView();
    public static UserView userView = new UserView();
    public static Scanner scanner = new Scanner(System.in);

    public static void loginMenu() {
        try {
            boolean flag = true;
            System.out.println("    ╔════════════»» LOGIN ««═════════════╗");
            System.out.println("    ║                                    ║");
            System.out.println("    ║          1. Đăng nhập              ║");
            System.out.println("    ║          2. Tạo tài khoản          ║");
            System.out.println("    ║                                    ║");
            System.out.println("    ║   Nhấn '0' để thoát chương trình   ║");
            System.out.println("    ╚════════════════════════════════════╝");
            System.out.println(" Chọn chức năng ");
            System.out.print("  ⭆ ");
            do {
                String choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        UserView.login();
                        break;
                    case "2":
                        UserView.createAccount();
                        break;
                    case "0":
                        AppUtils.endProgram();
                        break;
                    default:
                        System.out.println("Không hợp lệ! Vui lòng nhập lại!");
                        System.out.print("  ⭆ ");
                        flag = false;
                }
            } while (!flag);

        } catch (InputMismatchException o) {
            o.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show() {
        try {
            boolean flag = true;
            System.out.println();
            System.out.println("    ╔═════════════»»  MENU WAREHOUSE ««═════════════╗");
            System.out.println("    ║                                               ║");
            System.out.println("    ║            1. Quản lý người dùng              ║");
            System.out.println("    ║            2. Quản lý mặt hàng                ║");
            System.out.println("    ║            3. Quản lý hóa đơn                 ║");
            System.out.println("    ║                                               ║");
            System.out.println("    ║    Nhấn '8' đăng xuất  |  Nhấn '0' để thoát   ║");
            System.out.println("    ╚═══════════════════════════════════════════════╝");
            System.out.println("  Chọn chức năng ");
            System.out.print("  ⭆ ");
            do {
                String choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        menuUsersManager();
                        break;
                    case "2":
                        menuProductManager();
                        break;
                    case "3":
                        orderMenu();
                        break;
                    case "8":
                        loginMenu();
                        break;
                    case "0":
                        AppUtils.endProgram();
                        break;
                    default:
                        System.out.println("Không hợp lệ! Vui lòng nhập lại!");
                        System.out.print("  ⭆ ");
                        flag = false;
                }


            } while (!flag);
        } catch (InputMismatchException o) {
            o.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void menuUsersManager() {
        try {
            System.out.println();
            System.out.println("    ╔════════════════»»  USERS  MANAGER  ««════════════════╗");
            System.out.println("    ║                                                      ║");
            System.out.println("    ║        1. Hiển thị danh sách người dùng              ║");
            System.out.println("    ║        2. Phân quyền Admin và User                   ║");
            System.out.println("    ║        3. Xóa người dùng                             ║");
            System.out.println("    ║                                                      ║");
            System.out.println("    ║      Nhấn '8' trở lại    |    Nhấn '0' để thoát      ║");
            System.out.println("    ╚══════════════════════════════════════════════════════╝");
            System.out.println("  Chọn chức năng ");
            System.out.print("  ⭆ ");
            String choose;
            do {
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        UserView.showUser();
                        break;
                    case "2":
                        UserView.setRoleUser();
                        break;
                    case "3":
                        UserView.removeUser();
                        break;
                    case "8":
                        show();
                        break;
                    case "0":
                        AppUtils.endProgram();
                        break;
                    default:
                        System.out.println("Không hợp lệ! Vui lòng nhập lại!");
                        System.out.print("  ⭆ ");

                }
            } while (choose != "8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void orderMenu() {
        System.out.println();
        System.out.println("    ╔═════════════»»  BOOKING MENU  ««═════════════╗");
        System.out.println("    ║                                              ║");
        System.out.println("    ║            1. Tạo Order                      ║");
        System.out.println("    ║            2. Xem danh sách Order            ║");
        System.out.println("    ║                                              ║");
        System.out.println("    ║              Nhấn '0' trở lại                ║");
        System.out.println("    ╚══════════════════════════════════════════════╝");
        System.out.println(" Chọn chức năng");
        System.out.print("  ⭆ ");
        int choose;
        do {
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    OrderView.addOrder();
                    break;
                case 2:
                    OrderView.showListOrder();
                    break;
                case 0:
                    show();
                    break;
                default:
                    System.out.println("Không hợp lệ! Vui lòng chọn lại!");
                    System.out.print("  ⭆ ");
                    break;
            }
        }while (choose != 0);
    }

    public static void menuProductManager() {
        try {
            boolean flag = true;
            System.out.println();
            System.out.println("    ╔════════════════»» QUẢN LÝ SẢN PHẨM ««════════════════╗");
            System.out.println("    ║                                                      ║");
            System.out.println("    ║        1. Thêm sản phẩm                              ║");
            System.out.println("    ║        2. Sửa thông tin sản phẩm                     ║");
            System.out.println("    ║        3. Xóa sản phẩm                               ║");
            System.out.println("    ║        4. Tìm kiếm sản phẩm                          ║");
            System.out.println("    ║        5. Hiển thị danh sách sản phẩm                ║");
            System.out.println("    ║                                                      ║");
            System.out.println("    ║    Nhấn '8' quay lại     |     Nhấn '0' để thoát     ║");
            System.out.println("    ╚══════════════════════════════════════════════════════╝");
            System.out.println("  Chọn chức năng ");
            System.out.print("  ⭆ ");
            do {
                String choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        productView.addProduct();
                        break;
                    case "2":
                        productView.editProductInformation();
                        break;
                    case "3":
                        productView.removeProduct();
                        break;
                    case "4":
                        productView.findProduct();
                        break;
                    case "5":
                        productView.showProductOnTheScreen();
                        break;
                    case "8":
                        show();
                        break;
                    case "0":
                        AppUtils.endProgram();
                        break;
                    default:
                        System.out.println("Không hợp lệ! Vui lòng nhập lại!");
                        System.out.print("  ⭆ ");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}

