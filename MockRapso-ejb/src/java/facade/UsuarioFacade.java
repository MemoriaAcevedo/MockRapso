/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public String editUser(Usuario newU) {
        String retorno = "false";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Usuario SET apodoU = ?, contrasenaU = ? , fotoPerfilU = ?, fechaEdicionU = ?, Estado_idEstado = ?, TipoUsuario_idTipoUsuario = ?, motivoC = ?"
                    + " WHERE emailU = ?");
            int updateCount = query.setParameter(1, newU.getApodoU())
                    .setParameter(2, newU.getContrasenaU())
                    .setParameter(3, newU.getFotoPerfilU())
                    .setParameter(4, newU.getFechaEdicionU())
                    .setParameter(5, newU.getEstadoidEstado().getIdEstado())
                    .setParameter(6, newU.getTipoUsuarioidTipoUsuario().getIdTipoUsuario())
                    .setParameter(7, newU.getMotivoC())
                    .setParameter(8, newU.getEmailU())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(newU);
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
    public String createUser(Usuario newU) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Usuario (emailU, rutU, nombreU, apellidoU, apodoU, contrasenaU, fotoPerfilU, fechaCreacionU, fechaEdicionU, preguntaU, respuestaU, motivoC, Estado_idEstado, TipoUsuario_idTipoUsuario)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                    .setParameter(1, newU.getEmailU())
                    .setParameter(2, newU.getRutU())
                    .setParameter(3, newU.getNombreU())
                    .setParameter(4, newU.getApellidoU())
                    .setParameter(5, newU.getApodoU())
                    .setParameter(6, newU.getContrasenaU())
                    .setParameter(7, newU.getFotoPerfilU())
                    .setParameter(8, newU.getFechaCreacionU())
                    .setParameter(9, newU.getFechaEdicionU())
                    .setParameter(10, newU.getPreguntaU())
                    .setParameter(11, newU.getRespuestaU())
                    .setParameter(12, newU.getMotivoC())
                    .setParameter(13, newU.getEstadoidEstado().getIdEstado())
                    .setParameter(14, newU.getTipoUsuarioidTipoUsuario().getIdTipoUsuario())
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
    public Usuario findByEmail(String email) {

        Usuario retorno = null;
        try {
            Query q = em.createNamedQuery("Usuario.findByEmailU", Usuario.class).setParameter("emailU", email);
            retorno = (Usuario) q.getSingleResult();
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
    public Usuario findByRut(String rut) {

        Usuario retorno = null;
        try {
            Query q = em.createNamedQuery("Usuario.findByRutU", Usuario.class).setParameter("rutU", rut);
            retorno = (Usuario) q.getSingleResult();
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
    public String deleteUser(String rut) {
        String retorno;
        try {
            Query query = em.createNativeQuery(
                    "DELETE FROM Usuario WHERE rutU = ?");
            int crea = query.setParameter(1, rut)
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
