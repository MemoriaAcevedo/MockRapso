/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Incidenciacp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface IncidenciacpFacadeLocal {

    void create(Incidenciacp incidenciacp);

    void edit(Incidenciacp incidenciacp);

    void remove(Incidenciacp incidenciacp);

    Incidenciacp find(Object id);

    List<Incidenciacp> findAll();

    List<Incidenciacp> findRange(int[] range);

    int count();
    
    String createIncidenciacp(Incidenciacp i);
    
    String editIncidenciacp(Incidenciacp i);
    
    String eliminarIncidenciacp(int idI);
    
}
