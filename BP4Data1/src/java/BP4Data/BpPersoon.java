/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BP4Data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lizav
 */
@Entity
@Table(name = "BP_PERSOON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpPersoon.findAll", query = "SELECT b FROM BpPersoon b")
    , @NamedQuery(name = "BpPersoon.findByNaam", query = "SELECT b FROM BpPersoon b WHERE b.naam = :naam")
    , @NamedQuery(name = "BpPersoon.findBySoort", query = "SELECT b FROM BpPersoon b WHERE b.soort = :soort")
    , @NamedQuery(name = "BpPersoon.findByKoffieofthee", query = "SELECT b FROM BpPersoon b WHERE b.koffieofthee = :koffieofthee")})
public class BpPersoon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAAM")
    private String naam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "SOORT")
    private String soort;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "KOFFIEOFTHEE")
    private String koffieofthee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persoonNaam")
    private Collection<BpPersoonInteresse> bpPersoonInteresseCollection;

    public BpPersoon() {
    }

    public BpPersoon(String naam) {
        this.naam = naam;
    }

    public BpPersoon(String naam, String soort, String koffieofthee) {
        this.naam = naam;
        this.soort = soort;
        this.koffieofthee = koffieofthee;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public String getKoffieofthee() {
        return koffieofthee;
    }

    public void setKoffieofthee(String koffieofthee) {
        this.koffieofthee = koffieofthee;
    }

    @XmlTransient
    public Collection<BpPersoonInteresse> getBpPersoonInteresseCollection() {
        return bpPersoonInteresseCollection;
    }

    public void setBpPersoonInteresseCollection(Collection<BpPersoonInteresse> bpPersoonInteresseCollection) {
        this.bpPersoonInteresseCollection = bpPersoonInteresseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (naam != null ? naam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BpPersoon)) {
            return false;
        }
        BpPersoon other = (BpPersoon) object;
        if ((this.naam == null && other.naam != null) || (this.naam != null && !this.naam.equals(other.naam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BP4Data.BpPersoon[ naam=" + naam + " ]";
    }
    
}
