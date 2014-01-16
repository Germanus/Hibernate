package my.ilya.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Named_Query_Test")
@NamedQueries({
        @NamedQuery(
                name = "findNQ",
                query = "from NamedQueryTest s where s.name = :name"
        )
})
public class NamedQueryTest implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int ID;
    @Column(name="NAME")
    private String name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
