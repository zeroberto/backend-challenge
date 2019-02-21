package com.invillia.acme.core.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Application default repository class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Repository
public interface ModelRepository<ME extends ModelEntity> extends JpaRepository<ME, Long> {
}