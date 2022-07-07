package Product;

public class Gloves {
    private int id;
    private String name;
    private int price;
    private int num;
    private String size;

    public Gloves() {
    }

    public Gloves(int id, String name, int price, int num, String size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void display() {
        System.out.printf("%-15S%-15d", "mã sản phẩm: ", getId());
        System.out.printf("%-15S%-15s", "tên sản phẩm: ", getName());
        System.out.printf("%-15S%-15d", "giá sản phẩm: ", getPrice());
        System.out.printf("%-15S%-15d", "số lượng sản phẩm: ", getNum());
        System.out.printf("%-15S%-15d\n", "Size sản phẩm: ", getSize());
    }
}
