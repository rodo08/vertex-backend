package vertex.vertex_backend.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vertex.vertex_backend.jwt.JwtService;
import vertex.vertex_backend.user.Role;
import vertex.vertex_backend.user.User;
import vertex.vertex_backend.user.UserRepository;

//step9
@Service
@RequiredArgsConstructor
public class AuthService {

        private final UserRepository userRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
                UserDetails userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
                User user = (User) userDetails; // Casting UserDetails a User
                String token = jwtService.getToken(user);
                return AuthResponse.builder()
                                .token(token)
                                .id(user.getId())
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .profileImg(user.getProfileImg())
                                .gender(user.getGender())
                                .description(user.getDescription())
                                .occupation(user.getOccupation())
                                .role(user.getRole())
                                .events(user.getEvents()) // Obtener los eventos asociados al usuario
                                .build();
        }

        // ste19
        public AuthResponse register(RegisterRequest request) {
                User user = User.builder()
                                .username(request.getUsername())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER)
                                .build();

                userRepository.save(user);

                return AuthResponse.builder()
                                .token(jwtService.getToken(user))
                                .id(user.getId())
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .profileImg(user.getProfileImg())
                                .gender(user.getGender())
                                .description(user.getDescription())
                                .occupation(user.getOccupation())
                                .role(user.getRole())
                                .events(user.getEvents()) // Obtener los eventos asociados al usuario
                                .build();

        }
}
