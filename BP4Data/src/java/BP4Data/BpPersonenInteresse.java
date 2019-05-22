/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BP4Data;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lizav
 */
@Entity
@Table(name = "BP_PERSONEN_INTERESSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpPersonenInteresse.findAll", query = "SELECT b FROM BpPersonenInteresse b")
    , @NamedQuery(name = "BpPersonenInteresse.findByPerint", query = "SELECT b FROM BpPersonenInteresse b WHERE b.perint = :perint")})
public class BpPersonenInteresse implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERINT")
    private BigDecimal perint;
    @JoinColumn(name = "INTERESSE", referencedColumnName = "INTERESSE")
    @ManyToOne(optional = false)
    private BpInteresses interesse;
    @JoinColumn(name = "PERSOON_NAAM", referencedColumnName = "NAAM")
    @ManyToOne(optional = false)
    private BpPersonen persoonNaam;

    public BpPersonenInteresse() {
    }

    public BpPersonenInteresse(BigDecimal perint) {
        this.perint = perint;
    }

    public BigDecimal getPerint() {
        return perint;
    }

    public void setPerint(BigDecimal perint) {
        this.perint = perint;
    }

    public BpInteresses getInteresse() {
        return interesse;
    }

    public void setInteresse(BpInteresses interesse) {
        this.interesse = interesse;
    }

    public BpPersonen getPersoonNaam() {
        return persoonNaam;
    }

    public void setPersoonNaam(BpPersonen persoonNaam) {
        this.persoonNaam = persoonNaam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perint != null ? perint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BpPersonenInteresse)) {
            return false;
        }
        BpPersonenInteresse other = (BpPersonenInteresse) object;
        if ((this.perint == null && other.perint != null) || (this.perint != null && !this.perint.equals(other.perint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BP4Data.BpPersonenInteresse[ perint=" + perint + " ]";
    }
    
}
