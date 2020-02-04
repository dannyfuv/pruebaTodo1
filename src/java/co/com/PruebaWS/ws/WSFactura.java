/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.PruebaWS.ws;

import co.com.PruebaWS.dao.FacturaDAO;
import co.com.PruebaWS.entidades.Factura;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author UserQV
 */
@WebService(serviceName = "WSFactura")
public class WSFactura {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    /**
     *
     * @param fechaEmision criterio de búsqueda, fecha en la que se emitio la factura
     * @return listado de facturas que se crearon en la fecha indicada y estan en estado activo (1)
     * @throws Exception
     */
    @WebMethod(operationName = "buscarFacturaFechaEmision")
    public List<Factura> buscarFacturaFechaEmision(@WebParam(name = "fechaEmision") Date fechaEmision) throws Exception {
        List<Factura> lista = new ArrayList<>();
        try {
            FacturaDAO dao = new FacturaDAO();
            lista = dao.buscarFacturaFechaEmision(fechaEmision);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
        return lista;
    }
    
    /**
     *
     * @param razonSocialRec criterio de búsqueda, razón social del receptor de la factura
     * @return listado de facturas cuya razón social del receptor es la indicada
     * @throws Exception
     */
    @WebMethod(operationName = "buscarFacturaRazonSocialReceptor")
    public List<Factura> buscarFacturaRazonSocialReceptor(@WebParam(name = "razonSocialRec") String razonSocialRec) throws Exception {
        List<Factura> lista = new ArrayList<>();
        try {
            FacturaDAO dao = new FacturaDAO();
            lista = dao.buscarFacturaRazonSocialReceptor(razonSocialRec);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
        return lista;
    }
    
    /**
     * 
     * @param nitRec criterio de búsqueda, nit receptor de la factura
     * @return listado de facturas cuyo nit receptor es el indicado
     * @throws Exception 
     */
    @WebMethod(operationName = "buscarFacturaNitReceptor")
    public List<Factura> buscarFacturaNitReceptor(@WebParam(name = "nitRec") Integer nitRec) throws Exception {
        List<Factura> lista = new ArrayList<>();
        try {
            FacturaDAO dao = new FacturaDAO();
            lista = dao.buscarFacturaNitReceptor(nitRec);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
        return lista;
    }
    
    /**
     * 
     * @param razonSocialEmisor razón social del emisor de la factura
     * @param nitEmisor nit del emisor de la factura
     * @param razonSocialReceptor razón social del receptor de la factura
     * @param nitReceptor nit del receptor de la factura
     * @param fechaEmision fecha de emisión de la factura
     * @param descripcionItem descripción del item de la factura
     * @param cantidadItem cantidad item
     * @param valorUnitarioItem valor unitario del item
     * @param valorNetoSinIva valor sin iva
     * @param valorIva valor iva
     * @param valorTotal valor total
     * @param estado estado de la factura activo (1) inactivo (0)
     * @throws Exception 
     */
    @WebMethod(operationName = "guardarFactura")
    public void guardarFactura(@WebParam(name = "razonSocialEmisor") String razonSocialEmisor,
                                @WebParam(name = "nitEmisor") Integer nitEmisor,
                                @WebParam(name = "razonSocialReceptor") String razonSocialReceptor,
                                @WebParam(name = "nitReceptor") Integer nitReceptor,
                                @WebParam(name = "fechaEmision") Date fechaEmision,
                                @WebParam(name = "descripcionItem") String descripcionItem,
                                @WebParam(name = "cantidadItem") Integer cantidadItem,
                                @WebParam(name = "valorUnitarioItem") BigDecimal valorUnitarioItem,
                                @WebParam(name = "valorNetoSinIva") BigDecimal valorNetoSinIva,
                                @WebParam(name = "valorIva") BigDecimal valorIva,
                                @WebParam(name = "valorTotal") BigDecimal valorTotal,
                                @WebParam(name = "estado") Integer estado) throws Exception{
        
        try {
            FacturaDAO dao = new FacturaDAO();
            dao.guardarFactura(razonSocialEmisor, nitEmisor, razonSocialReceptor, nitReceptor, fechaEmision, descripcionItem, cantidadItem, valorUnitarioItem, valorNetoSinIva, valorIva, valorTotal, estado);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
    
    }
}
