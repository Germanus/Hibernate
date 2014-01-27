package my.ilya.relationship.model;


import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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
    private long id;
    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Description description;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinTable(joinColumns = @JoinColumn(name = "AIM_ID"),
            inverseJoinColumns = @JoinColumn(name="SUB_AIM_ID")
    )
    private List<SubAim> subAim = new ArrayList<SubAim>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(joinColumns = @JoinColumn(name = "AIM_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    private List<Subject> subjects = new ArrayList<Subject>();

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

    public List<SubAim> getSubAim() {
        return subAim;
    }

    public void setSubAim(List<SubAim> subAim) {
        this.subAim = subAim;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
