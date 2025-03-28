package pub_sub.example.publishers;

import pub_sub.architecture.broker.MessageBroker;
import pub_sub.architecture.pub.Publisher;
import pub_sub.example.common.UserRegistrationMessage;

public class UserService extends Publisher {

    public UserService(MessageBroker messageBroker) {
        super(messageBroker);
    }

    public void registerUser(String username, String email) {
        System.out.println("User registered: " + username);
        UserRegistrationMessage message = new UserRegistrationMessage(username, email);
        this.messageBroker.publish(message);
    }

}
