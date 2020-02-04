package co.com.PruebaWS.entidades;


import java.math.BigDecimal;
import java.util.Date;

/**
 * Factura generated by hbm2java
 */
public class Factura  implements java.io.Serializable {


     private Integer facturaId;
     private String razonSocialEmisor;
     private Integer nitEmisor;
     private String razonSocialReceptor;
     private Integer nitReceptor;
     private Date fechaEmision;
     private String descripcionItem;
     private Integer cantidadItem;
     private BigDecimal valorUnitarioItem;
     private BigDecimal valorNetoSinIva;
     private BigDecimal valorIva;
     private BigDecimal valorTotal;
     private Integer estado;

    public Factura() {
    }

    public Factura(String razonSocialEmisor, Integer nitEmisor, String razonSocialReceptor, Integer nitReceptor, Date fechaEmision, String descripcionItem, Integer cantidadItem, BigDecimal valorUnitarioItem, BigDecimal valorNetoSinIva, BigDecimal valorIva, BigDecimal valorTotal, Integer estado) {
       this.razonSocialEmisor = razonSocialEmisor;
       this.nitEmisor = nitEmisor;
       this.razonSocialReceptor = razonSocialReceptor;
       this.nitReceptor = nitReceptor;
       this.fechaEmision = fechaEmision;
       this.descripcionItem = descripcionItem;
       this.cantidadItem = cantidadItem;
       this.valorUnitarioItem = valorUnitarioItem;
       this.valorNetoSinIva = valorNetoSinIva;
       this.valorIva = valorIva;
       this.valorTotal = valorTotal;
       this.estado = estado;
    }
   
    public Integer getFacturaId() {
        return this.facturaId;
    }
    
    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }
    public String getRazonSocialEmisor() {
        return this.razonSocialEmisor;
    }
    
    public void setRazonSocialEmisor(String razonSocialEmisor) {
        this.razonSocialEmisor = razonSocialEmisor;
    }
    public Integer getNitEmisor() {
        return this.nitEmisor;
    }
    
    public void setNitEmisor(Integer nitEmisor) {
        this.nitEmisor = nitEmisor;
    }
    public String getRazonSocialReceptor() {
        return this.razonSocialReceptor;
    }
    
    public void setRazonSocialReceptor(String razonSocialReceptor) {
        this.razonSocialReceptor = razonSocialReceptor;
    }
    public Integer getNitReceptor() {
        return this.nitReceptor;
    }
    
    public void setNitReceptor(Integer nitReceptor) {
        this.nitReceptor = nitReceptor;
    }
    public Date getFechaEmision() {
        return this.fechaEmision;
    }
    
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public String getDescripcionItem() {
        return this.descripcionItem;
    }
    
    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }
    public Integer getCantidadItem() {
        return this.cantidadItem;
    }
    
    public void setCantidadItem(Integer cantidadItem) {
        this.cantidadItem = cantidadItem;
    }
    public BigDecimal getValorUnitarioItem() {
        return this.valorUnitarioItem;
    }
    
    public void setValorUnitarioItem(BigDecimal valorUnitarioItem) {
        this.valorUnitarioItem = valorUnitarioItem;
    }
    public BigDecimal getValorNetoSinIva() {
        return this.valorNetoSinIva;
    }
    
    public void setValorNetoSinIva(BigDecimal valorNetoSinIva) {
        this.valorNetoSinIva = valorNetoSinIva;
    }
    public BigDecimal getValorIva() {
        return this.valorIva;
    }
    
    public void setValorIva(BigDecimal valorIva) {
        this.valorIva = valorIva;
    }
    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }
    
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
}


