package Product;

import java.io.Serializable;

public class Product implements Serializable {
    public static int ID = 0;
    private int id;
    private String name;
    private int price;
    private int amount;
    private String size;
    private SoccerBall soccerBall;

    public Product(int id, String name, int price, int amount, String size, SoccerBall soccerBall) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.size = size;
        this.soccerBall = soccerBall;
    }

    public Product(String name, int price, int amount, String size, SoccerBall soccerBall) {
        try {
            ID = ProductManager.arrayListProduct.get(ProductManager.arrayListProduct.size() - 1).getId();
        } catch (Exception e) {
            ID = 0;
        }
        this.id = ++ID;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.size = size;
        this.soccerBall = soccerBall;
    }

    public Product() {

    }

    public Product(String brand, Product product) {
    }



    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Product.ID = ID;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public SoccerBall getBrand() {
        return soccerBall;
    }

    public void setBrand(SoccerBall soccerBall) {
        this.soccerBall = soccerBall;
    }

    @Override
    public String toString() {
        return
                soccerBall +
                        ", name=" + name +
                        ", price=" + price +
                        ", size=" + size;

    }
}
