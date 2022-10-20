package view;

import menu.Menu;
import models.User;
import services.UserServices;
import until.AppUtils;
import until.InstantUtils;
import until.ValidateUtils;

import java.time.Instant;
import java.util.Scanner;

public class UserView {
    public static Scanner scanner = new Scanner(System.in);
    public static UserServices userServices = new UserServices();

    public static void login() {
        User user;
        do {
            try {
                System.out.println();
                System.out.println("═══════════════»» ĐĂNG NHẬP HỆ THỐNG ««═══════════════");
                System.out.println("  Nhập tài khoản ");
                System.out.print(" ⭆ ");
                String userName = scanner.nextLine();
                System.out.println("  Nhập mật khẩu ");
                System.out.print(" ⭆ ");
                String password = scanner.nextLine();
                user = userServices.loginUser(userName, password);
                if (userName.equals("admin") && password.equals("admin")) {
                    System.out.println("Đăng nhập thành công!");
                    Menu.show();
                } else if (user.getNameUser().equals(userName) && user.getPassWord().equals(password)) {
                    if (user.getRole().equals("User")) {
                        System.out.println("Đăng nhập thành công!");
                        Menu.show();
                    } else {
                        if (user.getRole().equals("Admin")) {
                            System.out.println("Đăng nhập thành công");
                            Menu.show();
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Tài khoản hoặc mật khẩu không đúng! Vui lòng nhập lại!");
            }
        }
        while (true);
    }

    public static void createAccount() {
        boolean flag = true;
        do {
            System.out.println();
            System.out.println("═══════════════»» TẠO TÀI KHOẢN ««═══════════════");
            Long idUser = System.currentTimeMillis() % 100000;
            System.out.println("Nhập tên tài khoản");
            System.out.println(" ⭆ user" + idUser);
            String nameUser = "user" + idUser;
            String password = inputPassword(ChoiceStatus.ADD);
            String fullName = inputFullName(ChoiceStatus.ADD);
            String phone = inputPhoneUser(ChoiceStatus.ADD);
            String email = inputEmailUser(ChoiceStatus.ADD);
            String address = inputAddressUser(ChoiceStatus.ADD);
            String roleUser = inputRoleUser();
            User user = new User(idUser, nameUser, password, fullName, phone, email, address, roleUser, Instant.now());
            System.out.println("Bạn đã đăng ký thành công");
            userServices.addUser(user);
            int choice;
            do {
                System.out.println("Nhấn '0' để quay lại màn hình đăng nhập!");
                System.out.print(" ⭆ ");
                choice = AppUtils.retryParseInt();
            } while (choice != 0);
            Menu.loginMenu();
        } while (!flag);
    }

    private static String inputRoleUser() {
        System.out.println("Nhập mã Admin (nhập sai hoặc không nhập) thì bạn là User! ");
        System.out.print(" ⭆ ");
        String setRole = scanner.nextLine();
        String role;
        if (setRole.equals("01011999")) {
            role = "Admin";
        } else {
            role = "User";
        }
        return role;
    }


    private static String inputAddressUser(ChoiceStatus add) {
        String address;
        switch (add) {
            case ADD:
                System.out.println("Nhập địa chỉ của bạn (VD: Hue)");
                break;
            case EDIT:
                System.out.println("Nhập địa chỉ mới của bạn (VD: Hue)");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = true;
        do {
            address = scanner.nextLine().trim();
            boolean exits = (!address.isEmpty());
            switch (add) {
                case ADD:
                case EDIT:
                    if (!exits) {
                        System.out.println("Địa chỉ không được để trống! Vui lòng nhập lại!");
                        System.out.println("Nhập địa chỉ của bạn (VD: Hue)");
                        System.out.print(" ⭆ ");
                    }
                    flag = !exits;
                    break;
            }
        } while (flag);
        return address;
    }

    private static String inputEmailUser(ChoiceStatus add) {
        String email;
        switch (add) {
            case ADD:
                System.out.println("Nhập email của bạn (VD: dpduy1199@gmail.com)");
                break;
            case EDIT:
                System.out.println("Nhập email mới (VD: dpduy1199@gmail.com)");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = true;
        do {
            email = scanner.nextLine().trim();
            if (!ValidateUtils.isEmailValid(email)) {
                System.out.println("Email " + email + " không đúng định dạng! Vui lòng nhập lại!");
                System.out.println("Nhập email (VD: dpduy1199@gmail.com)");
                System.out.print(" ⭆ ");
                continue;
            }
            break;
        } while (flag);
        return email;
    }

    private static String inputPhoneUser(ChoiceStatus add) {
        String phone;
        switch (add) {
            case ADD:
                System.out.println("Nhập số điện thoại của bạn (VD: 0987619999) ");
                break;
            case EDIT:
                System.out.println("Số điện thoại mới của bạn là (VD: 0987619999)");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = true;
        do {
            phone = scanner.nextLine().trim();
            if (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số " + phone + " không đúng định dạng! Vui lòng nhập lại! (Số điện thoại gồm 10 số và bắt đầu từ số 0)");
                System.out.println("Nhập số điện thoại của bạn (VD: 0987619999) ");
                System.out.print(" ⭆ ");
                continue;
            }
            break;
        } while (flag);
        return phone;
    }

    private static String inputFullName(ChoiceStatus add) {
        String fullName;
        switch (add) {
            case ADD:
                System.out.println("Nhập tên của bạn (VD: Phuoc Duy) ");
                break;
            case EDIT:
                System.out.println("Nhập tên bạn muốn thay đổi (VD: Phuoc Duy) ");
                break;
        }
        System.out.print(" ⭆ ");
        while (!ValidateUtils.isNameValid(fullName = scanner.nextLine())) {
            System.out.println("Tên " + fullName + " không đúng định dạng! Vui lòng nhập lại! (Phải viết hoa chữ cái đầu và không có dấu)");
            System.out.print(" ⭆ ");
        }
        return fullName;
    }

    public static String inputPassword(ChoiceStatus add) {
        String password;
        switch (add) {
            case ADD:
                System.out.println("Nhập mật khẩu (từ 8 đến 20 kí tự, không bao gồm kí tự đặc biệt)");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = true;
        do {
            password = scanner.nextLine().trim();
            boolean exits = (password.length() >= 8 && password.length() <= 20);
            switch (add) {
                case ADD:
                    if (!exits) {
                        System.out.println("Bạn nhập sai định dạng! Vui lòng nhập lại");
                        System.out.print(" ⭆ ");
                    }
                    flag = !exits;
                    break;
            }
        } while (flag);
        return password;
    }

    public static Long inputIdUser(ChoiceStatus add) {
        Long id;
        switch (add) {
            case EDIT:
            case REMOVE:
                System.out.println("Nhập ID User cần xóa");
                break;
        }
        System.out.print(" ⭆ ");
        boolean flag = true;
        do {
            id = AppUtils.retryParseLong();
            boolean exits = userServices.exitUserId(id);
            switch (add) {
                case EDIT:
                case REMOVE:
                    if (!exits) {
                        System.out.println("Không tìm thấy ID! Vui lòng nhập lại");
                        System.out.print(" ⭆ ");
                    }
                    flag = !exits;
                    break;
            }
        } while (flag);
        return id;
    }

    public static void showUserList() {
        System.out.println();
        System.out.println("═══════════════════════════════════════════════════════════════════════════════ Danh Sách Users ════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-15s %-15s %-25s %-25s %-15s %-25s %-25s %-10s %-25s\n", "ID", "Username", "Password", "FullName", "Phone Number", "Email", "Address", "Role", "Time Creat");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (User user : userServices.findAllUsers()) {
            System.out.printf("%-15s %-15s %-25s %-25s %-15s %-25s %-25s %-10s %-25s\n",
                    user.getId(),
                    user.getNameUser(),
                    user.getPassWord(),
                    user.getName(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getRole(),
                    InstantUtils.instantToString(user.getTimeCreatUser()));
        }
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    public static void showUser() {
        showUserList();
        String choose;
        do {
            System.out.println("Nhấn '0' để quay lại User");
            System.out.print(" ⭆ ");
            choose = scanner.nextLine();
            switch (choose) {
                case "0":
                    Menu.menuUsersManager();
                    break;
                default:
                    System.out.println("Nhập sai! Vui lòng nhập lại!");
            }
        } while (choose != "0");


    }

    public static void removeUser() {
        try {
            showUserList();
            Long id = inputIdUser(ChoiceStatus.REMOVE);
            System.out.println();
            System.out.println("Nhấn 'y' để đồng ý  |  Nhấn 'b' để quay lại");
            System.out.print(" ⭆ ");
            String choose;
            do {
                choose = scanner.nextLine();
                switch (choose) {
                    case "y":
                        userServices.removeUser(id);
                        System.out.println("Người dùng đã được xóa!");
                        showUser();
                        Menu.menuUsersManager();
                        break;
                    case "b":
                        Menu.menuUsersManager();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
                        System.out.print(" ⭆ ");
                }
            } while (choose != "b");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setRoleUser() {
        try {
            showUserList();
            System.out.println("Nhập ID User");
            System.out.print(" ⭆ ");
            Long id = AppUtils.retryParseLong();
            if (userServices.exitUserId(id)) {
                boolean flag = true;
                System.out.println();
                System.out.println("    ╔═══════════»» SET ROLE USER ««═══════════╗");
                System.out.println("    ║                                         ║");
                System.out.println("    ║          1. Set quyền Admin             ║");
                System.out.println("    ║          2. Set làm User                ║");
                System.out.println("    ║                                         ║");
                System.out.println("    ║   Nhấn '8' trở lại | Nhấn '0' để thoát  ║");
                System.out.println("    ╚═════════════════════════════════════════╝");
                System.out.println("Chọn chức năng");
                System.out.print(" ⭆ ");
                User user = new User();
                user.setId(id);
                do {
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            setAdmin(user);
                            break;
                        case "2":
                            setUser(user);
                            break;
                        case "8":
                            Menu.menuUsersManager();
                            break;
                        case "0":
                            AppUtils.endProgram();
                        default:
                            System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
                            System.out.print(" ⭆ ");
                            flag = false;
                    }
                } while (!flag);
            } else {
                System.out.println("Không tìm thấy Id User này!");
                setRoleUser();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void showUserListChoice(){
        showUserList();
        int choose;
        do {
            System.out.println("Nhấn '0' để quay lại");
            System.out.print(" ⭆ ");
            choose = AppUtils.retryParseInt();
        } while (choose != 0);
        Menu.menuUsersManager();
    }
    private static void setAdmin(User user){
        user.setRole("Admin");
        userServices.editUser(user);
        System.out.println("Role User đã được cập nhật!");
        showUserListChoice();
        Menu.menuUsersManager();
    }
    private static void setUser(User user){
        user.setRole("User");
        userServices.editUser(user);
        System.out.println("Role User đã được cập nhật!");
        showUserListChoice();
        Menu.menuUsersManager();
    }

}

