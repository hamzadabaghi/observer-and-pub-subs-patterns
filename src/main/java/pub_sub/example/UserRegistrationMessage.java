package pub_sub.example;

import pub_sub.architecture.Message;

public class UserRegistrationMessage implements Message {

    private String username;
    private String email;

    public UserRegistrationMessage(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    /**
     * This method returns the type of the message.
     * In a real-world scenario, this could be used for routing messages to the appropriate subscribers.
     *
     * @return The type of the message as a string.
     */
    @Override
    public String getType() {
        return "USER_REGISTRATION";
    }
}
