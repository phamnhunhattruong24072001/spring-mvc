package java_training.com.crud.service;

import java_training.com.crud.dto.UserDTO;
import java_training.com.crud.model.User;
import java_training.com.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertUserToDTO)
                .collect(Collectors.toList());
    }

    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());

        userRepository.save(user);
    }

    public String updateUser(UserDTO userDTO, Long id) {
        Integer intId = id.intValue();
        Optional<User> existingUser = userRepository.findById(intId);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setUsername(user.getUsername());

            userRepository.save(user);
        }

        return "redirect:/user/list";
    }

    public Optional<User> getUserById(Long id) {
        Integer intId = id.intValue();
        return userRepository.findById(intId);
    }

    private UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }

    public String deleteUser(Long id) {
        Integer intId = id.intValue();
        if (userRepository.existsById(intId)) {
            userRepository.deleteById(intId);
        }

        return "redirect:/user/list";
    }
}
