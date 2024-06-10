package vertex.vertex_backend.auth;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vertex.vertex_backend.event.Event;
import vertex.vertex_backend.user.Role;

//step7
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;
    Integer id;
    String username;
    String email;
    String profileImg;
    String gender;
    String description;
    String occupation;
    Role role;
    List<Event> events;
}
