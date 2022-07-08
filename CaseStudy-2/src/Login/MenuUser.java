package Login;

import Cart.CartManager;
import Product.ProductManager;

import java.util.Scanner;

public class MenuUser {
    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        CartManager cartManager = new CartManager();
        ProductManager.readDocuments();
        CartManager.readDocuments();
        int choice;
        do {
            System.out.println("*******************MENU**********************");
            System.out.println("*     1. Các sản phẩm của shop đang có      *");
            System.out.println("*     2. Mời các bạn chọn bóng              *");
            System.out.println("*     3. Hiển thị giỏ hàng của bạn          *");
            System.out.println("*     4. Xóa sản phẩm bạn không muốn mua    *");
            System.out.println("*     5. Đăng xuất                          *");
            System.out.println("*********************************************");

            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductManager.displayProduct();
                    break;
                case 2:
                    cartManager.addCart();
                    break;
                case 3:
                    cartManager.displayCart();
                    break;
                case 4:
                    cartManager.deleteProductInCart();
                    break;
                case 5 :
                    LoginMenu.LoginMenu();
                    break;
            }
        } while (choice != 0);

    }
}
