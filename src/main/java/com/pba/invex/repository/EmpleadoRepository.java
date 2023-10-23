package com.pba.invex.repository;

import com.pba.invex.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Miguel hoyos
 * Interface que usa los metodos default de JjaRepository
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {


}
