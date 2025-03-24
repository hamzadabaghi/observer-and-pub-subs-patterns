package observer.example;

import observer.architecture.Observer;

public class StatusListView implements Observer {

    private Stocks stockDatasource;

    public StatusListView(Stocks stockDatasource) {
        this.stockDatasource = stockDatasource;
    }

    @Override
    public void update() {
        System.out.println("StatusListView updated : " + stockDatasource.getStocks());
    }
}
