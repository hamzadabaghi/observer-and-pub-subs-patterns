package observer.architecture;

public class ConcreteObserver implements Observer {
    @Override
    public void update(int value) {
        System.out.println("ConcreteObserver -- update, new value : " + value);
    }
}
