/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Estadoi;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Sebastian
 */
@Stateless
public class EstadoiFacade extends AbstractFacade<Estadoi> implements EstadoiFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoiFacade() {
        super(Estadoi.class);
    }
    
    @Override
    public Estadoi findByNombre(String nombre) {

        Estadoi retorno = null;
        try {
            Query q = em.createNamedQuery("Estadoi.findByNombre", Estadoi.class).setParameter("nombre", nombre);
            retorno = (Estadoi) q.getSingleResult();
        } catch (IllegalArgumentException e) {
            retorno = null;
        } catch (NoResultException e) {
            retorno = null;
        } catch (NonUniqueResultException e) {
            retorno = null;
        } catch (IllegalStateException e) {
            retorno = null;
        } catch (QueryTimeoutException e) {
            retorno = null;
        } catch (TransactionRequiredException e) {
            retorno = null;
        } catch (PessimisticLockException e) {
            retorno = null;
        } catch (LockTimeoutException e) {
            retorno = null;
        } catch (PersistenceException e) {
            retorno = null;
        }
        if (retorno == null) {
            return null;
        } else {
            return retorno;
        }
    }
}
