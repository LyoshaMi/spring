package homework;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class OrderKey implements Serializable {
    static final long SerialVersionUID = 1L;

    @Column(name = "shopper_id")
    private int shopperId;

    @Column(name = "product_id")
    private int productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderKey orderKey = (OrderKey) o;
        return shopperId == orderKey.shopperId && productId == orderKey.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopperId, productId);
    }

    @Override
    public String toString() {
        return "OrderKey{" +
                "shopperId=" + shopperId +
                ", productId=" + productId +
                '}';
    }
}
