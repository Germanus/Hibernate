package my.ilya.relationship.model;


import org.hibernate.annotations.Entity;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 19.01.14
 * Time: 0:04
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Entity
@Table(name = "AIM")
public class Aim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Description description;


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

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
