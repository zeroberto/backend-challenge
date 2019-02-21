package com.invillia.acme.core.gateway;

import com.invillia.acme.core.model.ModelEntity;
import com.invillia.acme.core.model.ModelRepository;
import com.invillia.acme.core.model.ModelService;
import com.invillia.acme.core.utils.SimpleEntry;
import com.invillia.acme.exceptions.ModelEntityNotFoundException;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Class of service to perform asynchronous communication between the model layer and the control layer.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Async
@Getter
public abstract class ServiceGateway<DTO, ME extends ModelEntity, MR extends ModelRepository<ME>, MS extends ModelService<ME, MR>> {

    @Autowired
    private MS service;

    @Autowired
    private ModelMapper modelMapper;

    private final Class<DTO> dtoClassType;

    public ServiceGateway(Class<DTO> dtoClassType) {
        this.dtoClassType = dtoClassType;
    }

    /**
     * Method for creating a particular resource.
     *
     * @param requestDTO Desired object to save.
     * @return A CompletableFuture containing the created resource.
     */
    public Future<DTO> create(DTO requestDTO) {
        ME modelEntity = getModelMapper().map(requestDTO, getService().getEntityType());
        getService().save(modelEntity);
        return CompletableFuture.completedFuture(
                getModelMapper().map(modelEntity, getDtoClassType())
        );
    }

    /**
     * Method for updating a particular resource.
     *
     * @param id         Desired object identification.
     * @param requestDTO Desired object to save.
     * @return A CompletableFuture containing the updated resource.
     */
    public Future<SimpleEntry<DTO, HttpStatus>> update(Long id, DTO requestDTO) {
        SimpleEntry<DTO, HttpStatus> simpleEntry = new SimpleEntry<>();
        try {
            ME modelEntity = getService().find(id);
            getModelMapper().map(requestDTO, modelEntity);
            getService().update(modelEntity);
            simpleEntry.setKey(getModelMapper().map(modelEntity, getDtoClassType()));
            simpleEntry.setValue(HttpStatus.OK);
        } catch (ModelEntityNotFoundException ex) {
            ME modelEntity = getModelMapper().map(requestDTO, getService().getEntityType());
            getService().save(modelEntity);
            simpleEntry.setKey(getModelMapper().map(modelEntity, getDtoClassType()));
            simpleEntry.setValue(HttpStatus.CREATED);
        }
        return CompletableFuture.completedFuture(simpleEntry);
    }

    /**
     * Method for updating a particular resource.
     *
     * @param id         Desired object identification.
     * @param requestDTO Desired object to save.
     */
    public void partialUpdate(Long id, DTO requestDTO) {
        ME modelEntity = getService().find(id);
        getModelMapper().map(requestDTO, modelEntity);
        getService().update(modelEntity);
    }

    /**
     * Method for searching for a particular resource.
     *
     * @param id Desired object identification.
     * @return A CompletableFuture containing the requested resource.
     */
    public Future<DTO> find(Long id) {
        ME modelEntity = getService().find(id);
        return CompletableFuture.completedFuture(
                getModelMapper().map(modelEntity, getDtoClassType())
        );
    }

    /**
     * Method for deleting a particular resource.
     *
     * @param id Desired object identification.
     * @return A CompletableFuture containing the deleted resource.
     */
    public Future<DTO> delete(Long id) {
        ME modelEntity = getService().delete(id);
        return CompletableFuture.completedFuture(
                getModelMapper().map(modelEntity, getDtoClassType())
        );
    }

    /**
     * Method to list a particular resource.
     *
     * @return A CompletableFuture containing the list of requested resource.
     */
    public Future<List<DTO>> list() {
        List<ME> modelEntities = getService().list();
        List<DTO> dtos = new ArrayList<>();
        modelEntities.forEach(me -> dtos.add(getModelMapper().map(me, getDtoClassType())));
        return CompletableFuture.completedFuture(dtos);
    }

}