package pub_sub.architecture;

/**
  * Message : MESSAGE CONTRACT
  * Defines the basic structure for all messages in the pub/sub system
  * Ensures each message has a type for routing purposes
 */
public interface Message {
    String getType();
}
