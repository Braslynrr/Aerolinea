/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logic;

import aerolinea.logic.MetodoPago;
import aerolinea.logic.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mario
 */
@Entity
@Table(name = "reserva")
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByCodigo", query = "SELECT r FROM Reserva r WHERE r.codigo = :codigo")})
public class Reserva implements Serializable {

    @JoinColumn(name = "Pago", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private MetodoPago pago;
    @JoinColumn(name = "Usuario", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Usuario usuario;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaCodigo")
    private List<Tiquete> tiqueteList;
    @JoinColumn(name = "Metodo_Pago_Codigo", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private MetodoPago metodoPagoCodigo;
    @JoinColumn(name = "Usuario_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuarioID;
    @JoinColumn(name = "Viaje", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Viaje viaje;

    public Reserva() {
    }

    public Reserva(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Tiquete> getTiqueteList() {
        return tiqueteList;
    }

    public void setTiqueteList(List<Tiquete> tiqueteList) {
        this.tiqueteList = tiqueteList;
    }

    public MetodoPago getMetodoPagoCodigo() {
        return metodoPagoCodigo;
    }

    public void setMetodoPagoCodigo(MetodoPago metodoPagoCodigo) {
        this.metodoPagoCodigo = metodoPagoCodigo;
    }

    public Usuario getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
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
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.Reserva[ codigo=" + codigo + " ]";
    }

    public MetodoPago getPago() {
        return pago;
    }

    public void setPago(MetodoPago pago) {
        this.pago = pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
