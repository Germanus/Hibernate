package my.ilya.crud.model;

import my.ilya.dto.UserDetails;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author KAZAKEVICH
 */

@Entity
@NamedQuery(name = "getPhoneById", query = "from Phone where id=?")
@NamedNativeQuery(name = "getNativePhoneById", query =
        "select * from PHONE where NUMBER=?", resultClass = Phone.class)
@Table(name = "PHONE")
@Cacheable
@org.hibernate.annotations.Cache (usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int ID;
    @Column(name = "NUMBER")
    private Long number;

    @Version
    @Column(name = "VERSION")
    private Long version;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
    
    
}

