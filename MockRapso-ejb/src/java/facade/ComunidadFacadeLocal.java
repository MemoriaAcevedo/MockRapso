/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Comunidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface ComunidadFacadeLocal {

    void create(Comunidad comunidad);

    void edit(Comunidad comunidad);

    void remove(Comunidad comunidad);

    Comunidad find(Object id);

    List<Comunidad> findAll();

    List<Comunidad> findRange(int[] range);

    int count();
    
    Comunidad findByNombre(String nombre);
    
    String createComunidad(Comunidad c);

    String editarComunidad(Comunidad c);
    
}
