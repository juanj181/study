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
public class Pregunta {
    private int idPregunta;
    private String pregunta;
    private String respuesta;

    /**
     * @return the idPregunta
     */
    public int getIdPregunta() {
        return idPregunta;
    }

    /**
     * @param idPregunta the idPregunta to set
     */
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    /**
     * @return the pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
