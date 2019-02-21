package com.invillia.acme.entity;

import com.invillia.acme.test.data.factory.UserTestDataFactory;
import com.invillia.acme.test.suport.ModelEntityTest;

/**
 * User entity unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class UserTest extends ModelEntityTest<User> {

    public UserTest() {
        super(new UserTestDataFactory());
    }

}
