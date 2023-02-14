package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class provides Credentials grant type
 * for Access Token
 */
public class AuthLoginRequests {

    @JsonProperty
    private String username;
    @JsonProperty
    private String password;

    public AuthLoginRequests(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
