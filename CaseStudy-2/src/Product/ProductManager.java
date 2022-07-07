package Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    public static ArrayList<Product> arrayListProduct = new ArrayList<>();
//    ArrayList<Product> arrayListCart = new ArrayList<>();

    public Product createProduct(Scanner scanner) {
        SoccerBall soccerBall = createBrand(scanner);
        System.out.println("Tên sản phẩm: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Giá sản phẩm: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập size: ");
        String size = scanner.nextLine();
        return new Product(nameProduct, price, amount, size, soccerBall);
    }

    public SoccerBall createBrand(Scanner scanner) {
        System.out.println("Tên hãng: ");
        String brand = scanner.nextLine();
        return new SoccerBall(brand);
    }

    public void addProduct(Scanner scanner) {
        Product product = createProduct(scanner);
        arrayListProduct.add(product);
        writeDocuments(arrayListProduct);
    }

    public static void displayProduct() {
        System.out.printf( "%5s%15s%24s%18s%20s%20s\n","ID", "Loại bóng", "Tên Sản Phẩm", "Giá", "Số Lượng", "Size");
        for (int i = 0; i < arrayListProduct.size(); i++) {
            System.out.println();
            System.out.printf("%-16s%-16s%-27s%s%-17s%-21s%s\n", arrayListProduct.get(i).getId(), arrayListProduct.get(i).getBrand().getName(), arrayListProduct.get(i).getName(), "$", arrayListProduct.get(i).getPrice(), arrayListProduct.get(i).getAmount(), arrayListProduct.get(i).getSize());
            System.out.println();
        }
    }

    public void searchById(Scanner scanner) {
        System.out.println("Nhập vào id sản phẩm cần tìm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product b : arrayListProduct) {
            if (b.getId() == id) {
                System.out.printf("%5s%15s%24s%18s%20s%20s\n", "ID", "Loại Bóng", "Tên Sản Phẩm", "Giá", "Số Lượng", "Size");
                System.out.println();
                System.out.printf("%-16s%-16s%-27s%s%-17s%-21s%s\n",b.getId(), b.getBrand().getName(), b.getName(), b.getPrice(), b.getAmount(), b.getSize());
                System.out.println();
            }
        }
    }

    public void searchByName(Scanner scanner) {
        System.out.println("Nhập tên đồ cần tìm đi bro: ");
        String search = scanner.nextLine();
        System.out.printf( "Mã Số", "Hãng", "Tên Sản Phẩm", "Giá", "Số Lượng", "Kích Cỡ");
        for (Product b : arrayListProduct) {
            if (b.getName().toUpperCase().contains(search.toUpperCase())) {
                System.out.println();
                System.out.printf("", b.getId(), b.getBrand().getName(), b.getName(), "$", b.getPrice(), b.getAmount(), b.getSize());
                System.out.println();
            }
        }
    }

    public void deleteProduct(Scanner scanner) {
        System.out.println("Nhập vào id sản phẩm cần xóa: ");
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
                System.out.println("Nhập tên hãng cần sửa: ");
                String name = scanner.nextLine();
                arrayListProduct.get(i).getBrand().setName(name);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void editProduceName(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập tên sản phẩm cần sửa: ");
                String name = scanner.nextLine();
                arrayListProduct.get(i).setName(name);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void editProducePrice(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập giá sản phẩm cần sửa: ");
                int price = Integer.parseInt(scanner.nextLine());
                arrayListProduct.get(i).setPrice(price);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void editProduceAmount(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập số lượng sản phẩm cần sửa: ");
                int amount = Integer.parseInt(scanner.nextLine());
                arrayListProduct.get(i).setAmount(amount);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void editProduceSize(Scanner scanner, int id) {
        for (int i = 0; i < arrayListProduct.size(); i++) {
            if (arrayListProduct.get(i).getId() == (id)) {
                System.out.println("Nhập kích cỡ sản phẩm cần sửa: ");
                String size = scanner.nextLine();
                arrayListProduct.get(i).setSize(size);
                writeDocuments(arrayListProduct);
            }
        }
    }

    public void writeDocuments(ArrayList<Product> arrayListProduct) {
        File file = new File("D:\\codegym\\Java\\CaseStudy-2\\Product.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(arrayListProduct);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(".");
        }
    }

    public static void readDocuments() {
        File file = new File("D:\\codegym\\Java\\CaseStudy-2\\Product.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            arrayListProduct = (ArrayList<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(".");
        }
    }
}
