package io.github.ianfairman.example.jpa.liquibase.entity.jpa;

import io.github.ianfairman.example.jpa.liquibase.entity.Family;
import io.github.ianfairman.example.jpa.liquibase.entity.Individual;
import io.github.ianfairman.example.jpa.liquibase.value.FamilyId;
import static io.github.ianfairman.example.jpa.liquibase.value.FamilyId.familyId;
import io.github.ianfairman.example.jpa.liquibase.value.LastName;
import static io.github.ianfairman.example.jpa.liquibase.value.LastName.lastName;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FAMILY")
@NamedQueries({
    @NamedQuery(name = "FamilyJpa.findAll", query = "SELECT f FROM FamilyJpa f")
    ,
    @NamedQuery(name = "FamilyJpa.findById", query = "SELECT f FROM FamilyJpa f WHERE f.id = :id")
    ,
    @NamedQuery(name = "FamilyJpa.findByLastName", query = "SELECT f FROM FamilyJpa f WHERE f.lastName = :lastName")})
public class FamilyJpa implements Serializable, Family {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LAST_NAME")
    private String lastName;
    @OneToMany(targetEntity = IndividualJpa.class, mappedBy = "family")
    private List<Individual> individualList;

    public FamilyJpa() {
    }

    public FamilyJpa(Integer id) {
        this.id = id;
    }

    public FamilyJpa(FamilyId id) {
        this.id = id.getValue();
    }

    @Transient
    @Override
    public FamilyId getId() {
        return familyId(id);
    }

    @Transient
    @Override
    public void setId(FamilyId id) {
        this.id = id.getValue();
    }

    @Transient
    @Override
    public LastName getLastName() {
        return lastName(lastName);
    }

    @Transient
    @Override
    public void setLastName(LastName lastName) {
        this.lastName = lastName.getValue();
    }

    @Override
    public List<Individual> getIndividualList() {
        return individualList;
    }

    @Override
    public void setIndividualList(List<Individual> individualList) {
        this.individualList = individualList;
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
        if (!(object instanceof FamilyJpa)) {
            return false;
        }
        FamilyJpa other = (FamilyJpa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "template.example.jpa.liquibase.entity.Family[ id=" + id + " ]";
    }
}
