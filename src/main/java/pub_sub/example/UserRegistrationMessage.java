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

    @Override
    public String getType() {
        return "USER_REGISTRATION";
    }
}
