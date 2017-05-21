/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Practica;
import entities.Practica1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface PracticaFacadeLocal {

    void create(Practica practica);

    void edit(Practica practica);

    void remove(Practica practica);

    Practica find(Object id);

    List<Practica> findAll();

    List<Practica> findRange(int[] range);

    int count();
    
    String createPractica(Practica p);

    String eliminarPractica(int idP);
    
    String correccionPractica(Practica p);
    
    String finalizarPractica(Practica p);
}
