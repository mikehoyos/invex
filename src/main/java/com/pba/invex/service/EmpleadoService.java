package com.pba.invex.service;
/**
 * @author Miguel Hoyos
 * Service para reglas de negocio
 */

import com.pba.invex.exceptions.RequestExceptions;
import com.pba.invex.model.Empleado;
import com.pba.invex.repository.EmpleadoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    public static final Logger log = LogManager.getLogger(EmpleadoService.class);
    @Autowired
    EmpleadoRepository empleadoRepository;

    /**
     * Guarda lista de empleados
     * @param empleados
     * @return Lista de empleados
     */
    public List<Empleado> saveEmpleado(List<Empleado> empleados){
        return empleadoRepository.saveAll(empleados);
    }

    /**
     * Metodo para eliminar registro de empleado mediante Id
     * @param id
     * no regresa nada, unicamente se muestra en log las acciones que realizó
     */
    public void deleteEmpleado(Long id){
        try{
            empleadoRepository.deleteById(id);
            log.info("El empleado con ID: "+id+" se ha eliminado");
        }catch(Exception e) {
            log.error("El empleado con ID: "+id+" no se ha podido eliminar");
            throw new RequestExceptions("C-405","No se encontró empleado con ID "+id);
        }
    }

    /**
     * Busca todos los regustro de la tabla para mostrarlos
     * @return lista de empleados
     */
    public List<Empleado> getEmpleados(){
        return empleadoRepository.findAll();
    }

    /**
     * Actualiza un empleado, se valida que si el empleado no se encuenra en base de datos no se guarde como nuevo registro
     * @param empleado
     * @return entidad de empleado
     */
    public Empleado updateEmpleado(Empleado empleado){
        Long idR = empleado.getId_registro();
        Empleado nvo_empleado = empleadoRepository.findById(idR).orElse(null);
        if(nvo_empleado != null)
            return empleadoRepository.save(empleado);
        else
            throw new RequestExceptions("C-410","Empleado no existe");
    }
}
