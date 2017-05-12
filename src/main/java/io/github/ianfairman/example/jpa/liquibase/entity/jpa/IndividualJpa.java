package io.github.ianfairman.example.jpa.liquibase.entity.jpa;

import io.github.ianfairman.example.jpa.liquibase.entity.Family;
import io.github.ianfairman.example.jpa.liquibase.entity.Individual;
import io.github.ianfairman.example.jpa.liquibase.value.FirstName;
import static io.github.ianfairman.example.jpa.liquibase.value.FirstName.firstName;
import io.github.ianfairman.example.jpa.liquibase.value.IndividualId;
import static io.github.ianfairman.example.jpa.liquibase.value.IndividualId.individualId;
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

@Entity
@Table(name = "INDIVIDUAL")
@NamedQueries({
    @NamedQuery(name = "IndividualJpa.findAll", query = "SELECT i FROM IndividualJpa i")
    ,
    @NamedQuery(name = "IndividualJpa.findById", query = "SELECT i FROM IndividualJpa i WHERE i.id = :id")
    ,
    @NamedQuery(name = "IndividualJpa.findByFirstName", query = "SELECT i FROM IndividualJpa i WHERE i.firstName = :firstName")})
public class IndividualJpa implements Serializable, Individual {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @JoinColumn(name = "FAMILY_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = FamilyJpa.class)
    private Family family;

    public IndividualJpa() {
    }

    public IndividualJpa(Integer id) {
        this.id = id;
    }

    public IndividualJpa(IndividualId id) {
        this.id = id.getValue();
    }

    @Transient
    @Override
    public IndividualId getId() {
        return individualId(id);
    }

    @Transient
    @Override
    public void setId(IndividualId id) {
        this.id = id.getValue();
    }

    @Transient
    @Override
    public FirstName getFirstName() {
        return firstName(firstName);
    }

    @Transient
    @Override
    public void setFirstName(FirstName firstName) {
        this.firstName = firstName.getValue();
    }

    @Override
    public Family getFamily() {
        return family;
    }

    @Override
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
        if (!(object instanceof IndividualJpa)) {
            return false;
        }
        IndividualJpa other = (IndividualJpa) object;
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
