/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Practica1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Sebastian
 */
@Stateless
public class Practica1Facade extends AbstractFacade<Practica1> implements Practica1FacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Practica1Facade() {
        super(Practica1.class);
    }

    @Override
    public String createPractica1(Practica1 p) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Practica1 (fechaInicio, calificacion, observacion, practica)" + " VALUES(?, ?, ?, ?)")
                    .setParameter(1, p.getFechaInicio())
                    .setParameter(2, p.getCalificacion())
                    .setParameter(3, p.getObservacion())
                    .setParameter(4, p.getPractica().getIdPractica())
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

    @Override
    public String evaluarP1(Practica1 p) {
        String retorno = "f";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Practica1 SET calificacion = ?, observacion = ?, fechaTermino = ?"
                    + " WHERE idPractica1 = ?");
            int updateCount = query.setParameter(1, p.getCalificacion())
                    .setParameter(2, p.getObservacion())
                    .setParameter(3, p.getFechaTermino())
                    .setParameter(4, p.getIdPractica1())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(p);
                return "t";
            } else {
                return "f";
            }
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
