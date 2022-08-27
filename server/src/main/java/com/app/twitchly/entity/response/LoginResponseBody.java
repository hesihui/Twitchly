package com.app.twitchly.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseBody {

    @JsonProperty("user_id")
    private final String userID;

    @JsonProperty("name")
    private final String name;

    public LoginResponseBody(String userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }
}
