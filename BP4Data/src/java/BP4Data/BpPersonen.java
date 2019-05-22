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
@Table(name = "BP_PERSONEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpPersonen.findAll", query = "SELECT b FROM BpPersonen b")
    , @NamedQuery(name = "BpPersonen.findByNaam", query = "SELECT b FROM BpPersonen b WHERE b.naam = :naam")
    , @NamedQuery(name = "BpPersonen.findBySoort", query = "SELECT b FROM BpPersonen b WHERE b.soort = :soort")
    , @NamedQuery(name = "BpPersonen.findByKoffieofthee", query = "SELECT b FROM BpPersonen b WHERE b.koffieofthee = :koffieofthee")})
public class BpPersonen implements Serializable {

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
    private Collection<BpPersonenInteresse> bpPersonenInteresseCollection;

    public BpPersonen() {
    }

    public BpPersonen(String naam) {
        this.naam = naam;
    }

    public BpPersonen(String naam, String soort, String koffieofthee) {
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
    public Collection<BpPersonenInteresse> getBpPersonenInteresseCollection() {
        return bpPersonenInteresseCollection;
    }

    public void setBpPersonenInteresseCollection(Collection<BpPersonenInteresse> bpPersonenInteresseCollection) {
        this.bpPersonenInteresseCollection = bpPersonenInteresseCollection;
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
        if (!(object instanceof BpPersonen)) {
            return false;
        }
        BpPersonen other = (BpPersonen) object;
        if ((this.naam == null && other.naam != null) || (this.naam != null && !this.naam.equals(other.naam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BP4Data.BpPersonen[ naam=" + naam + " ]";
    }
    
}
