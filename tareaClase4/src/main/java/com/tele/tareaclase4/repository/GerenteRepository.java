package com.tele.tareaclase4.repository;

import com.tele.tareaclase4.DTO.GerenteDTO;
import com.tele.tareaclase4.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerenteRepository extends JpaRepository<Department, Integer> {

    @Query(value = "SELECT d.department_name AS nombre_departamento, " +
            "e.first_name AS nombre_gerente, " +
            "e.last_name AS apellido_gerente, " +
            "e.salary AS salario_gerente " +
            "FROM departments d " +
            "JOIN employees e ON d.manager_id = e.employee_id " +
            "WHERE TIMESTAMPDIFF(YEAR, e.hire_date, CURDATE()) > 5",
            nativeQuery = true)
    List<GerenteDTO> obtenerGerentesConExperiencia();
}
