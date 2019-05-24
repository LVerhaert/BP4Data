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
@Table(name = "BP_INTERESSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpInteresse.findAll", query = "SELECT b FROM BpInteresse b")
    , @NamedQuery(name = "BpInteresse.findByOnderwerp", query = "SELECT b FROM BpInteresse b WHERE b.onderwerp = :onderwerp")})
public class BpInteresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ONDERWERP")
    private String onderwerp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interesseOnderwerp")
    private Collection<BpPersoonInteresse> bpPersoonInteresseCollection;

    public BpInteresse() {
    }

    public BpInteresse(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
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
        hash += (onderwerp != null ? onderwerp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BpInteresse)) {
            return false;
        }
        BpInteresse other = (BpInteresse) object;
        if ((this.onderwerp == null && other.onderwerp != null) || (this.onderwerp != null && !this.onderwerp.equals(other.onderwerp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BP4Data.BpInteresse[ onderwerp=" + onderwerp + " ]";
    }
    
}
