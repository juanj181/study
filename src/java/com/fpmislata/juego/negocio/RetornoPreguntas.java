/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juego.negocio;

/**
 *
 * @author alumno
 */
public class RetornoPreguntas {
    int idPregunta;
    String pregunta;

    public RetornoPreguntas() {
    }

    public RetornoPreguntas(int idPregunta, String pregunta) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    
}
