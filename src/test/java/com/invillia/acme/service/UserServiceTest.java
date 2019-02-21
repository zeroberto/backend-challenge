package com.invillia.acme.service;

import com.invillia.acme.entity.User;
import com.invillia.acme.exceptions.UsernameAlreadyExistsException;
import com.invillia.acme.repository.UserRepository;
import com.invillia.acme.test.data.factory.UserTestDataFactory;
import com.invillia.acme.test.suport.ModelServiceTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * User service unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class UserServiceTest extends ModelServiceTest<User, UserRepository, UserService> {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Override
    protected User createEntity() {
        return new UserTestDataFactory().create();
    }

    @Override
    protected UserRepository getRepository() {
        return this.repository;
    }

    @Override
    protected UserService getService() {
        return this.service;
    }

    @Test
    void givenAValidEntity_whenUsernameAlreadyExists_thenFailure() {
        User entity = createEntity();
        when(repository.existsByUsername(Mockito.anyString())).thenReturn(true);
        assertThrows(UsernameAlreadyExistsException.class, () -> getService().save(entity));
    }

}
