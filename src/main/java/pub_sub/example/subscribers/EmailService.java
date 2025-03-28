package pub_sub.example.subscribers;

import pub_sub.architecture.common.Message;
import pub_sub.architecture.sub.Subscriber;
import pub_sub.example.common.UserRegistrationMessage;

public class EmailService implements Subscriber {

    @Override
    public void onMessage(Message message) {
        if(message instanceof UserRegistrationMessage m ) {
            System.out.println("Email Service : Sending welcome email to " + m.getUsername() + " at " + m.getEmail());
        }
    }
}
