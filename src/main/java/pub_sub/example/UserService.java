package pub_sub.example;

import pub_sub.architecture.MessageBroker;
import pub_sub.architecture.Publisher;

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
