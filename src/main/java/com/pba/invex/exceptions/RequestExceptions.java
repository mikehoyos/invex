package com.pba.invex.exceptions;

import lombok.Builder;
import lombok.Data;
/**
 * @author Miguel hoyos
 * BusinessExeptions para el manejo de errores, runtime.
 */

@Data
@Builder
public class RequestExceptions extends RuntimeException {
    private String code;
    private String message;

    /**
     *
     * @param code error dodigo
     * @param message mensaje de error
     */
    public RequestExceptions(String code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
