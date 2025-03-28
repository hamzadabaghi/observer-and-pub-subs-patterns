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

import java.lang.ref.WeakReference;

public class Main {

    private static String TOPIC = "USER_REGISTRATION";
    public static void main(String[] args) {

        /* ------ observer pattern : architecture ------ */

//        System.out.println("\n------ observer pattern : architecture ------\n");
//        ConcreteSubject subject = new ConcreteSubject();
//        WeakReference<Observer> observer1 = new WeakReference<>(new ConcreteObserver());
//        WeakReference<Observer> observer2 = new WeakReference<>(new ConcreteObserver());
//        subject.attach(observer1);
//        subject.attach(observer2);
//        subject.setState(10);
//        subject.setState(20);


        /* ------ observer pattern : example ------ */

//        System.out.println("\n------ observer pattern : example ------\n");
//        Stocks stockDatasource = new Stocks(5);
//        WeakReference<Observer> statusBarObserver = new WeakReference<>(new StatuBar(stockDatasource));
//        WeakReference<Observer> statusListViewObserver = new WeakReference<>(new StatusListView(stockDatasource));
//        stockDatasource.attach(statusBarObserver);
//        stockDatasource.attach(statusListViewObserver);
//        stockDatasource.addStock(5);
//        stockDatasource.addStock(10);
//        stockDatasource.addStock(20);
//        stockDatasource.updateStockPrice(0, 30);



        /* ------ pub/sub pattern ------ */

        System.out.println("\n------ pub/sub pattern ------\n");

        MessageBroker messageBroker = new MessageBroker();
        AnalyticsService analyticsService = new AnalyticsService();
        EmailService emailService = new EmailService();
        messageBroker.subscribe(TOPIC, analyticsService);
        messageBroker.subscribe(TOPIC, emailService);
        UserService userService = new UserService(messageBroker);
        userService.registerUser("hamza", "hamza.dabaghi@gmail.com");
    }
}
