/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juego.datos;

import com.fpmislata.juego.negocio.Jugador;
import java.io.Serializable;

/**
 *
 * @author alumno
 */
public interface JugadorDAO extends GenericDAO<Jugador, Integer>{
    public Jugador findByNombre(String nombre);
}
