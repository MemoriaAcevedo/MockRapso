/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Practica2;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface Practica2FacadeLocal {

    void create(Practica2 practica2);

    void edit(Practica2 practica2);

    void remove(Practica2 practica2);

    Practica2 find(Object id);

    List<Practica2> findAll();

    List<Practica2> findRange(int[] range);

    int count();
    
    String createPractica2(Practica2 p);
    
    String guardarAR(Practica2 p);
    
    String evaluarP2(Practica2 p);
}
