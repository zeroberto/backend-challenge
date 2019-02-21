package com.invillia.acme.service;

import com.invillia.acme.entity.Store;
import com.invillia.acme.repository.StoreRepository;
import com.invillia.acme.test.data.factory.StoreTestDataFactory;
import com.invillia.acme.test.suport.ModelServiceTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Store service unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class StoreServiceTest extends ModelServiceTest<Store, StoreRepository, StoreService> {

    @InjectMocks
    private StoreService service;

    @Mock
    private StoreRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Override
    protected Store createEntity() {
        return new StoreTestDataFactory().create();
    }

    @Override
    protected StoreRepository getRepository() {
        return this.repository;
    }

    @Override
    protected StoreService getService() {
        return this.service;
    }

    @Test
    void givenAName_whenFindByName_thenSuccess() {
        Store store = createEntity();
        when(repository.findByName(Mockito.anyString())).thenReturn(Optional.of(store));
        Store found = getService().findByName(store.getName());
        assertEquals(found.getId(), store.getId());
    }

}
