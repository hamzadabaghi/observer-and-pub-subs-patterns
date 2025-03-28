package pub_sub.architecture;

/**
  * Subscriber : SUBSCRIBER CONTRACT
  * Defines the basic structure for all subscribers in the pub/sub system
  * Any service that wants to receive messages must implement this interface
 */
public interface Subscriber {
    void onMessage(Message message);
}
