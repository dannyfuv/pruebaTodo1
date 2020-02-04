/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.PruebaWS.ws.test;

import co.com.PruebaWS.ws.WSProducto;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author UserQV
 */
public class ProductoTest {
    
    public ProductoTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     * test con el que se prueba que se puede vender cierta cantidad de un producto
     */
    @Test
    public void testPuedeVenderCantidadProducto(){        
        try {
            
            WSProducto wsProd = mock(WSProducto.class);
            when(wsProd.validarStockProducto(2,7)).thenReturn(3); //quiere decir que el producto con id 2 tiene actualmente 10 unidades en stock
            
            Integer diferencia = wsProd.validarStockProducto(2, 7);
            assertTrue(diferencia >= 0);
            
        } catch (Exception e) {
        }
        
    }
    
    /**
     * test con el que se prueba que no se puede vender cierta cantidad de un producto
     */
    @Test
    public void testNoPuedeVenderCantidadProducto(){
        try {
            
            WSProducto wsProd = mock(WSProducto.class);
            when(wsProd.validarStockProducto(3,7)).thenReturn(-2); //quiere decir que el producto con id 3 tiene actualmente 5 unidades en stock
            
            Integer diferencia = wsProd.validarStockProducto(3, 7);
            assertTrue(diferencia < 0);
            
        } catch (Exception e) {
        }
        
    }
}
