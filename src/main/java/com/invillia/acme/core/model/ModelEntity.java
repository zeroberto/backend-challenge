package com.invillia.acme.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * Class that represents a higher entity in the application, having attributes and methods
 * common to all entities.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
@DynamicUpdate
public abstract class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew() {
        return Objects.isNull(this.id);
    }

}







