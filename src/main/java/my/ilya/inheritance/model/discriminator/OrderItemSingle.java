package my.ilya.inheritance.model.discriminator;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 29.01.14
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ORDER_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ORDER_ITEM_DISC")
@Table(name = "ORDER_ITEM_DISC")
public class OrderItemSingle {

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
