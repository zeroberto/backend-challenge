package com.invillia.acme.test.suport;

import com.invillia.acme.core.model.ModelEntity;
import com.invillia.acme.core.model.ModelRepository;
import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Model repository integration test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Getter(AccessLevel.PROTECTED)
public abstract class ModelRepositoryIntegrationTest<ME extends ModelEntity, MR extends ModelRepository<ME>> {

    @Autowired
    private MR repository;

    @Test
    void givenAValidEntity_whenPersist_thenSuccess() {
        // Given
        ME obj = createModelEntity();
        // When
        getRepository().save(obj);
        // Then
        assertNotNull(obj.getId());
    }

    @Test
    void givenAnEntityId_whenFind_thenReturnSuccess() {
        // Given
        ME persisted = createModelEntity();
        getRepository().save(persisted);
        // When
        Optional<ME> found = getRepository().findById(persisted.getId());
        // Then
        assertAll("validate find",
                () -> assertTrue(found.isPresent()),
                () -> assertEquals(found.orElse(null), persisted));
    }

    @Test
    void givenAnEntityId_whenFind_thenEntityNotFoundSuccess() {
        // Given
        ME persisted = createModelEntity();
        getRepository().save(persisted);
        getRepository().delete(persisted);
        // When
        Optional<ME> found = getRepository().findById(persisted.getId());
        // Then
        assertFalse(found.isPresent());
    }

    @Test
    void whenFindAll_thenResultIsNotEmptySuccess() {
        // Given
        ME persisted = createModelEntity();
        getRepository().save(persisted);
        // When
        List<ME> found = getRepository().findAll();
        // Then
        assertFalse(found.isEmpty());
    }

    @Test
    void givenAnEntity_whenDelete_thenDeleteSuccess() {
        // Given
        ME persisted = createModelEntity();
        getRepository().save(persisted);
        // When
        getRepository().delete(persisted);
        // Then
        assertFalse(() -> getRepository().findById(persisted.getId()).isPresent());
    }

    public abstract ME createModelEntity();

}