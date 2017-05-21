/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Comunidadasociado;
import java.util.List;
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
public class ComunidadasociadoFacade extends AbstractFacade<Comunidadasociado> implements ComunidadasociadoFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComunidadasociadoFacade() {
        super(Comunidadasociado.class);
    }
    
    @Override
    public Comunidadasociado findByCA(int idC, int idA) {

        Comunidadasociado retorno = null;
        try {
            Query q = em.createNamedQuery("Comunidadasociado.findByCA", Comunidadasociado.class).setParameter("comunidadidComunidad", idC).setParameter("usuarioAA", idA);
            retorno = (Comunidadasociado) q.getSingleResult();
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

    @Override
    public List<Comunidadasociado> findByC(int idC) {

        List<Comunidadasociado> retorno = null;
        try {
            Query q = em.createNamedQuery("Comunidadasociado.findByComunidadidComunidad", Comunidadasociado.class).setParameter("comunidadidComunidad", idC);
            retorno = q.getResultList();
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

    @Override
    public List<Comunidadasociado> findByA(int idA) {

        List<Comunidadasociado> retorno = null;
        try {
            Query q = em.createNamedQuery("Comunidadasociado.findByUsuarioAA", Comunidadasociado.class).setParameter("usuarioAA", idA);
            retorno = q.getResultList();
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
