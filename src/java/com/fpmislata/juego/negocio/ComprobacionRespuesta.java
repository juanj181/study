/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juego.negocio;

/**
 *
 * @author alumno
 */
public class ComprobacionRespuesta {
    int idPreguntaActual;
    boolean correcta;

    public ComprobacionRespuesta() {
    }

    public ComprobacionRespuesta(int idPreguntaActual, boolean correcta) {
        this.idPreguntaActual = idPreguntaActual;
        this.correcta = correcta;
    }

    public int getIdPreguntaActual() {
        return idPreguntaActual;
    }

    public void setIdPreguntaActual(int idPreguntaActual) {
        this.idPreguntaActual = idPreguntaActual;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }
    
}
