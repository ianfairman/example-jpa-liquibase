package io.github.ianfairman.example.jpa.liquibase.entity;

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
import io.github.ianfairman.example.jpa.liquibase.value.FamilyId;
import static io.github.ianfairman.example.jpa.liquibase.value.FamilyId.familyId;
import io.github.ianfairman.example.jpa.liquibase.value.LastName;
import static io.github.ianfairman.example.jpa.liquibase.value.LastName.lastName;

@Entity
@Table(name = "FAMILY")
@NamedQueries({
    @NamedQuery(name = "Family.findAll", query = "SELECT f FROM Family f"),
    @NamedQuery(name = "Family.findById", query = "SELECT f FROM Family f WHERE f.id = :id"),
    @NamedQuery(name = "Family.findByLastName", query = "SELECT f FROM Family f WHERE f.lastName = :lastName")})
public class Family implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LAST_NAME")
    private String lastName;
    @OneToMany(mappedBy = "family")
    private List<Individual> individualList;

    public Family() {
    }

    public Family(Integer id) {
        this.id = id;
    }
    
    public Family(FamilyId id) {
        this.id = id.getValue();
    }

    @Transient
    public FamilyId getId() {
        return familyId(id);
    }
    
    @Transient
    public void setId(FamilyId id) {
        this.id = id.getValue();
    }

    @Transient
    public LastName getLastName() {
        return lastName(lastName);
    }

    @Transient
    public void setLastName(LastName lastName) {
        this.lastName = lastName.getValue();
    }

    public List<Individual> getIndividualList() {
        return individualList;
    }

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
        if (!(object instanceof Family)) {
            return false;
        }
        Family other = (Family) object;
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
