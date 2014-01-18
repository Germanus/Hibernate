package my.ilya.relationship.model;

import org.omg.PortableServer.IdAssignmentPolicyValue;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 19.01.14
 * Time: 0:04
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "AIM")
public class Aim {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
