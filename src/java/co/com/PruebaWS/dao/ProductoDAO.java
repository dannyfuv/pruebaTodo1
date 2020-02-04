/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.PruebaWS.dao;

import co.com.PruebaWS.entidades.Producto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author UserQV
 */
public class ProductoDAO {
    public List<Producto> listadoProducto() throws Exception {
        SessionFactory sf;
        Session sesion = null;
        List<Producto> lista = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Producto as prod where prod.estado=1");
            lista = (List<Producto>) q.list();

        } catch (Exception e) {
            throw new Exception("ocurrio un problema al listar los productos: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
            
        }
        return lista;
    }
    
    public List<Producto> buscarProductoDescripcion(String descripcion) {
        SessionFactory sf;
        Session sesion = null;

        List<Producto> listaProductos = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Producto as prod where prod.descripcion = :descripcion and prod.estado=1");
            q.setString("descripcion", descripcion);
            listaProductos = (List<Producto>) q.list();
            
        } catch (Exception e) {

            throw new RuntimeException("No se pudo obtener los productos: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
           
        }
        return listaProductos;
    }
    
    public List<Producto> buscarProductosTipo(String tipo) {
        SessionFactory sf;
        Session sesion = null;

        List<Producto> listaProductos = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Producto as prod where prod.tipo = :tipo and prod.estado=1");
            q.setString("tipo", tipo);
            listaProductos = (List<Producto>) q.list();
            
        } catch (Exception e) {

            throw new RuntimeException("No se pudo obtener el producto: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
           
        }
        return listaProductos;
    }    
    
    public void guardarProducto(String descripcion, Integer cantidad_stock, BigDecimal precio_unidad, String tipo, Integer estado){
    
        SessionFactory sf;
        Session sesion = null;
        
        try {
            Producto producto = new Producto(descripcion, cantidad_stock, precio_unidad, tipo, estado);
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            
            sesion.save(producto);

            sesion.getTransaction().commit();
            
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar el producto: " + e.getMessage());
        } finally {
             if (sesion != null) {
                sesion.close();
            }
           
        }
    }
    
    public String actualizarStockProducto(Integer idProducto, Integer cantidadQueda){
        String mensaje = "Se ha actualizado el stock correctamente";
        SessionFactory sf;
        Session sesion = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            

            Query q = sesion.createQuery("from Producto as prod where prod.id = :idProducto and prod.estado=1");
            q.setInteger("idProducto", idProducto);
            List resultado = q.list();
            if (resultado != null && resultado.size() > 0) {
                Producto prodActualizar = (Producto) resultado.get(0);
                prodActualizar.setCantidad_stock(cantidadQueda);
                
                sesion.beginTransaction();
                sesion.update(prodActualizar);
                sesion.getTransaction().commit();                
            }
            
        } catch (Exception e) {
            throw new RuntimeException("No se pudo actualizar el stock del producto: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
           
        }
        return mensaje;
    }
    
    public Integer validarStockProducto(Integer idProducto, Integer cantidadVender){
        Integer puedeVender = 0;
        SessionFactory sf;
        Session sesion = null;
        Integer cantidadActualStock = 0;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Producto as prod where prod.id = :idProducto and prod.estado=1");
            q.setInteger("idProducto", idProducto);
            List resultado = q.list();
            if (resultado != null && resultado.size() > 0) {
                Producto prodEncontrado = (Producto) resultado.get(0);
                cantidadActualStock = prodEncontrado.getCantidad_stock();
                puedeVender = cantidadActualStock - cantidadVender;
                
            }          
            
        } catch (Exception e) {
            throw new RuntimeException("No se pudo validar el stock del producto: " + e.getMessage());
        } finally {
            if (sesion != null) {
                sesion.close();
            }
           
        }
        return puedeVender;                
    }
    
}
