package observer.example;

import observer.architecture.Subject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stocks extends Subject {

    private final List<Stock> stocks;

    public Stocks(int numberOfStocks) {
        stocks = new ArrayList<>(numberOfStocks);
    }

    public void addStock(int price) {
        stocks.add(new Stock(price));
        notifyObservers();
    }

    public void updateStockPrice(int index, int newPrice) {
        stocks.get(index).setPrice(newPrice);
        notifyObservers();
    }

    public List<Stock> getPopularStocks() {
        return stocks.stream().sorted(
                Comparator.comparing(Stock::getPrice).reversed()
        )
        .limit(2)
        .collect(Collectors.toList());
    }

    public List<Stock> getStocks() {
        return stocks;
    }

}
