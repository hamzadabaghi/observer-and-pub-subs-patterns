package pub_sub.architecture.broker;

import pub_sub.architecture.common.Message;
import pub_sub.architecture.sub.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
  * MessageBroker : MESSAGE BROKER CONTRACT
  * The broker is responsible for routing messages to the appropriate subscribers
  * It maintains a list of subscribers for each message type
 */
public class MessageBroker {

    /**
      * Thread-safe map to store subscribers for each message type
      * The key is the message type, and the value is a list of subscribers
      * This allows for multiple subscribers to be registered for the same message type
     */
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
