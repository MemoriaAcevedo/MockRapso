/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Operacion;
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
public class OperacionFacade extends AbstractFacade<Operacion> implements OperacionFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionFacade() {
        super(Operacion.class);
    }

    @Override
    public String registrarOperacion(Operacion op) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Operacion (operacion, montoOp, fechaOp, saldoFinal, realizador, rutR, rutRE, tipoO)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)")
                    .setParameter(1, op.getOperacion())
                    .setParameter(2, op.getMontoOp())
                    .setParameter(3, op.getFechaOp())
                    .setParameter(4, op.getSaldoFinal())
                    .setParameter(5, op.getRealizador().getIdC())
                    .setParameter(6, op.getRutR())
                    .setParameter(7, op.getRutRE())
                    .setParameter(8, op.getTipoO())
                    .executeUpdate();
            retorno = "true";
        } catch (IllegalArgumentException e) {
            retorno = "false";
        } catch (TransactionRequiredException e) {
            retorno = "false";
        } catch (QueryTimeoutException e) {
            retorno = "false";
        } catch (LockTimeoutException e) {
            retorno = "false";
        } catch (PersistenceException e) {
            retorno = "false";
        }
        return retorno;
    }

}
