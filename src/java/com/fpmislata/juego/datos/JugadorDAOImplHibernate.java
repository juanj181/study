/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juego.datos;

import com.fpmislata.juego.negocio.Jugador;
import com.fpmislata.juego.negocio.Pregunta;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.web.jsf.FacesContextUtils;

/**
 *
 * @author alumno
 */
public class JugadorDAOImplHibernate extends GenericDAOImplHibernate<Jugador, Integer> implements JugadorDAO {

    SessionFactory sessionFactory;

    @Override
    public Jugador findByNombre(String nombre) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT jugador FROM Jugador jugador WHERE nombre=?");
        query.setString(0, nombre);
        Jugador jugador = (Jugador) query.uniqueResult();
        session.getTransaction().commit();
        return jugador;
    }
}
