package com.invillia.acme.repository;

import com.invillia.acme.core.model.ModelRepository;
import com.invillia.acme.entity.User;

import java.util.Optional;

/**
 * User entity repository.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface UserRepository extends ModelRepository<User> {

    /**
     * Method to get an user by username.
     *
     * @param username Desired username.
     * @return User found.
     */
    Optional<User> findByUsername(String username);

    /**
     * Method to check if a user name is already registered.
     *
     * @param username Username to verify.
     * @return Boolean Boolean indicating the presence or not of the user name in the database.
     */
    Boolean existsByUsername(String username);

}