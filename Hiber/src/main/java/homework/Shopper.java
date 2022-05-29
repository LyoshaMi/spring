package homework;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "shopper")
@NoArgsConstructor
public class Shopper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shopper")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Order> orders;

    @Override
    public String toString() {
        return "Shopper{" +
                "id=" + id +
                ", name='" + name;
    }
}
