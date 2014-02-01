package my.ilya.inheritance.model.joined;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 29.01.14
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ORDER_ITEM_JOINED")
public class OrderItemJoined {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ORDER_ITEM_ID")
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
