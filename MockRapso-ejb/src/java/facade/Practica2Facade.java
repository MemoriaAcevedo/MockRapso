/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Practica2;
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
public class Practica2Facade extends AbstractFacade<Practica2> implements Practica2FacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Practica2Facade() {
        super(Practica2.class);
    }
    
    @Override
    public String createPractica2(Practica2 p) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Practica2 (fechaInicio, calificacion, observacion, urlGithub, urlCodenvy, tutorial, practica)" + " VALUES(?, ?, ?, ?, ?, ?, ?)")
                    .setParameter(1, p.getFechaInicio())
                    .setParameter(2, p.getCalificacion())
                    .setParameter(3, p.getObservacion())
                    .setParameter(4, p.getUrlGithub())
                    .setParameter(5, p.getUrlCodenvy())
                    .setParameter(6, p.getTutorial())
                    .setParameter(7, p.getPractica().getIdPractica())
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
    public String guardarAR(Practica2 p) {
        String retorno = "f";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Practica2 SET urlGithub = ?, urlCodenvy = ? "
                    + " WHERE idPractica2 = ?");
            int updateCount = query.setParameter(1,p.getUrlGithub()).setParameter(2,p.getUrlCodenvy()).setParameter(3, p.getIdPractica2())
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
    
    @Override
    public String evaluarP2(Practica2 p) {
        String retorno = "f";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Practica2 SET calificacion = ?, observacion = ?, fechaTermino = ?"
                    + " WHERE idPractica2 = ?");
            int updateCount = query.setParameter(1, p.getCalificacion())
                    .setParameter(2, p.getObservacion())
                    .setParameter(3, p.getFechaTermino())
                    .setParameter(4, p.getIdPractica2())
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
