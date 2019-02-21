package com.invillia.acme.http.gateway;

import com.invillia.acme.core.gateway.ServiceGateway;
import com.invillia.acme.dto.UserDTO;
import com.invillia.acme.entity.User;
import com.invillia.acme.repository.UserRepository;
import com.invillia.acme.security.JwtTokenProvider;
import com.invillia.acme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * User service gateway class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Component
public class UserGateway extends ServiceGateway<UserDTO, User, UserRepository, UserService> {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserGateway() {
        super(UserDTO.class);
    }

    /**
     * Method for performing authentication of a user in the application.
     *
     * @param username User username.
     * @param password User password.
     * @return CompletableFuture containing the token for access application.
     */
    public Future<String> login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return CompletableFuture.completedFuture(
                    jwtTokenProvider.createToken(getService().findByUsername(username))
            );
        } catch (AuthenticationException e) {
            throw new com.invillia.acme.security.exceptions.AuthenticationException(e);
        }
    }

    /**
     * Method to perform the registration of a user in the application.
     *
     * @param requestDTO New user.
     * @return CompletableFuture containing the token for access application.
     */
    public Future<String> signup(UserDTO requestDTO) {
        User user = getModelMapper().map(requestDTO, getService().getEntityType());
        getService().save(user);
        return CompletableFuture.completedFuture(
                jwtTokenProvider.createToken(user)
        );
    }

    /**
     * Check who is logged in token.
     *
     * @param req Http Servlet Request.
     * @return A CompletableFuture containing the logged user.
     */
    public Future<UserDTO> whoami(HttpServletRequest req) {
        User user = getService().findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
        return CompletableFuture.completedFuture(
                getModelMapper().map(user, getDtoClassType())
        );
    }

    /**
     * Method to refresh the token.
     *
     * @param username Desired username.
     * @return A CompletableFuture containing the refreshed token.
     */
    public Future<String> refresh(String username) {
        return CompletableFuture.completedFuture(
                jwtTokenProvider.createToken(getService().findByUsername(username))
        );
    }

}
