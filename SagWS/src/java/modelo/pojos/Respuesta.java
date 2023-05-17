package modelo.pojos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yadelí López
 */
public class Respuesta {
    private boolean error;
    private String mensaje;
    private Object respuesta;

    public Respuesta() {
    }

    public Respuesta(boolean error, String mensaje, Object respuesta) {
        this.error = error;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
    }

    public boolean isError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Object getRespuesta() {
        return respuesta;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setRespuesta(Object respuesta) {
        this.respuesta = respuesta;
    }
}
