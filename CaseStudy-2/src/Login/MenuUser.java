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
            System.out.println("1. Các sản phẩm của shop");
            System.out.println("2. Mời các bạn chọn bóng");
            System.out.println("3. Hiển thị giỏ hàng");
            System.out.println("4. Xóa sản phẩm .");
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
            }
        } while (choice != 0);


    }
}
