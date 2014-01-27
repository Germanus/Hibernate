package my.ilya.relationship.model;

import javax.persistence.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 27.01.14
 * Time: 0:57
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "subjects")
    private List<Aim> aimList = new ArrayList<Aim>();

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

    public List<Aim> getAimList() {
        return aimList;
    }

    public void setAimList(List<Aim> aimList) {
        this.aimList = aimList;
    }
}
