package com.invillia.acme.service;

import com.invillia.acme.core.model.ModelService;
import com.invillia.acme.entity.User;
import com.invillia.acme.exceptions.UsernameAlreadyExistsException;
import com.invillia.acme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Optional;

import static com.invillia.acme.constants.BusinessRulesConstants.DEFAULT_ROLES;
import static com.invillia.acme.core.utils.ExceptionUtils.orElseThrows;

/**
 * User service class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Service
public class UserService extends ModelService<User, UserRepository> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService() {
        super(User.class);
    }

    @Override
    public User save(User entity) {
        orElseThrows(getRepository().existsByUsername(entity.getUsername()), new UsernameAlreadyExistsException());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.getRoles().addAll(Arrays.asList(DEFAULT_ROLES));
        return super.save(entity);
    }

    /**
     * Method for find user by username.
     *
     * @param username Username of the desired user.
     * @return User owner of the username.
     */
    public User findByUsername(String username) {
        Optional<User> entity = getRepository().findByUsername(username);
        return entity.orElseThrow(EntityNotFoundException::new);
    }

}
