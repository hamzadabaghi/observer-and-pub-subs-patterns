package pub_sub.architecture;

public abstract class Publisher {

    public final MessageBroker messageBroker;

    public Publisher(MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }
}
