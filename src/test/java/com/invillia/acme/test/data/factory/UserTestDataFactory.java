package com.invillia.acme.test.data.factory;

import com.invillia.acme.entity.User;

/**
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class UserTestDataFactory implements TestDataFactory<User> {

    public static final Long VALID_ID = 1L;
    public static final String VALID_USERNAME = "Any";
    public static final String VALID_PASSWORD = "anything";
    public static final String VALID_USER_ROLE = "USER";

    public static final Long INVALID_ID = -1L;
    public static final String INVALID_USERNAME = "";
    public static final String INVALID_PASSWORD = "";

    public static final String ENCRYPTED_PASSWORD = "123abc321";

    public static final String INVALID_USER_ROLE = "";

    @Override
    public User createNew() {
        User user = new User();
        user.setUsername(VALID_USERNAME);
        user.setPassword(VALID_PASSWORD);
        return user;
    }

    @Override
    public User create() {
        User user = createNew();
        user.setId(VALID_ID);
        return user;
    }

    @Override
    public User createNewInvalid() {
        User user = new User();
        user.setUsername(INVALID_USERNAME);
        user.setPassword(INVALID_PASSWORD);
        return user;
    }

    @Override
    public User createInvalid() {
        User user = createNewInvalid();
        user.setId(INVALID_ID);
        return user;
    }

}
