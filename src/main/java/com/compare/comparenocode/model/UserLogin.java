package com.compare.comparenocode.model;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Schema to use login action")
public class UserLogin {

    @Schema(description = "Unique identifier", example = "bobby")
    private String userName;
    @Schema(description = "Password Entry", example = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}