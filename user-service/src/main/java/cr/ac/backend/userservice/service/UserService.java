package cr.ac.backend.userservice.service;



import cr.ac.backend.userservice.model.AuthenticationResponse;
import cr.ac.backend.userservice.model.User;
import cr.ac.backend.userservice.model.UserAuth;
import cr.ac.backend.userservice.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User request);

    Optional<UserDto> authenticate(UserAuth request);


    Optional<List<UserDto>> getUsers();

    Optional<User> getUserById(Long id);

    Optional<UserDto> findByUserName(String username);

    Optional<UserDto> findByEmail(String email);
}