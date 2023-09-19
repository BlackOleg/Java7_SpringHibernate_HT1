package olegivanov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persons {
    @EmbeddedId
    private PersonId personId;
    @Column(nullable = false)
    private String phone_number;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="id", nullable=false, updatable=false)
    private City city_of_living;
}
