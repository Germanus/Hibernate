package my.ilya.inheritance.model.discriminator;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author KAZAKEVICH
 */
@Entity
@DiscriminatorValue(value = "TRANSFER")
public class TransferOrderItemSingle extends OrderItemSingle {

    @Column(name = "START_DATE")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
