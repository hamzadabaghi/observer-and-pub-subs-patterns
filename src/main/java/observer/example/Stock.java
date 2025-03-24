package observer.example;

public class Stock {

    private int price;
    public Stock(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock : " + price;
    }
}
