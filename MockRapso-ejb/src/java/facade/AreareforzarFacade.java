/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Area;
import entities.Areareforzar;
import entities.Pruebateorica;
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
public class AreareforzarFacade extends AbstractFacade<Areareforzar> implements AreareforzarFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreareforzarFacade() {
        super(Areareforzar.class);
    }

    @Override
    public String crearAreaReforzar(Area a, Pruebateorica p) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Areareforzar (area, pruebaTeorica)" + " VALUES(?, ?)")
                    .setParameter(1, a.getIdArea())
                    .setParameter(2, p.getIdPT())
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
    public String deleteAreaReforzar(int pt) {
        String retorno;
        try {
            Query query = em.createNativeQuery(
                    "DELETE FROM Areareforzar WHERE pruebaTeorica = ?");
            int crea = query.setParameter(1, pt)
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
