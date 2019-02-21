package com.invillia.acme.repository;

import com.invillia.acme.entity.User;
import com.invillia.acme.test.data.factory.UserTestDataFactory;
import com.invillia.acme.test.suport.ModelRepositoryIntegrationTest;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * User repository integration test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class UserRepositoryTest extends ModelRepositoryIntegrationTest<User, UserRepository> {

    @Override
    public User createModelEntity() {
        return new UserTestDataFactory().createNew();
    }

    @Test
    void givenAnEntityId_whenFind_thenReturnSuccess() {
        // Given
        User persisted = createModelEntity();
        getRepository().save(persisted);
        // When
        Optional<User> found = getRepository().findByUsername(persisted.getUsername());
        // Then
        assertAll("validate find by username",
                () -> assertTrue(found.isPresent()),
                () -> assertEquals(found.orElse(null), persisted));
    }

}
