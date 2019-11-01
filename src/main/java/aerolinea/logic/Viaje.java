/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logic;

import aerolinea.logic.Vuelo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mario
 */
@Entity
@Table(name = "viaje")
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v"),
    @NamedQuery(name = "Viaje.findByCodigo", query = "SELECT v FROM Viaje v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "Viaje.findByDsalida", query = "SELECT v FROM Viaje v WHERE v.dsalida = :dsalida"),
    @NamedQuery(name = "Viaje.findByDregreso", query = "SELECT v FROM Viaje v WHERE v.dregreso = :dregreso")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "Dsalida")
    @Temporal(TemporalType.DATE)
    private Date dsalida;
    @Column(name = "Dregreso")
    @Temporal(TemporalType.DATE)
    private Date dregreso;
    @JoinColumn(name = "Ida", referencedColumnName = "Identificador")
    @ManyToOne(optional = false)
    private Vuelo ida;
    @JoinColumn(name = "Regreso", referencedColumnName = "Identificador")
    @ManyToOne
    private Vuelo regreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaje")
    private List<Reserva> reservaList;

    public Viaje() {
    }

    public Viaje(String codigo) {
        this.codigo = codigo;
    }

    public Viaje(String codigo, Date dsalida) {
        this.codigo = codigo;
        this.dsalida = dsalida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDsalida() {
        return dsalida;
    }

    public void setDsalida(Date dsalida) {
        this.dsalida = dsalida;
    }

    public Date getDregreso() {
        return dregreso;
    }

    public void setDregreso(Date dregreso) {
        this.dregreso = dregreso;
    }

    public Vuelo getIda() {
        return ida;
    }

    public void setIda(Vuelo ida) {
        this.ida = ida;
    }

    public Vuelo getRegreso() {
        return regreso;
    }

    public void setRegreso(Vuelo regreso) {
        this.regreso = regreso;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.Viaje[ codigo=" + codigo + " ]";
    }
    
}
