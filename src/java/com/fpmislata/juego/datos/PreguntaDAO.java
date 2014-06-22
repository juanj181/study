/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juego.datos;

import com.fpmislata.juego.negocio.Pregunta;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface PreguntaDAO extends GenericDAO<Pregunta, Integer>{
    public List<Pregunta> findPreguntas();
    public Pregunta findPreguntaById(int idPregunta);
}
