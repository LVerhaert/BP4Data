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
@Table(name = "BP_PERSOON_INTERESSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpPersoonInteresse.findAll", query = "SELECT b FROM BpPersoonInteresse b")
    , @NamedQuery(name = "BpPersoonInteresse.findById", query = "SELECT b FROM BpPersoonInteresse b WHERE b.id = :id")})
public class BpPersoonInteresse implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "INTERESSE_ONDERWERP", referencedColumnName = "ONDERWERP")
    @ManyToOne(optional = false)
    private BpInteresse interesseOnderwerp;
    @JoinColumn(name = "PERSOON_NAAM", referencedColumnName = "NAAM")
    @ManyToOne(optional = false)
    private BpPersoon persoonNaam;

    public BpPersoonInteresse() {
    }

    public BpPersoonInteresse(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BpInteresse getInteresseOnderwerp() {
        return interesseOnderwerp;
    }

    public void setInteresseOnderwerp(BpInteresse interesseOnderwerp) {
        this.interesseOnderwerp = interesseOnderwerp;
    }

    public BpPersoon getPersoonNaam() {
        return persoonNaam;
    }

    public void setPersoonNaam(BpPersoon persoonNaam) {
        this.persoonNaam = persoonNaam;
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
        if (!(object instanceof BpPersoonInteresse)) {
            return false;
        }
        BpPersoonInteresse other = (BpPersoonInteresse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BP4Data.BpPersoonInteresse[ id=" + id + " ]";
    }
    
}
