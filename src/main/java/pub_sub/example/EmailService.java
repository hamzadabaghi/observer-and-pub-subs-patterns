package pub_sub.example;

import pub_sub.architecture.Message;
import pub_sub.architecture.Subscriber;

public class EmailService implements Subscriber {

    @Override
    public void onMessage(Message message) {
        if(message instanceof UserRegistrationMessage m ) {
            System.out.println("Email Service : Sending welcome email to " + m.getUsername() + " at " + m.getEmail());
        }
    }
}
