package Cart;

import Product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static Product.ProductManager.arrayListProduct;

public class CartManager {
    Scanner scanner = new Scanner(System.in);
    public static ArrayList<Cart> carts = new ArrayList<>();

    public CartManager() {
    }

    public Cart createCart() {
        System.out.println("Nhập mã bóng muốn mua : ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = getProductByID(id);
        int amount;
        do {
            System.out.println("Nhập số lượng cần mua");
            amount = Integer.parseInt(scanner.nextLine());
        }
        while(product.getAmount()<amount);
        int totalPrice = amount * product.getPrice();
        return new Cart(amount, product, totalPrice);
    }

    public Product getProductByID(int id) {
        for (Product product : arrayListProduct) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public void addCart() {
        Cart cart = createCart();
        carts.add(cart);
        writeDocuments(carts);
    }


    public void displayCart() {
        int sum = 0;
        for (Cart b : carts) {
            sum += b.getTotalPrice();
        }
        System.out.printf("%-10s%-16s%-20s%-20s%-20s%-20s\n", "Mã Số", "Hãng", "Tên Sản Phẩm", "Giá", "Số Lượng", "Kích Cỡ");
        for (int i = 0; i < carts.size(); i++) {
            System.out.printf("%-10s%-16s%-20s%-20s%-20s%-20s\n", carts.get(i).getProduct().getId(),
                    carts.get(i).getProduct().getBrand().getName(), carts.get(i).getProduct().getName(),
                    carts.get(i).getProduct().getPrice(), carts.get(i).getCount(), carts.get(i).getProduct().getSize());


        }
        System.out.printf("Số tiền hiện tại là: " + sum  + "\n");
    }


    public void writeDocuments(ArrayList<Cart> arrayListCart) {
        File file = new File("cart.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(arrayListCart);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(".");
        }
    }

    public static void readDocuments() {
        File file = new File("cart.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            carts = (ArrayList<Cart>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(".");
        }
    }

    public void deleteProductInCart() {
        System.out.print("Nhập vào mã sản phẩm cần xóa đi homieee: ");
        int id;
        id = scanner.nextInt();
        for (int i = 0; i < carts.size(); i++) {
            if (id == carts.get(i).getId()) {
                carts.remove(i);
            }
        }
    }
}
