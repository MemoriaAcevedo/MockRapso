/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Cuenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface CuentaFacadeLocal {

    void create(Cuenta cuenta);

    void edit(Cuenta cuenta);

    void remove(Cuenta cuenta);

    Cuenta find(Object id);

    List<Cuenta> findAll();

    List<Cuenta> findRange(int[] range);

    int count();
    
    List<Cuenta> findByTipoC(String tipo);

    String drt(Cuenta c);

    String updateEstado(Cuenta c);

    String createCuenta(Cuenta c);
    
}
