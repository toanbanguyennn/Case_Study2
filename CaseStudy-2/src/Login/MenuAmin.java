package Login;

import Login.Login;
import Product.ProductManager;
import sun.applet.Main;

import java.io.Serializable;
import java.util.Scanner;

public class MenuAmin implements Serializable {
    public static void Menu() {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        productManager.readDocuments();
        int choice;
        do {
            System.out.println("----Menu Quản lý----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm theo ID");
            System.out.println("4. Tìm sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Hiển thị toàn bộ sản phẩm của shop");
            System.out.println("7. Hiển thị các tài khoản đã đăng ký");
            System.out.println("8. Xóa tài khoản khách");
            System.out.println("0. Đăng xuất");
            System.out.println("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.addProduct(scanner);
                    break;
                case 2:
                    System.out.println("Nhập vào id sản phẩm cần sửa: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("1. Sửa tên hãng");
                    System.out.println("2. Sửa tên sản phẩm");
                    System.out.println("3. Sửa giá sản phẩm");
                    System.out.println("4. Sửa số lượng sản phẩm");
                    System.out.println("5. Sửa kích cỡ sản phẩm");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            productManager.editBrandName(scanner, id);
                            break;
                        case 2:
                            productManager.editProduceName(scanner, id);
                            break;
                        case 3:
                            productManager.editProducePrice(scanner, id);
                            break;
                        case 4:
                            productManager.editProduceAmount(scanner, id);
                            break;
                        case 5:
                            productManager.editProduceSize(scanner, id);
                            break;
                    }
                    break;
                case 3:
                    productManager.deleteProduct(scanner);
                    break;
                case 4:
                    productManager.searchById(scanner);
                    break;
                case 5:
                    productManager.searchByName(scanner);
                    break;
                case 6:
                    productManager.displayProduct();
                    break;

                case 0:
                    LoginMenu.LoginMenu();
                    break;
            }
        } while (choice != 0);
    }
}
