/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.juego.negocio;

/**
 *
 * @author Lorenzo
 */
public class Jugador {
    private int idJugador;
    private String nombre;
    private int idPreguntaActual=0;

    /**
     * @return the idJugador
     */
    public int getIdJugador() {
        return idJugador;
    }

    /**
     * @param idJugador the idJugador to set
     */
    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idPreguntaActual
     */
    public int getIdPreguntaActual() {
        return idPreguntaActual;
    }

    /**
     * @param idPreguntaActual the idPreguntaActual to set
     */
    public void setIdPreguntaActual(int idPreguntaActual) {
        this.idPreguntaActual = idPreguntaActual;
    }

 
}
