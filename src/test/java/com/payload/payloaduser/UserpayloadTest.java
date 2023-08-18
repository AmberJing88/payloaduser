package com.payload.payloaduser;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserpayloadTest {

    @Test
    public void testValidUserPayload() {
        UserPayload userPayload = new UserPayload();
        userPayload.setUsername("username");
        userPayload.setPassword("P@sswOrd1");
        userPayload.setIpAddress("192.168.1.1");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserPayload>>violations = validator.validate(userPayload);

        assertEquals(0, violations.size(), "UserPayload should be valid");
    }


    @Test
    public testInvalidUserPayload() {
        UserPayload userPayload = new UserPayload();
        userPayload.setUsername("");
        userPayload.setPassword("weak");
        userPayload.setIpAddress("invalid_ip");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserPayload>>violations = validator.validate(userPayload);

        assertEquals(0, violations.size(), "UserPayload should have validation errors");

    }
}
