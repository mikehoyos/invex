package com.pba.invex.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Miguel hoyos
 * BusinessExeptions para el manejo de errores de negocio, validacioness por parámetros, etc.
 */

@Data
public class BusinessExeptions extends RuntimeException{
    private String code;
    private HttpStatus status;

    /**
     *
     * @param code codigo del error
     * @param status status del Http
     * @param message mensaje de error generado
     */
    public BusinessExeptions(String code,  HttpStatus status, String message){
        super(message);
        this.code = code;
        this.status = status;
    }
}
