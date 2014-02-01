package my.ilya.inheritance.model.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author KAZAKEVICH
 */
@Entity
@Table(name = "TRANSFER_JOINED")
public class TransferOrderItemJoined extends OrderItemJoined {

    @Column(name = "START_DATE")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
