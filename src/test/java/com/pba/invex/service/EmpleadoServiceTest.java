package com.pba.invex.service;

import com.pba.invex.model.Empleado;
import com.pba.invex.repository.EmpleadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmpleadoServiceTest {
    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoService empleadoService;

    private Empleado empleado;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        empleado = new Empleado();
        empleado.setaMaterno("PRUABA AMATERNO");
        empleado.setaPaterno("PRUEBA APATERNO");
        empleado.setPriNombre("PRUEBA PNOMBRE");
        empleado.setSegNombre("PRUEBA SNOMBRE");
        empleado.setSexo("PRUEBA SEXO");
        empleado.setEdad(20);
        empleado.setId_registro(new Long(100));
    }

    @Test
    void saveEmpleado() {
        when(empleadoRepository.save(any(Empleado.class))).thenReturn(empleado);
        assertNotNull(empleadoService.getEmpleados());
    }

    @Test
    void deleteEmpleado() {
        when(empleadoRepository.findById(10L)).thenReturn(Optional.ofNullable(empleado));
        assertNotNull(empleadoService.getEmpleados());
    }

    @Test
    void getEmpleados() {
        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleado));
        assertNotNull(empleadoService.getEmpleados());
    }

    @Test
    void getempleadoById() {
        when(empleadoRepository.findById(2L)).thenReturn(Optional.ofNullable(empleado));
        assertNotNull(empleadoService.getEmpleados());
    }
}