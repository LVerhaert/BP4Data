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
@Table(name = "BP_INTERESSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpInteresses.findAll", query = "SELECT b FROM BpInteresses b")
    , @NamedQuery(name = "BpInteresses.findByInteresse", query = "SELECT b FROM BpInteresses b WHERE b.interesse = :interesse")})
public class BpInteresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "INTERESSE")
    private String interesse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interesse")
    private Collection<BpPersonenInteresse> bpPersonenInteresseCollection;

    public BpInteresses() {
    }

    public BpInteresses(String interesse) {
        this.interesse = interesse;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
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
        hash += (interesse != null ? interesse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BpInteresses)) {
            return false;
        }
        BpInteresses other = (BpInteresses) object;
        if ((this.interesse == null && other.interesse != null) || (this.interesse != null && !this.interesse.equals(other.interesse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BP4Data.BpInteresses[ interesse=" + interesse + " ]";
    }
    
}
