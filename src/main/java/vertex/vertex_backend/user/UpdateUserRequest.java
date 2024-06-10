package vertex.vertex_backend.user;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String email;
    private String profileImg;
    private Integer age;
    private String gender;
    private String occupation;
    private String description;
    private Role role;
}
