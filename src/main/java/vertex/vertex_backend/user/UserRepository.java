package vertex.vertex_backend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//step12
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
