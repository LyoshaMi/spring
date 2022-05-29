package homework;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shopper_product")
@NoArgsConstructor
public class Order {

    @EmbeddedId
    private OrderKey orderKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopper_id", insertable = false, updatable = false)
    private Shopper shopper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "cost")
    private int cost;

    @Override
    public String toString() {
        return "Order{" +
                "orderKey=" + orderKey +
                ", cost=" + cost +
                '}';
    }
}
