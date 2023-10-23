package com.pba.invex.exceptions;

import lombok.Builder;
import lombok.Data;

/**
 * @author Miguel Hoyos
 * Clase para el manejo de errores con excepciones
 */
@Data
@Builder
public class ErrorVO {
    private String code;
    private String message;
}
