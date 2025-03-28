package pub_sub.example.subscribers;

import pub_sub.architecture.common.Message;
import pub_sub.architecture.sub.Subscriber;
import pub_sub.example.common.UserRegistrationMessage;

public class AnalyticsService implements Subscriber {

    @Override
    public void onMessage(Message message) {
        if(message instanceof UserRegistrationMessage m ) {
            System.out.println("Analytics Service : Logging user registration for analytics : " + m.getUsername() + ", " + m.getEmail());
        }
    }
}
