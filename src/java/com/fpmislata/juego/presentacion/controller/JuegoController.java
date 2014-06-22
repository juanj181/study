/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.juego.presentacion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.juego.datos.JugadorDAO;
import com.fpmislata.juego.datos.JugadorDAOImplHibernate;
import com.fpmislata.juego.datos.PreguntaDAO;
import com.fpmislata.juego.datos.PreguntaDAOImplHibernate;
import com.fpmislata.juego.negocio.ComprobacionRespuesta;
import com.fpmislata.juego.negocio.Jugador;
import com.fpmislata.juego.negocio.Pregunta;
import com.fpmislata.juego.negocio.ResponderPregunta;
import com.fpmislata.juego.negocio.RetornoIdPregunta;
import com.fpmislata.juego.negocio.RetornoPreguntas;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alumno
 */
@Controller
public class JuegoController {

    PreguntaDAO preguntaDao = new PreguntaDAOImplHibernate();
    JugadorDAO jugadorDAO = new JugadorDAOImplHibernate();
    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/api/pregunta", method = RequestMethod.GET, produces = "application/json")
    public void readAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.setContentType("application/json, charset=UTF-8");
            List<Pregunta> listaPreguntas = preguntaDao.findPreguntas();
            RetornoPreguntas retorno = new RetornoPreguntas();
            List<RetornoPreguntas> listadeRetorno = (List<RetornoPreguntas>) new RetornoPreguntas();
            if (listadeRetorno == null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
            } else {
                for (Pregunta pregunta : listaPreguntas) {
                    int i = 0;
                    retorno.setIdPregunta(pregunta.getIdPregunta());
                    retorno.setPregunta(pregunta.getPregunta());
                    listadeRetorno.add(retorno);
                }
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                
                String jason = objectMapper.writeValueAsString(listadeRetorno);
                httpServletResponse.getWriter().println(jason);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @RequestMapping(value = "/api/juego/{nombre}", method = RequestMethod.POST, produces = "application/json")
    public void iniciarJuego(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable String nombre) {
        try {
            Jugador jugador = jugadorDAO.findByNombre(nombre);
            httpServletResponse.setContentType("application/json,charset=UTF-8");
            if (jugador == null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
            } else {
                if (jugador.getIdPreguntaActual() > 0) {
                    int idPregunta = jugador.getIdPreguntaActual();
                    idPregunta++;
                    jugador.setIdPreguntaActual(idPregunta);
                } else {
                    jugador.setIdPreguntaActual(0);
                }

                RetornoIdPregunta retornoIdPregunta = new RetornoIdPregunta();

                retornoIdPregunta.setIdPreguntaActual(jugador.getIdPreguntaActual());
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                
                String jason = objectMapper.writeValueAsString(retornoIdPregunta);
                httpServletResponse.getWriter().println(jason);
                jugadorDAO.update(jugador);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @RequestMapping(value = "/api/juego", method = RequestMethod.PUT, produces = "application/json")
    public void responderPregunta(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {
        try {
            httpServletResponse.setContentType("application/json,charset=UTF-8");
            ResponderPregunta responderPregunta = objectMapper.readValue(json, ResponderPregunta.class);
            Jugador jugador = jugadorDAO.findByNombre(responderPregunta.getNombre());
            int idPregunta = jugador.getIdPreguntaActual();
            Pregunta pregunta = preguntaDao.findPreguntaById(idPregunta);
            ComprobacionRespuesta comprobacionRespuesta = new ComprobacionRespuesta();

            if (jugador.getIdPreguntaActual() == pregunta.getIdPregunta() && responderPregunta.getRespuesta().equals(pregunta.getRespuesta())) {
                comprobacionRespuesta.setIdPreguntaActual(jugador.getIdPreguntaActual());
                comprobacionRespuesta.setCorrecta(true);
            } else {
                comprobacionRespuesta.setIdPreguntaActual(jugador.getIdPreguntaActual());
                comprobacionRespuesta.setCorrecta(false);
            }
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            
            String jason = objectMapper.writeValueAsString(comprobacionRespuesta);
            httpServletResponse.getWriter().println(jason);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
