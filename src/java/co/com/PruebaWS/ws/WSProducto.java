/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.PruebaWS.ws;

import co.com.PruebaWS.dao.ProductoDAO;
import co.com.PruebaWS.entidades.Producto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author UserQV
 */
@WebService(serviceName = "WSProducto")
public class WSProducto {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    /**
     *
     * @return listado de facturas que se crearon en la fecha indicada y estan en estado activo (1)
     * @throws Exception
     */
    @WebMethod(operationName = "consultarListadoProducto")
    public List<Producto> consultarListadoProducto() throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            ProductoDAO dao = new ProductoDAO();
            lista = dao.listadoProducto();
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
        return lista;
    }
    
    /**
     *
     * @param descripcion criterio de búsqueda, descripción del producto
     * @return listado de productos cuya descripción es la indicada
     * @throws Exception
     */
    @WebMethod(operationName = "buscarProductoDescripcion")
    public List<Producto> buscarProductoDescripcion(@WebParam(name = "descripcion") String descripcion) throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            ProductoDAO dao = new ProductoDAO();
            lista = dao.buscarProductoDescripcion(descripcion);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
        return lista;
    }
    
    /**
     *
     * @param tipo criterio de búsqueda, tipo del producto
     * @return listado de productos cuyo tipo es el indicado
     * @throws Exception
     */
    @WebMethod(operationName = "buscarProductosTipo")
    public List<Producto> buscarProductosTipo(@WebParam(name = "tipo") String tipo) throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            ProductoDAO dao = new ProductoDAO();
            lista = dao.buscarProductosTipo(tipo);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
        return lista;
    }
    
    /**
     * 
     * @param descripcion descripción del producto (Nombre)
     * @param cantidad_stock cantidad del producto
     * @param precio_unidad precio por unidad
     * @param tipo si es MARVEL o DC-COMICS
     * @param estado estado del producto activo (1) inactivo (0)
     * @throws Exception 
     */
    @WebMethod(operationName = "guardarProducto")
    public void guardarProducto(@WebParam(name = "descripcion") String descripcion,
                                @WebParam(name = "cantidad_stock") Integer cantidad_stock,
                                @WebParam(name = "precio_unidad") BigDecimal precio_unidad,
                                @WebParam(name = "tipo") String tipo,
                                @WebParam(name = "estado") Integer estado) throws Exception{
        
        try {
            ProductoDAO dao = new ProductoDAO();
            dao.guardarProducto(descripcion, cantidad_stock, precio_unidad, tipo, estado);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error: "+ex.getMessage());
        }
    
    }
    
    /**
     *
     * @param idProducto id del producto que se requiere actualizar
     * @param cantidadQueda cantidad que se debe actualizar al producto (lo que queda después de una venta)
     * @return listado de productos cuyo tipo es el indicado
     * @throws Exception
     */
    @WebMethod(operationName = "actualizarStockProducto")
    public String actualizarStockProducto(@WebParam(name = "idProducto") Integer idProducto,
                                          @WebParam(name = "cantidadQueda") Integer cantidadQueda) throws Exception {
        String mensaje = null;
        try {
            ProductoDAO dao = new ProductoDAO();
            mensaje = dao.actualizarStockProducto(idProducto, cantidadQueda);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
        return mensaje;
    }
    
    /**
     *
     * @param idProducto id del producto al que se requiere validar stock
     * @param cantidadAVender cantidad que se desea vender del producto
     * @return la diferencia entre el stock actual y lo que se quiere vender, si
     * diferencia >= 0 quiere decir que se puede vender esa cantidad, de lo contrario no,
     * la diferencia es el valor que debería quedar en el stock después de la venta
     * @throws Exception
     */
    @WebMethod(operationName = "validarStockProducto")
    public Integer validarStockProducto(@WebParam(name = "idProducto") Integer idProducto,
                                          @WebParam(name = "cantidadAVender") Integer cantidadAVender) throws Exception {
        Integer diferencia = null;
        try {
            ProductoDAO dao = new ProductoDAO();
            diferencia = dao.validarStockProducto(idProducto, cantidadAVender);
        } catch (Exception ex) {
            throw new Exception("ocurrio un error:"+ex.getMessage());
        }
        return diferencia;
    }
    
}
