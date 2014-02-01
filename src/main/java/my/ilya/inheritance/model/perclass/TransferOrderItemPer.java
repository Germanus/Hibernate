package my.ilya.inheritance.model.perclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author KAZAKEVICH
 */
@Entity
@Table(name = "TRANSFER_PER")
public class TransferOrderItemPer extends OrderItemPer {

    @Column(name = "START_DATE")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
