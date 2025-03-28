package pub_sub.architecture.sub;

import pub_sub.architecture.common.Message;

/**
  * Subscriber : SUBSCRIBER CONTRACT
  * Defines the basic structure for all subscribers in the pub/sub system
  * Any service that wants to receive messages must implement this interface
 */
public interface Subscriber {
    void onMessage(Message message);
}
