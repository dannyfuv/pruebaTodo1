/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.PruebaWS.dao;
import co.com.PruebaWS.entidades.Factura;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Date;

/**
 *
 * @author UserQV
 */
public class FacturaDAO {
    
    public List<Factura> listadoFactura() throws Exception {
        SessionFactory sf;
        Session sesion = null;
        List<Factura> lista = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Factura as fac where fac.estado=1");
            lista = (List<Factura>) q.list();

        } catch (Exception e) {
            throw new Exception("ocurrio un problema al listar las facturas: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
            
        }
        return lista;
    }
    
    public List<Factura> buscarFacturaNitReceptor(Integer nitRec) {
        SessionFactory sf;
        Session sesion = null;

        List<Factura> listaFacturas = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Factura as fac where fac.nitReceptor = :nitRec and fac.estado=1");
            q.setInteger("nitRec", nitRec);
            listaFacturas = (List<Factura>) q.list();
            
        } catch (Exception e) {

            throw new RuntimeException("No se pudo obtener la factura: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
           
        }
        return listaFacturas;
    }
    
    public List<Factura> buscarFacturaRazonSocialReceptor(String razonSocialRec) {
        SessionFactory sf;
        Session sesion = null;

        List<Factura> listaFacturas = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Factura as fac where fac.razonSocialReceptor = :razonSocialRec and fac.estado=1");
            q.setString("razonSocialRec", razonSocialRec);
            listaFacturas = (List<Factura>) q.list();
            
        } catch (Exception e) {

            throw new RuntimeException("No se pudo obtener la factura: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
           
        }
        return listaFacturas;
    }
    
    public List<Factura> buscarFacturaFechaEmision(Date fechaEmision) {
        SessionFactory sf;
        Session sesion = null;

        List<Factura> listaFacturas = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Factura as fac where fac.fechaEmision = :fechaEmision and fac.estado=1");
            q.setDate("fechaEmision", fechaEmision);
            listaFacturas = (List<Factura>) q.list();
            
        } catch (Exception e) {

            throw new RuntimeException("No se pudo obtener la factura: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
           
        }
        return listaFacturas;
    }
    
    public void guardarFactura(String razonSocialEmisor, Integer nitEmisor, String razonSocialReceptor, Integer nitReceptor, Date fechaEmision, String descripcionItem, Integer cantidadItem, BigDecimal valorUnitarioItem, BigDecimal valorNetoSinIva, BigDecimal valorIva, BigDecimal valorTotal, Integer estado){
    
        SessionFactory sf;
        Session sesion = null;
        
        try {
            Factura factura = new Factura(razonSocialEmisor, nitEmisor, razonSocialReceptor, nitReceptor, fechaEmision, descripcionItem, cantidadItem, valorUnitarioItem, valorNetoSinIva, valorIva, valorTotal, estado);
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            
            sesion.save(factura);

            sesion.getTransaction().commit();
            
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar la factura: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
           
        }
    }
        
}
