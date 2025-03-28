package pub_sub.example;

import pub_sub.architecture.Message;
import pub_sub.architecture.Subscriber;

public class AnalyticsService implements Subscriber {

    @Override
    public void onMessage(Message message) {
        if(message instanceof UserRegistrationMessage m ) {
            System.out.println("Analytics Service : Logging user registration for analytics : " + m.getUsername() + ", " + m.getEmail());
        }
    }
}
