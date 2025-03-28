package pub_sub.architecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker {

    private Map<String, List<Subscriber>> subscriberMap = new ConcurrentHashMap<>();

    public void subscribe(String messageType, Subscriber subscriber) {
        subscriberMap.computeIfAbsent(messageType, k -> new ArrayList<>())
                .add(subscriber);
    }

    public void unsubscribe(String messageType, Subscriber subscriber) {
        List<Subscriber> subscribers = subscriberMap.get(messageType);
        if (subscribers != null) {
            subscribers.remove(subscriber);
        }
    }

    public void publish(Message message) {
        List<Subscriber> subscribers = subscriberMap.get(message.getType());
        if (subscribers != null) {
            for (Subscriber subscriber : subscribers) {
                subscriber.onMessage(message);
            }
        }
    }

}
