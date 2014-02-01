package my.ilya.inheritance.model.perclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 29.01.14
 * Time: 18:46
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "EXPULSION_PER")
public class ExpulsionOrderItemPer extends OrderItemPer {

    @Column(name = "EXPULSION_DATE")
    private Date expulsionDate;

    public Date getExpulsionDate() {
        return expulsionDate;
    }

    public void setExpulsionDate(Date expulsionDate) {
        this.expulsionDate = expulsionDate;
    }
}
