package Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    public static ArrayList<Product> arrayListProduct = new ArrayList<>();


    public Product createProduct(Scanner scanner) {
        SoccerBall soccerBall = createBrand(scanner);
        System.out.println("Chất lượng bóng: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Giá tiền: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng bóng: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập size: ");
        String size = scanner.nextLine();
        return new Product(nameProduct, price, amount, size, soccerBall);
    }

    public SoccerBall createBrand(Scanner scanner) {
        System.out.println("Tên hãng bóng: ");
        String brand = scanner.nextLine();
        return new SoccerBall(brand);
    }

    public void addProduct(Scanner scanner) {
        Product product = createProduct(scanner);
        arrayListProduct.add(product);
        writeDocuments(arrayListProduct);
    }

    public static void displayProduct() {
        System.out.printf( "%-10s%-16s%-20s%-20s%-20s%-20s\n", "Mã bóng", "Hãng bóng", "Chất Lượng Bóng", "Giá", "Số Lượng", "Size");
        for (int i = 0; i < arrayListProduct.size(); i++) {
            System.out.println();
            System.out.printf("%-10s%-16s%-20s%-20s%-20s%-20s\n", arrayListProduct.get(i).getId(), arrayListProduct.get(i).getBrand().getName(), arrayListProduct.get(i).getName(), arrayListProduct.get(i).getPrice(), arrayListProduct.get(i).getAmount(), arrayListProduct.get(i).getSize());
            System.out.println();
        }
    }

    public void searchById(Scanner scanner) {
        System.out.println("Nhập vào id bóng cần tìm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product num : arrayListProduct) {
            if (num.getId() == id) {
                System.out.printf("%-10s%-16s%-20s%-20s%-20s%-20s\n", "Mã Bóng", "Hãng Bóng", "Chất lượng bóng", "Giá", "Số Lượng", "Size");
                System.out.println();
                System.out.printf("%-10s%-16s%-20s%-20s%-20s%-20s\n",num.getId(), num.getBrand().getName(), num.getName(), num.getPrice(), num.getAmount(), num.getSize());
                System.out.println();
            }
        }
    }
    public void deleteProduct(Scanner scanner) {
        System.out.println("Nhập vào id bóng cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product pr : arrayListProduct) {
            if (pr.getId() == id) {
                arrayListProduct.remove(pr);
                writeDocuments(arrayListProduct);
                break;
            }
        }
    }
    public void editBrandName(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập tên hãng bóng cần sửa: ");
                String name = scanner.nextLine();
                arrayListProduct.get(i).getBrand().setName(name);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void editProduceName(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập tên chất lượng bóng cần sửa: ");
                String name = scanner.nextLine();
                arrayListProduct.get(i).setName(name);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void editProducePrice(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập giá bóng cần sửa: ");
                int price = Integer.parseInt(scanner.nextLine());
                arrayListProduct.get(i).setPrice(price);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void editProduceAmount(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập số lượng bóng cần sửa: ");
                int amount = Integer.parseInt(scanner.nextLine());
                arrayListProduct.get(i).setAmount(amount);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void editProduceSize(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập kích cỡ bóng cần sửa: ");
                String size = scanner.nextLine();
                arrayListProduct.get(i).setSize(size);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void writeDocuments(ArrayList<Product> arrayListProduct) {
        File file = new File("menu.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(arrayListProduct);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readDocuments() {
        File file = new File("menu.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            arrayListProduct = (ArrayList<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
