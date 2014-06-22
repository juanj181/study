/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juego.datos;

import com.fpmislata.juego.negocio.Jugador;
import com.fpmislata.juego.negocio.Pregunta;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno
 */
public class PreguntaDAOImplHibernate extends GenericDAOImplHibernate<Pregunta, Integer> implements PreguntaDAO{

    SessionFactory sessionFactory;

    @Override
    public List<Pregunta> findPreguntas() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT pregunta FROM Pregunta pregunta");

        List<Pregunta>listaPreguntas =  query.list();
        session.getTransaction().commit();
        return listaPreguntas;
    }

    @Override
    public Pregunta findPreguntaById(int idPregunta) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT pregunta FROM Pregunta pregunta WHERE idPregunta=?");
        query.setInteger(0, idPregunta);
        Pregunta pregunta =  (Pregunta) query.uniqueResult();
        session.getTransaction().commit();
        return pregunta;
    }
}
