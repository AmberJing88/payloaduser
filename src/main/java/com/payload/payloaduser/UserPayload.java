package com.payload.payloaduser;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserPayload {
    @NotNull(message = "Username cannot be null")
    @Size(min=1, message = "Username cannot be empty")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min=9, message = "Password must be least 9 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[_#$%.])[a-zA-Z0-9_#$%.]+$",
            message = "Password must contain at least 1 number, 1 letter, and 1 special character (_#$%.)")
    private String password;

    @NotNull(message = "IP address cannot be null")
    private String ipAddress;

}
