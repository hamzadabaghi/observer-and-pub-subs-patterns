package pub_sub.architecture;

public interface Subscriber {
    void onMessage(Message message);
}
