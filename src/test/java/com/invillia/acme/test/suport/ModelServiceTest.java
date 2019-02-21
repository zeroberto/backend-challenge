package com.invillia.acme.test.suport;

import com.invillia.acme.core.model.ModelEntity;
import com.invillia.acme.core.model.ModelRepository;
import com.invillia.acme.core.model.ModelService;
import com.invillia.acme.exceptions.ModelEntityNotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * ModelService generic unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Getter(value = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
public abstract class ModelServiceTest<
        ME extends ModelEntity,
        MR extends ModelRepository<ME>,
        MS extends ModelService<ME, MR>> {

    private static final Long INVALID_ID = -1L;

    @Test
    void givenAValidEntity_whenSave_thenSuccess() {
        ME entity = createEntity();
        when(getRepository().save(Mockito.any())).thenReturn(entity);
        assertEquals(entity, getService().save(entity));
    }

    @Test
    void givenAValidId_whenFind_thenReturnSuccess() {
        ME entity = createEntity();
        when(getRepository().findById(Mockito.anyLong())).thenReturn(Optional.of(entity));
        assertEquals(entity.getId(), getService().find(entity.getId()).getId());
    }

    @Test
    void givenAnInvalidId_whenFind_thenThrowsEntityNotFoundExceptionFailure() {
        when(getRepository().findById(Mockito.anyLong())).thenThrow(new EntityNotFoundException());
        assertThrows(ModelEntityNotFoundException.class, () -> getService().find(INVALID_ID));
    }

    @Test
    void givenAnValidEntity_whenDelete_thenSuccess() {
        ME entity = createEntity();
        when(getRepository().findById(Mockito.anyLong())).thenReturn(Optional.of(entity));
        assertEquals(entity, getService().delete(createEntity().getId()));
    }

    @Test
    void givenAnInvalidEntity_whenDeleteAndEntityNotFound_thenThrowsEntityNotFoundExceptionFailure() {
        when(getRepository().findById(Mockito.anyLong())).thenThrow(new EntityNotFoundException());
        assertThrows(ModelEntityNotFoundException.class, () -> getService().delete(createEntity().getId()));
    }

    protected abstract ME createEntity();

    protected abstract MR getRepository();

    protected abstract MS getService();

}