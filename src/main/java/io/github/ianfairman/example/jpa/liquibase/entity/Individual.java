package io.github.ianfairman.example.jpa.liquibase.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import io.github.ianfairman.example.jpa.liquibase.value.FirstName;
import static io.github.ianfairman.example.jpa.liquibase.value.FirstName.firstName;
import io.github.ianfairman.example.jpa.liquibase.value.IndividualId;
import static io.github.ianfairman.example.jpa.liquibase.value.IndividualId.individualId;

@Entity
@Table(name = "INDIVIDUAL")
@NamedQueries({
    @NamedQuery(name = "Individual.findAll", query = "SELECT i FROM Individual i"),
    @NamedQuery(name = "Individual.findById", query = "SELECT i FROM Individual i WHERE i.id = :id"),
    @NamedQuery(name = "Individual.findByFirstName", query = "SELECT i FROM Individual i WHERE i.firstName = :firstName")})
public class Individual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @JoinColumn(name = "FAMILY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Family family;

    public Individual() {
    }

    public Individual(Integer id) {
        this.id = id;
    }
    
    public Individual(IndividualId id) {
        this.id = id.getValue();
    }

    @Transient
    public IndividualId getId() {
        return individualId(id);
    }

    @Transient
    public void setId(IndividualId id) {
        this.id = id.getValue();
    }

    @Transient
    public FirstName getFirstName() {
        return firstName(firstName);
    }

    @Transient
    public void setFirstName(FirstName firstName) {
        this.firstName = firstName.getValue();
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Individual)) {
            return false;
        }
        Individual other = (Individual) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "template.example.jpa.liquibase.entity.Individual[ id=" + id + " ]";
    }

}
