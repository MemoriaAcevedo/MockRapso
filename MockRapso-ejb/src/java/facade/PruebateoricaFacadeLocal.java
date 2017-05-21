/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Pruebateorica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface PruebateoricaFacadeLocal {

    void create(Pruebateorica pruebateorica);

    void edit(Pruebateorica pruebateorica);

    void remove(Pruebateorica pruebateorica);

    Pruebateorica find(Object id);

    List<Pruebateorica> findAll();

    List<Pruebateorica> findRange(int[] range);

    int count();

    String crearPruebaTeorica(Pruebateorica p);

    String editarPruebaTeorica(Pruebateorica p);

}
