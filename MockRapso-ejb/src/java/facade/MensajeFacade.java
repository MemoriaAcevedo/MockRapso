/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Mensaje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Sebastian
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> implements MensajeFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }
    
    @Override
    public String createMensaje(Mensaje m) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Mensaje (mensaje, fechaRealizado, Practica_idPractica, realizador)" + " VALUES(?, ?, ?, ?)")
                    .setParameter(1, m.getMensaje())
                    .setParameter(2, m.getFechaRealizado())
                    .setParameter(3, m.getPracticaidPractica().getIdPractica())
                    .setParameter(4, m.getRealizador().getIdUsuario())
                    .executeUpdate();
            retorno = "t";
        } catch (IllegalArgumentException e) {
            retorno = "f";
        } catch (TransactionRequiredException e) {
            retorno = "f";
        } catch (QueryTimeoutException e) {
            retorno = "f";
        } catch (LockTimeoutException e) {
            retorno = "f";
        } catch (PersistenceException e) {
            retorno = "f";
        }
        return retorno;
    }
    
}
