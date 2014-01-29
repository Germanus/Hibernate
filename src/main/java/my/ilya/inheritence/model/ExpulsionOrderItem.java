package my.ilya.inheritence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 29.01.14
 * Time: 18:46
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ExpulsionOrderItem extends OrderItem{

    @Column(name = "EXPULSION_DATE")
    private Date expulsionDate;

    public Date getExpulsionDate() {
        return expulsionDate;
    }

    public void setExpulsionDate(Date expulsionDate) {
        this.expulsionDate = expulsionDate;
    }
}
