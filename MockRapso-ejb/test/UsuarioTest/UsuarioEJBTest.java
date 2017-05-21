/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioTest;

import entities.Estado;
import entities.Tipousuario;
import entities.Usuario;
import facade.UsuarioFacadeLocal;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import sessionbeans.UsuarioEJB;

/**
 *
 * @author Sebastian
 */
public class UsuarioEJBTest {

    UsuarioEJB u;
    Usuario u1;

    public UsuarioEJBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws NamingException {
        u = new UsuarioEJB();
        u1 = new Usuario();
        Estado e = new Estado();
        Tipousuario tp = new Tipousuario();
        tp.setNombreTU("Administrador");
        e.setNombreE("Abierta");
        u1.setEmailU("sebastian.acevedoc@usach.cl");
        u1.setContrasenaU("123");
        u1.setEstadoidEstado(e);
        u1.setTipoUsuarioidTipoUsuario(tp);
    }

    @Before
    public void setUp2() throws NamingException {
        u = new UsuarioEJB();
        u1 = new Usuario();
        Estado e = new Estado();
        Tipousuario tp = new Tipousuario();
        tp.setNombreTU("Ayudante");
        e.setNombreE("Abierta");
        u1.setEmailU("123@usach.cll");
        u1.setContrasenaU("123");
        u1.setEstadoidEstado(e);
        u1.setTipoUsuarioidTipoUsuario(tp);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldAutenticarseComoAdministrador() throws NamingException {

        u.usuarioFacade = Mockito.mock(UsuarioFacadeLocal.class);
        Mockito.when(u.usuarioFacade.findByEmail("sebastian.acevedoc@usach.cl")).thenReturn(u1);
        assertEquals("/home/administrador", u.login("sebastian.acevedoc@usach.cl", "123"));
    }

    @Test
    public void shouldAutenticarseComoAyudante() {
        u.usuarioFacade = Mockito.mock(UsuarioFacadeLocal.class);
        Mockito.when(u.usuarioFacade.findByEmail("123@usach.cl")).thenReturn(u1);
        assertEquals("/home/alumno", u.login("123@usach.cl", "123"));

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
