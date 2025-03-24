package observer.example;

import observer.architecture.Observer;

import java.util.Arrays;

public class StatuBar implements Observer {

    private Stocks stockDatasource;

    public StatuBar(Stocks stockDatasource) {
        this.stockDatasource = stockDatasource;
    }
    @Override
    public void update() {
        System.out.println("StatuBar updated : " + stockDatasource.getPopularStocks());
    }
}
