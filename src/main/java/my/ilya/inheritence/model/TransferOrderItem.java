package my.ilya.inheritence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author KAZAKEVICH
 */
@Entity
public class TransferOrderItem extends OrderItem{

    @Column(name = "START_DATE")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
