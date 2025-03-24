import observer.architecture.ConcreteObserver;
import observer.architecture.ConcreteSubject;
import observer.architecture.Observer;
import observer.architecture.Subject;

import java.lang.ref.WeakReference;

public class Main {

    public static void main(String[] args) {

        /* ------ observer pattern ------ */

        System.out.println("------ observer pattern ------");
        ConcreteSubject subject = new ConcreteSubject();
        WeakReference<Observer> observer1 = new WeakReference<>(new ConcreteObserver());
        WeakReference<Observer> observer2 = new WeakReference<>(new ConcreteObserver());
        subject.attach(observer1);
        subject.attach(observer2);
        subject.setState(10);


        /* ------ pub/sub pattern ------ */

        System.out.println("------ pub/sub pattern ------");
    }
}
