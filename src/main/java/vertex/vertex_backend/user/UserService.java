package vertex.vertex_backend.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vertex.vertex_backend.event.Event;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElse(null); // Devolver null si no se encuentra el usuario
    }

    public void addEventToUser(Integer userId, Event event) {
        User user = getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }

        user.addEvent(event);
        userRepository.save(user);
    }

    @Transactional
    public User updateUser(Integer userId, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        if (updateUserRequest.getEmail() != null) {
            user.setEmail(updateUserRequest.getEmail());
        }
        if (updateUserRequest.getProfileImg() != null) {
            user.setProfileImg(updateUserRequest.getProfileImg());
        }
        if (updateUserRequest.getGender() != null) {
            user.setGender(updateUserRequest.getGender());
        }
        if (updateUserRequest.getAge() != null) {
            user.setAge(updateUserRequest.getAge());
        }
        if (updateUserRequest.getDescription() != null) {
            user.setDescription(updateUserRequest.getDescription());
        }
        if (updateUserRequest.getOccupation() != null) {
            user.setOccupation(updateUserRequest.getOccupation());
        }
        if (updateUserRequest.getRole() != null) {
            user.setRole(updateUserRequest.getRole());
        }

        return userRepository.save(user);
    }
}