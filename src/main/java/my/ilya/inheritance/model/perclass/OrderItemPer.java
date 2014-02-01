package my.ilya.inheritance.model.perclass;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 29.01.14
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "ORDER_ITEM_PER")
public class OrderItemPer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "NAME")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
