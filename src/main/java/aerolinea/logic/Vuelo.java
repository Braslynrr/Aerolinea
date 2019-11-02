/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin2
 */
@Entity
@Table(name = "vuelo")
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
    @NamedQuery(name = "Vuelo.findByIdentificador", query = "SELECT v FROM Vuelo v WHERE v.identificador = :identificador"),
    @NamedQuery(name = "Vuelo.findByDia", query = "SELECT v FROM Vuelo v WHERE v.dia = :dia"),
    @NamedQuery(name = "Vuelo.findBySalida", query = "SELECT v FROM Vuelo v WHERE v.salida = :salida"),
    @NamedQuery(name = "Vuelo.findByLlegada", query = "SELECT v FROM Vuelo v WHERE v.llegada = :llegada"),
    @NamedQuery(name = "Vuelo.findByDuracion", query = "SELECT v FROM Vuelo v WHERE v.duracion = :duracion"),
    @NamedQuery(name = "Vuelo.findByPrecio", query = "SELECT v FROM Vuelo v WHERE v.precio = :precio"),
    @NamedQuery(name = "Vuelo.findByDescuento", query = "SELECT v FROM Vuelo v WHERE v.descuento = :descuento")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Identificador")
    private Integer identificador;
    @Basic(optional = false)
    @Column(name = "Dia")
    private String dia;
    @Basic(optional = false)
    @Column(name = "Salida")
    @Temporal(TemporalType.TIME)
    private Date salida;
    @Column(name = "Llegada",insertable=false,updatable=false)
    @Temporal(TemporalType.TIME)
    private Date llegada;
    @Basic(optional = false)
    @Column(name = "Duracion")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @Basic(optional = false)
    @Column(name = "Precio")
    private double precio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Descuento")
    private BigDecimal descuento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ida")
    private List<Viaje> viajeList;
    @OneToMany(mappedBy = "regreso")
    private List<Viaje> viajeList1;
    @JoinColumn(name = "Avion", referencedColumnName = "Identificador")
    @ManyToOne(optional = false)
    private Avion avion;
    @JoinColumn(name = "Origen", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Ciudad origen;
    @JoinColumn(name = "Destino", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Ciudad destino;

    public Vuelo() {
    }

    public Vuelo(Integer identificador) {
        this.identificador = identificador;
    }

    public Vuelo(Integer identificador, String dia, Date salida, Date duracion, double precio) {
        this.identificador = identificador;
        this.dia = dia;
        this.salida = salida;
        this.duracion = duracion;
        this.precio = precio;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Date getLlegada() {
        return llegada;
    }

    public void setLlegada(Date llegada) {
        this.llegada = llegada;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    public List<Viaje> getViajeList1() {
        return viajeList1;
    }

    public void setViajeList1(List<Viaje> viajeList1) {
        this.viajeList1 = viajeList1;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.Vuelo[ identificador=" + identificador + " ]";
    }
    
}
