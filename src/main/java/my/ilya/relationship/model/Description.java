package my.ilya.relationship.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 19.01.14
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DESCRIPTION")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
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
