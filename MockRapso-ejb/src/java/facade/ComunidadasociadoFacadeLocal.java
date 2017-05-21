/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Comunidadasociado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface ComunidadasociadoFacadeLocal {

    void create(Comunidadasociado comunidadasociado);

    void edit(Comunidadasociado comunidadasociado);

    void remove(Comunidadasociado comunidadasociado);

    Comunidadasociado find(Object id);

    List<Comunidadasociado> findAll();

    List<Comunidadasociado> findRange(int[] range);

    int count();
    
    Comunidadasociado findByCA(int idC, int idA);

    List<Comunidadasociado> findByC(int idC);

    List<Comunidadasociado> findByA(int idA);
}
