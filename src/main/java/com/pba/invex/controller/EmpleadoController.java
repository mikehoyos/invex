package com.pba.invex.controller;
/**
 * Controller principal en los cuales estan los metodos para consumir la API
 * @author Miguel Hoyos
 */

import com.pba.invex.exceptions.RequestExceptions;
import com.pba.invex.model.Empleado;
import com.pba.invex.service.EmpleadoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api")
public class EmpleadoController {
    /**
     * @aparam /empleados obtiene todos los registros de la tabla
     * @aparam /guardar guarda registros por entidad o lista
     * @aparam /actualizar actualiza solamente un registro en caso de que exista en tabla
     * @aparam //empleado/{id} borra un registro oir id
     * @author Miguel Hoyos
     */
    public static final Logger log = LogManager.getLogger(EmpleadoController.class);
    @Autowired
    EmpleadoService empleadoService;

    /**
     * @param no recibe parametro
     * @response regresa una Lista de entidad de empleado empleados
     */
    @GetMapping("/empleados")
    @ResponseBody
    public List<Empleado> getEmpleados(){
        log.info("Se ejecuta el método getEmpleados");
        return empleadoService.getEmpleados();
    }

    /**
     * @param recibe parametro Lista de empleados
     * @response regresa una Lista de entidad de empleado empleados
     */
    @PostMapping("/guardar")
    @ResponseBody
    public List<Empleado> saveEmpleado(@RequestBody List<Empleado> empleados){
        log.info("Se ejecuta el método saveEmpleado");
        return empleadoService.saveEmpleado(empleados);
    }

    /**
     * @param recibe parametro entidad de empleados
     * @response regresa un respons entity generico
     */
    @PutMapping("/actualizar")
    public ResponseEntity updateEmpleado(@RequestBody Empleado empleado){
        log.info("Se ejecuta el método updateEmpleado");
        Empleado nvo_empleado = empleadoService.updateEmpleado(empleado);
        HashMap<String, Boolean> status = new HashMap<>();
        status.put("Empleado actualizado con id: "+empleado.getId_registro(),true);
        return ResponseEntity.ok(status);
    }

    /**
     * @param recibe parametro id de empleados
     * @response regresa un response entity generico
     */
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity deleteEmpleado(@PathVariable Long id){
        log.info("Se ejecuta el método deleteEmpleado");
        if(id == 0L ){
            log.error("ID es requerdio");
            throw new RequestExceptions("E-400","ID es requerido");
        }
         empleadoService.deleteEmpleado(id);
        HashMap<String, Boolean> status = new HashMap<>();
        status.put("Empleado eliminado con id: "+id,true);
        return ResponseEntity.ok(status);
    }
}
