/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Incidencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface IncidenciaFacadeLocal {

    void create(Incidencia incidencia);

    void edit(Incidencia incidencia);

    void remove(Incidencia incidencia);

    Incidencia find(Object id);

    List<Incidencia> findAll();

    List<Incidencia> findRange(int[] range);

    int count();
    
    String createIncidencia(Incidencia i);

    String editIncidencia(Incidencia i);

    String eliminarIncidencia(int idI);
}
