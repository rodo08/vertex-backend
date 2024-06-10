package vertex.vertex_backend.event;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vertex.vertex_backend.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue
    Integer id;

    @Basic
    @Column(nullable = false)
    String eventTitle;

    @Column(nullable = false)
    String eventImg;

    @Column(nullable = false)
    String eventDescription;

    @Column(nullable = false)
    String eventDate;

    @Column(nullable = false)
    String eventType;

    @Column(nullable = false)
    String eventLocation;

    @Column(nullable = false)
    String eventColaborators;

    @ManyToOne
    @JsonIgnore
    User user;
}
