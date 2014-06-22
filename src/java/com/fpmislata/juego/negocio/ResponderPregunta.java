/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juego.negocio;

/**
 *
 * @author alumno
 */
public class ResponderPregunta {
    String nombre;
    String respuesta;

    public ResponderPregunta() {
    }

    public ResponderPregunta(String nombre, String respuesta) {
        this.nombre = nombre;
        this.respuesta = respuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
