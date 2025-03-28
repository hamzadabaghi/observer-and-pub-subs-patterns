import observer.architecture.ConcreteObserver;
import observer.architecture.ConcreteSubject;
import observer.architecture.Observer;
import observer.example.StatuBar;
import observer.example.StatusListView;
import observer.example.Stocks;
import pub_sub.architecture.broker.MessageBroker;
import pub_sub.example.publishers.UserService;
import pub_sub.example.subscribers.AnalyticsService;
import pub_sub.example.subscribers.EmailService;

public class Main {

    private static String BROKER_TOPIC = "USER_REGISTRATION";

    public static void main(String[] args) {

        /* ------ observer pattern : architecture ------ */

        System.out.println("\n------ observer pattern : architecture ------\n");
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        var weakReferenceObserver1 = subject.attach(observer1);
        var weakReferenceObserver2 = subject.attach(observer2);
        subject.setState(10);
        subject.setState(20);


        /* ------ observer pattern : example ------ */

        System.out.println("\n------ observer pattern : example ------\n");
        Stocks stockDatasource = new Stocks(5);
        Observer statusBarObserver = new StatuBar(stockDatasource);
        Observer statusListViewObserver = new StatusListView(stockDatasource);
        var weakstockDatasourceReference = stockDatasource.attach(statusBarObserver);
        var weakStatusListViewReference = stockDatasource.attach(statusListViewObserver);
        stockDatasource.addStock(5);
        stockDatasource.addStock(10);
        stockDatasource.addStock(20);
        stockDatasource.updateStockPrice(0, 30);



        /* ------ pub/sub pattern ------ */

        System.out.println("\n------ pub/sub pattern ------\n");

        MessageBroker messageBroker = new MessageBroker();
        AnalyticsService analyticsService = new AnalyticsService();
        EmailService emailService = new EmailService();
        messageBroker.subscribe(BROKER_TOPIC, analyticsService);
        messageBroker.subscribe(BROKER_TOPIC, emailService);
        UserService userService = new UserService(messageBroker);
        userService.registerUser("hamza", "hamza.dabaghi@gmail.com");
    }
}
