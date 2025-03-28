package pub_sub.architecture.pub;

import pub_sub.architecture.broker.MessageBroker;

public abstract class Publisher {

    public final MessageBroker messageBroker;

    public Publisher(MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }
}
