package observer.architecture;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Subject {
    private final List<WeakReference<Observer>> observers = new ArrayList<>();

    public WeakReference<Observer> attach(Observer observer) {
        WeakReference<Observer> weakObserver = new WeakReference<>(observer);
        observers.add(weakObserver);
        return weakObserver;
    }

    public void detach(WeakReference<Observer> observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (WeakReference<Observer> observer : observers) {
            Optional.ofNullable(observer.get()).ifPresentOrElse(
                    Observer::update,
                    () -> detach(observer)
            );
        }
    }
}
