package observer.architecture;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private final List<WeakReference<Observer>> observers = new ArrayList<>();
    public void attach(WeakReference<Observer> observer) {
        observers.add(observer);
    }
    public void detach(WeakReference<Observer> observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (WeakReference<Observer> observer : observers) {
            Observer o = observer.get();
            if (o != null) {
                o.update();
            } else {
                observers.remove(observer);
            }
        }
    }
}
