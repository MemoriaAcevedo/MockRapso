/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Practica1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface Practica1FacadeLocal {

    void create(Practica1 practica1);

    void edit(Practica1 practica1);

    void remove(Practica1 practica1);

    Practica1 find(Object id);

    List<Practica1> findAll();

    List<Practica1> findRange(int[] range);

    int count();

    String createPractica1(Practica1 p);

    String evaluarP1(Practica1 p);

}
