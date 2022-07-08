package Login;

import Cart.CartManager;

import java.util.Scanner;

public class LoginMenu {
    public static void LoginMenu() {
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);
        login.readFileData() ;
        int choice;
        do {
            System.out.println("*** CHÀO MỪNG BẠN ĐẾN VỚI THẾ GIỚI BÓNG ****");
            System.out.println("*         1. Đăng ký tài khoản             *");
            System.out.println("*         2. Đăng nhập                     *");
            System.out.println("*          Chọn 1 hoặc 2 nhé               *");
            System.out.println("********************************************");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    login.addAccount(scanner);
                    break;
                case 2:
                    login.inputAccount(scanner);
                    int choice1;
                    choice1 = Integer.parseInt(scanner.next());
                    if (choice1 == 1) {
                        MenuUser.Menu();
                    }
            }
        } while (choice != 0);
    }
}
