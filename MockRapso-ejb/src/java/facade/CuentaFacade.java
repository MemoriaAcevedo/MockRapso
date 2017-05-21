/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Cuenta;
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
public class CuentaFacade extends AbstractFacade<Cuenta> implements CuentaFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }
    
    @Override
    public List<Cuenta> findByTipoC(String tipo) {

        List<Cuenta> retorno = null;
        try {
            Query q = em.createNamedQuery("Cuenta.findByTipoC", Cuenta.class).setParameter("tipoC", tipo);
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
    public String drt(Cuenta c) {
        String retorno = "false";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Cuenta SET saldoC = ?"
                    + " WHERE idU = ? AND idC = ?");
            int updateCount = query.setParameter(1, c.getSaldoC())
                    .setParameter(2, c.getIdU().getIdUsuario())
                    .setParameter(3, c.getIdC())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(c);
                return "true";
            } else {
                return "false";
            }
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
    
    
    @Override
    public String updateEstado(Cuenta c) {
        String retorno = "false";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Cuenta SET estadoC = ?"
                    + " WHERE idU = ? AND idC = ?");
            int updateCount = query.setParameter(1, c.getEstadoC())
                    .setParameter(2, c.getIdU().getIdUsuario())
                    .setParameter(3, c.getIdC())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(c);
                return "true";
            } else {
                return "false";
            }
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
    
    @Override
    public String createCuenta(Cuenta c) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Cuenta (idU, saldoC, estadoC, tipoC)" + " VALUES(?, ?, ?, ?)")
                    .setParameter(1, c.getIdU().getIdUsuario())
                    .setParameter(2, c.getSaldoC())
                    .setParameter(3, c.getEstadoC())
                    .setParameter(4, c.getTipoC())
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
